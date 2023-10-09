package com.gstlocation.helper;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Todos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String enrlNo;
	private String trpNam;
	private String stCd;
	private String  dstCd;
	private int cntctNo;
	private String emailId;
	private String ctgry;

	private String adrs;
	private String searchType;
	private String authTokn;



}