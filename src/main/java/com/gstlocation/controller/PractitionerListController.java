package com.gstlocation.controller;


import com.gstlocation.model.PractitionerList;
import com.gstlocation.model.PractitionerModel;
import com.gstlocation.service.PractitionerLocationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;



@RestController
@RequestMapping(value = "/practitionerList")
public class PractitionerListController {
	@Autowired
	PractitionerLocationService practitionerlocationService;

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
	private static final Logger logger = LogManager.getLogger(PractitionerListController.class);

	@GetMapping(value = "/getList", produces = MediaType.APPLICATION_JSON_VALUE)
	public PractitionerList getPractitionerList() {
		return (practitionerlocationService.getjoblist());
	}



	@PostMapping("/getPractitionerList")
	public ResponseEntity<?> getPractitionerList(@RequestBody PractitionerModel body) {
		return	practitionerlocationService.fetchpractitionerList(body);

	}

}
