package com.te.lmsp.dto;

import com.te.lmsp.enums.MaritalStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SecondaryInfoDTO {
	
	private String aadhaarNo;

	
	private String panNo;

	
	private String fatherName;


	private String motherName;


	private String spouseName;

	private String passportNo;

	
	private MaritalStatus maritalStatus;
}
