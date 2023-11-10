package com.te.lmsp.dto;

import java.util.Map;

import com.te.lmsp.enums.MockNo;
import com.te.lmsp.enums.MockRating;

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
@ToString
@Builder
public class MentorEmpDetailsDTO {
	private String empId;
	private String empName;
	private int mockTaken;
	private int totalMocks;
	private int totalClasses;
	private int numberOfPresent;
	private String status;
	private Map<MockNo, MockRating> mockRatings;
}
