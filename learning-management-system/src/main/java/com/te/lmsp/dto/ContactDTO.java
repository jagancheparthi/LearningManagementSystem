package com.te.lmsp.dto;

import com.te.lmsp.enums.ContactType;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class ContactDTO {
	private String contactNumber;

	@Enumerated(EnumType.STRING)
	private ContactType contactType;
}
