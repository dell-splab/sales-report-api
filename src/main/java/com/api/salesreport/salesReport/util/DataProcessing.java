package com.api.salesreport.salesReport.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataProcessing {

	public static void main(String[] args) {
		
		
		String strPath = "rawdata";
		
		File path = new File(strPath);
		
		File[] files = path.listFiles(File::isFile);
		
		List<String> dataList = new ArrayList<>();
		
		Map<String, List<String>> dataMap = new HashMap<>();
		
		for (File file : files) {
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {

				String itemCsv = br.readLine();
				while (itemCsv != null) {

					dataList.add(itemCsv);

					itemCsv = br.readLine();
				}
				dataList.remove(0);
				dataMap.put(file.getName(), List.copyOf(dataList));
				dataList.clear();

				
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}

		}

		
		String targetPath = "src\\main\\resources\\db\\data.sql";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetPath))) {
			
			Map<String, Boolean> valueIsString; 
			
			for (String s: dataMap.get("clients.csv")) {
				valueIsString = fillLinkedHashMap(new String[] {"ID", "NAME", "EMAIL"}, new Boolean[] {false, true, true});
				
				bw.write(getInsertSQLCommand("client", valueIsString, s.split(",")));
				bw.newLine();
				bw.newLine();
			}
			bw.newLine();
			bw.newLine();
			
			for (String s: dataMap.get("products.csv")) {
				valueIsString = fillLinkedHashMap(new String[] {"ID", "NAME", "PRICE", "CATEGORY", "DESCRIPTION"}, 
						        new Boolean[] {false, true, false, true, true});
				
				bw.write(getInsertSQLCommand("product", valueIsString, formatStringProduct(s.split(","))));
				bw.newLine();
				bw.newLine();
			}
			bw.newLine();
			
			for (String s: dataMap.get("sales.log")) {
				valueIsString = fillLinkedHashMap(new String[] {"CLIENT_ID", "PRODUCT_ID", "CREATED_AT"}, new Boolean[] {false, false, true});
				
				bw.write(getInsertSQLCommand("sale", valueIsString, s.split(",")));
				bw.newLine();
				bw.newLine();
			}
			bw.newLine();
			
			int j = 1;
			for (String s: dataMap.get("leads.csv")) {
				valueIsString = fillLinkedHashMap(new String[] {"ID", "NAME", "EMAIL", "SALES_PAGE"}, new Boolean[] {false, true, true, true});
				String[] arrayLead = new String[4];
				
				arrayLead[0] = String.valueOf(j++);
				for (int i = 1; i < arrayLead.length; i++) {
					arrayLead[i] = s.split(",")[i-1];
				}
				
				bw.write(getInsertSQLCommand("lead", valueIsString, arrayLead));
				bw.newLine();
				bw.newLine();
			}
			
			System.out.println("data.sql file created!");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getInsertSQLCommand(String dataName, Map<String, Boolean> valueIsString, String[] data) {
		StringBuilder sb = new StringBuilder();
		
		String result = "insert into " + dataName + " (";
		for (String s: valueIsString.keySet()) {
			result += s + ", ";
		}
		result += ")";
		result = result.replace(", )", ")\n");
		sb.append(result);
		
		result = "values(";
		int i = 0;
		for (String s: valueIsString.keySet()) {
			if (valueIsString.get(s)) {
				result += String.format("'%s', ", data[i++]);
			}
			else {
				result += String.format("%s, ", data[i++]);
			}
		}
		result += ");";
		result = result.replace(", );", ");");
		
		sb.append(result);

		return sb.toString();
	}
	
	public static LinkedHashMap<String, Boolean> fillLinkedHashMap(String[] str, Boolean[] bool) {
		LinkedHashMap<String, Boolean> result = new LinkedHashMap<>();
		
		for (int i = 0; i < str.length; i++) {
			result.put(str[i], bool[i]);
		}
		
		return result;
	}
	
	public static String[] formatStringProduct(String[] data) {
		
		String[] result = Arrays.copyOf(data, 6);
		if (data.length > 6) {
			String s = "";
			for (int i = 5; i < data.length; i++) {
				if (i < data.length - 1) {
					s += data[i] + ", ";
				}
				else {
					s += data[i];
				}
			}
			result[5] = s;
		}
		else if (data.length < 6) {
			for (int i = 0; i < result.length; i++) {
				if (result[i] == null) {
					result[i] = "";
				}
			}
		}
		result[2] = result[2].replace("\"R$", "").replace(".", "");
		result[3] = result[3].replace("\"", "");
		result[2] = result[2] + "." + result[3];
		result[3] = result[4];
		result[4] = result[5];
		
		return Arrays.copyOf(result, 5);
	}
	
	
}
