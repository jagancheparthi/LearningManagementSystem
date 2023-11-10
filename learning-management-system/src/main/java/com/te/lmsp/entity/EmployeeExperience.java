package com.te.lmsp.entity;

import java.time.LocalDate;

import com.te.lmsp.enums.YearsOfExperience;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@ToString
@Getter
@Setter
@Builder
@Entity
public class EmployeeExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "experience_id")
	private Integer experienceId;

	@NotNull(message = "CompanyName should not be NULL")
	@NotBlank(message = "CompanyName should not be BLANK")
	@Column(name = "company_name")
	private String companyName;

	@NotNull(message = "YearsOfExperience should not be NULL")
	@Enumerated(EnumType.ORDINAL)
	private YearsOfExperience yearsOfExperience;

	@NotNull(message = "DataOfJoining should not be NULL")
	@Column(name = "data_of_joining")
	private LocalDate dataOfJoining;

	@NotNull(message = "DataOfRelieving should not be NULL")
	@Column(name = "data_of_relieving")
	private LocalDate dataOfRelieving;

	@NotNull(message = "Designation should not be NULL")
	@NotBlank(message = "Designation should not be BLANK")
	@Column(name = "designation")
	private String designation;

	@NotNull(message = "NULL data passed for location")
	@NotBlank(message = "Location should not be BLANK")
	@Column(name = "location")
	private String location;
	

}
