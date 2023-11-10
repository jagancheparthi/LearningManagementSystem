package com.te.lmsp.dto;

import com.te.lmsp.enums.AddressType;

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
public class AddressDTO {
	@NotBlank(message = "City should not be Blank")
	@NotNull(message = "City should not be null")
	private String addCity;

	@NotBlank(message = "DoorNo should not be Blank")
	@NotNull(message = "DoorNo should not be null")
	private String addDoorNo;

	@NotBlank(message = "LandMark should not be Blank")
	@NotNull(message = "LandMark should not be null")
	private String addLandMark;

	@NotBlank(message = "Locality should not be Blank")
	@NotNull(message = "Locality should not be null")
	private String addLocality;

	@NotBlank(message = "Pincode should not be Blank")
	@NotNull(message = "Pincode should not be null")
	private int addPincode;

	@NotBlank(message = "State should not be Blank")
	@NotNull(message = "State should not be null")
	private String addState;

	@NotBlank(message = "Street should not be Blank")
	@NotNull(message = "Street should not be null")
	private String addStreet;
	
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
}
