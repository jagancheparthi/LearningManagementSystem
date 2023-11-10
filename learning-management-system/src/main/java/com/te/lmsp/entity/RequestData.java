package com.te.lmsp.entity;

import com.te.lmsp.enums.RequestStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
public class RequestData {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer requestId;
	@Enumerated(EnumType.STRING)
	private RequestStatus requestStatus;
	private String reason;
	@OneToOne(cascade = CascadeType.ALL)
	private Employee employee;
}
