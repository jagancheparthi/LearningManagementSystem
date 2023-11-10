package com.te.lmsp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class EducationalDetailsDTO {
	@NotNull(message = "EducationType should not be NULL")
	@NotBlank(message = "EducationType should not be BLANK")
	private String educationType;

	@NotNull(message = "YearOfPassing should not be NULL")
	private Integer yearOfPassing;

	@NotNull(message = "Percentage should not be NULL")
	private Double percentage;

	@NotNull(message = "UniversityName should not be NULL")
	@NotBlank(message = "UniversityName should not be BLANK")
	private String universityName;

	@NotNull(message = "InstituteName should not be NULL")
	@NotBlank(message = "InstituteName should not be BLANK")
	private String instituteName;

	@NotNull(message = "Specialization should not be NULL")
	@NotBlank(message = "Specialization should not be BLANK")
	private String specialization;

	@NotNull(message = "Specialization should not be NULL")
	@NotBlank(message = "Specialization should not be BLANK")
	private String state;
}
