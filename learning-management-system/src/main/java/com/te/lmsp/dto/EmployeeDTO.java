package com.te.lmsp.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.te.lmsp.enums.BloodGroup;
import com.te.lmsp.enums.Degree;
import com.te.lmsp.enums.EmployeeStatus;
import com.te.lmsp.enums.Gender;
import com.te.lmsp.enums.Nationality;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class EmployeeDTO {
	private String empId;

	@NotNull(message = "NULL data passed for empName")
	@NotBlank(message = "BLANK data passes empName")
	@Size(min = 2, max = 100)
	private String empName;

	@NotNull
	@NotBlank
	@Email(message = "Email is not valid")
	private String email;

	@NotNull(message = "NULL data passed for dateOfBirth")
	
	private LocalDate dateOfBirth;

	@NotNull(message = "NULL data passed for dateOfJoining")
	private LocalDate dateOfJoining;

	@NotNull(message = "NULL data passed for designation")
	@NotBlank(message = "BLANK data passes designation")
	private String designation;

	@NotNull(message = "NULL data passed for nationality")
	@Enumerated(EnumType.STRING)
	private Nationality nationality;

	@NotNull(message = "NULL data passed for gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@NotNull(message = "NULL data passed for bloodGroup")
	@Enumerated(EnumType.STRING)
	private BloodGroup bloodGroup;

	@NotNull(message = "NULL data passed for degree")
	@Enumerated(EnumType.STRING)
	private Degree degree;

	@NotNull(message = "Status should not be null")
	@Enumerated(EnumType.STRING)
	private EmployeeStatus status;
	
	
	@NotNull(message = "SecondaryInfo should not be null")
	private SecondaryInfoDTO secondaryInfoDTO;

	@NotNull(message = "EducationDetails should not be null")
	private List<EducationalDetailsDTO> educationDetailsDTO;
	
	@NotNull(message = "Address should not be null")
	private List<AddressDTO> addressesDTO;
	

	@NotNull(message = "EmployeeBankDetails should not be null")
	private EmployeeBankDetailsDTO bankDetailsDTO;

	@NotNull(message = "Technology should not be null")
	private Set<TechnologyDTO> technologiesDTO;

	@Nullable
	private List<ExperienceDTO> experiencesDTO;

	@NotNull(message = "Contact should not be null")
	private List<ContactDTO> contacts;
}
