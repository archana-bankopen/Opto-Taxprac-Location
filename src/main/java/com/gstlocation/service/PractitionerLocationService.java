package com.gstlocation.service;

import com.gstlocation.model.PractitionerList;
import com.gstlocation.model.PractitionerModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface PractitionerLocationService {

	PractitionerList getjoblist();

	ResponseEntity<String> fetchpractitionerList(PractitionerModel body);





}
