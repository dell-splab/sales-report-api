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
			
			for (String s: dataMap.get("clients.csv")) {
				bw.write(getInsertClientSQLCommand(s.split(",")));
				bw.newLine();
				bw.newLine();
			}
			bw.newLine();
			
			for (String s: dataMap.get("products.csv")) {
				
				bw.write(getInsertProductSQLCommand(formatStringProduct(s.split(","))));
				bw.newLine();
				bw.newLine();
			}
			bw.newLine();
			
			for (String s: dataMap.get("sales.log")) {
				bw.write(getInsertSaleSQLCommand(s.split(",")));
				bw.newLine();
				bw.newLine();
			}
			bw.newLine();
			
			int i = 1;
			for (String s: dataMap.get("leads.csv")) {
				bw.write(getInsertLeadSQLCommand(i++, s.split(",")));
				bw.newLine();
				bw.newLine();
			}
			
			System.out.println("data.sql file created!");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getInsertClientSQLCommand(String[] data) {
		String result = "insert into client (ID, NAME, EMAIL)\n"
				+ String.format("values(%s,'%s','%s');", data[0], data[1], data[2]);

		return result;
	}

	public static String getInsertProductSQLCommand(String[] data) {
		String result = "insert into product (ID, NAME,PRICE,CATEGORY,DESCRIPTION)\n"
				+ String.format("values(%s,'%s',%s,'%s','%s');", data[0], data[1], 
						data[2] + "." + data[3], data[4], data[5]);
		return result;
	}

	public static String getInsertSaleSQLCommand(String[] data) {
		String result = "insert into sale (CLIENT_ID, PRODUCT_ID, TIMESTAMP)\n"
				+ String.format("values(%s, %s, '%s');", data[0], data[1], data[2]);
		return result;
	}
	
	public static String getInsertLeadSQLCommand(int iD, String[] data) {
		String result = "insert into lead (ID, NAME, EMAIL, SALES_PAGE)\n"
				+ String.format("values(%s, '%s', '%s', '%s');",Integer.toString(iD), data[0], data[1], data[2]);
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
		
		return result;
	}
}
