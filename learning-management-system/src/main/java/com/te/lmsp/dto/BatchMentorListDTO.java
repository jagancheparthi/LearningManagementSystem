package com.te.lmsp.dto;

import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

import com.te.lmsp.enums.BatchStatus;
import com.te.lmsp.enums.BatchStrength;
import com.te.lmsp.enums.Degree;
import com.te.lmsp.enums.Gender;
import com.te.lmsp.enums.MockRating;
import com.te.lmsp.enums.YearsOfExperience;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class BatchMentorListDTO {
	
	private String batchId;

	private String batchName;

	private LocalDate batStartDate;

	private LocalDate batEndDate;

	private Set<SkillDTO> technologies;
	

	private Map<BatchStrength, Integer> batchStrength = new EnumMap<>(BatchStrength.class);
	
	@Enumerated(EnumType.STRING)
	private BatchStatus batchStatus;
}
