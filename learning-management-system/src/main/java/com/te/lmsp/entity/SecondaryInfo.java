package com.te.lmsp.entity;

import com.te.lmsp.enums.MaritalStatus;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
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
@Entity
public class SecondaryInfo {
	@Id
	@Column(name = "aadhaar_no")
	private String aadhaarNo;

	@NotNull(message = "PanNo should not NULL")
	@NotBlank(message = "PANo should not BLANK")
	@Column(name = "pan_no", unique = true)
	private String panNo;

	@NotNull(message = "FatherName should not NULL")
	@NotBlank(message = "FatherName should not BLANK")
	@Column(name = "father_name")
	private String fatherName;

	@NotNull(message = "MotherName should not NULL")
	@NotBlank(message = "MotherName should not BLANK")
	@Column(name = "mother_name")
	private String motherName;

	@Column(name = "spouse_name")
	private String spouseName;

	@Nullable
	@Column(name = "passport_no", unique = true)
	private String passportNo;

	@NotNull(message = "MaritalStatus should not NULL")
	@Enumerated(EnumType.STRING)
	private MaritalStatus maritalStatus;
}
