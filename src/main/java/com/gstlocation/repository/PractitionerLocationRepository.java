package com.gstlocation.repository;


import com.gstlocation.model.PractitionerList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PractitionerLocationRepository extends JpaRepository<PractitionerList, Long> {
	PractitionerList findByState(String state);
}
