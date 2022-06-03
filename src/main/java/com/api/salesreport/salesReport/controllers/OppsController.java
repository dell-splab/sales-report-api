package com.api.salesreport.salesReport.controllers;

import com.api.salesreport.salesReport.dto.OppsDTO;
import com.api.salesreport.salesReport.services.OppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/opps")
public class OppsController {
	
	@Autowired
	private OppsService oppsService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<OppsDTO>> findOpps() {
		List<OppsDTO> list = oppsService.getOpps();

		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/count",method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> countOpps() {
		Integer count = oppsService.getOpps().size();

		Map<String, Object> payload = new HashMap<>();
		payload.put("count", count);

		return ResponseEntity.ok().body(payload);
	}
	

}
