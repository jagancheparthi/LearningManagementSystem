package com.te.lmsp.dto;

import com.te.lmsp.enums.YearsOfExperience;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RequestDataDTO {
	private String empId; 
	private String empName;
	private Integer yearOfPassing;
	private Double percentage;
	private YearsOfExperience yearsOfExperience;
	private String contactNumber;
}
