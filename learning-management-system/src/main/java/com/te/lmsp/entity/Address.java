package com.te.lmsp.entity;

import com.te.lmsp.enums.AddressType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Address {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="add_id")
	private int addId;

	@Column(name="add_city")
	private String addCity;

	@Column(name="add_door_no")
	private String addDoorNo;

	@Column(name="add_land_mark")
	private String addLandMark;

	@Column(name="add_locality")
	private String addLocality;

	@Column(name="add_pincode")
	private int addPincode;

	@Column(name="add_state")
	private String addState;

	@Column(name="add_street")
	private String addStreet;

	@Enumerated(EnumType.STRING)
	private AddressType addressType;
}
