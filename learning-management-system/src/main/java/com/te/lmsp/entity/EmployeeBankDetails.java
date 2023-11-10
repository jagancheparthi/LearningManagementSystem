package com.te.lmsp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class EmployeeBankDetails {
	@Id
	@Column(name = "account_no")
	private Long accountNo;

	@NotNull(message = "BankName name should not be null")
	@NotBlank(message = "BankName should not be BLANK")
	@Column(name = "bank_name")
	private String bankName;

	@NotNull(message = "AccountType should not be null")
	@NotBlank(message = "BccountType should not be BLANK")
	@Column(name = "account_type")
	private String accountType;

	@NotNull(message = "Ifsc should not be NULL")
	@NotBlank(message = "Ifsc should not be BLANK")
	@Column(name = "bank_ifsc")
	private String ifsc;

	@NotNull(message = "Branch should not be null")
	@NotBlank(message = "Branch should not be BLANK")
	@Column(name = "bank_branch")
	private String branch;

	
	private String state;
}
