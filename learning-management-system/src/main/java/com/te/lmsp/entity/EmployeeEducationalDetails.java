package com.te.lmsp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Entity
public class EmployeeEducationalDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "education_id")
	private Integer educationId;

	@NotNull(message = "EducationType should not be NULL")
	@NotBlank(message = "EducationType should not be BLANK")
	@Column(name = "education_type")
	private String educationType;

	@NotNull(message = "YearOfPassing should not be NULL")
	@Column(name = "year_of_passing")
	private Integer yearOfPassing;

	@NotNull(message = "Percentage should not be NULL")
	@Column(name = "percentage")
	private Double percentage;

	@NotNull(message = "UniversityName should not be NULL")
	@NotBlank(message = "UniversityName should not be BLANK")
	@Column(name = "university_name")
	private String universityName;

	@NotNull(message = "InstituteName should not be NULL")
	@NotBlank(message = "InstituteName should not be BLANK")
	@Column(name = "institute_name")
	private String instituteName;

	@NotNull(message = "Specialization should not be NULL")
	@NotBlank(message = "Specialization should not be BLANK")
	@Column(name = "specialization")
	private String specialization;

	
	private String state;
}
