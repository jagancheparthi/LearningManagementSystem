package com.te.lmsp.dto;

import java.util.Map;

import com.te.lmsp.enums.Degree;
import com.te.lmsp.enums.Gender;
import com.te.lmsp.enums.MockRating;
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
public class BatchMentorDTO {
	private Map<Gender, Long> gender;
	private Map<Object, Long> yearOfPass;
	private Map<YearsOfExperience, Long> experience;
	private Map<Degree, Long> degree;
	private Map<MockRating, Long> performance;
}
