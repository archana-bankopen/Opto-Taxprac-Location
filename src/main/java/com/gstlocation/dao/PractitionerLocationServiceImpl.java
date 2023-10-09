package com.gstlocation.dao;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.gstlocation.model.GstDto;
import com.gstlocation.model.PractitionerList;
import com.gstlocation.helper.ConvertToJson;
import com.gstlocation.model.PractitionerModel;
import com.gstlocation.repository.PractitionerLocationRepository;
import com.gstlocation.service.PractitionerLocationService;
import com.gstlocation.util.HttpRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



@Service
public class PractitionerLocationServiceImpl implements PractitionerLocationService {


	@Autowired private PractitionerLocationRepository practitionerLocationRepository;
	@Autowired
	private ObjectMapper objectMapper;
	private static final Logger logger = LogManager.getLogger(PractitionerLocationServiceImpl.class);
	@Override
	public PractitionerList getjoblist() {
		String state = "AP";
		PractitionerList plist = practitionerLocationRepository.findByState(state);
		System.out.println("Practitioner List"+plist.getId());
		return plist;
	}

	@Override
	public ResponseEntity<String> fetchpractitionerList(PractitionerModel body) {
		GstDto gstDto = new GstDto();
		try {
			String uri = "https://services.gst.gov.in/services/api/search/gstp";
			HttpRequest results = HttpRequest.post(uri)
					.header("Content-Type", "application/json")
					.send(ConvertToJson.setJsonString(body));
			String responseStr = results.body();
//			JSONArray json_arr = new JSONArray(responseStr);
//			JSONObject tmp = null;
//			for (int i = 0; i < json_arr.size(); i++) {
//				tmp = (JSONObject) json_arr.get(i);
//				System.out.println(tmp);
//			}

			return ResponseEntity.status(HttpStatus.OK).body(responseStr);
		}catch (Exception e){
			e.printStackTrace();
			return ResponseEntity.badRequest()
					.body("List not fetched");
		}
	}

}
		
	

		
