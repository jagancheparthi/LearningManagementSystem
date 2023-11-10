package com.te.lmsp.dto;

import java.time.LocalDate;

import com.te.lmsp.enums.YearsOfExperience;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class ExperienceDTO {
	@NotNull(message = "CompanyName should not be NULL")
	@NotBlank(message = "CompanyName should not be BLANK")
	private String companyName;

	@NotNull(message = "YearsOfExperience should not be NULL")
	@Enumerated(EnumType.ORDINAL)
	private YearsOfExperience yearsOfExperience;

	@NotNull(message = "DataOfJoining should not be NULL")
	private LocalDate dataOfJoining;

	@NotNull(message = "DataOfRelieving should not be NULL")
	private LocalDate dataOfRelieving;

	@NotNull(message = "Designation should not be NULL")
	@NotBlank(message = "Designation should not be BLANK")
	private String designation;

	@NotNull(message = "NULL data passed for location")
	@NotBlank(message = "Location should not be BLANK")
	private String location;
}
