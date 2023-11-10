package com.te.lmsp.entity;

import com.te.lmsp.enums.ContactType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
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
public class Contact {
	@Id
	@Column(name = "contact_number")
	private String contactNumber;

	@Enumerated(EnumType.STRING)
	private ContactType contactType;
}
