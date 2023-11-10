package com.te.lmsp.dto;

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
public class EmployeeBankDetailsDTO {
	@NotNull(message = "accountNo should not be null")
	private Long accountNo;
	
	@NotNull(message = "BankName name should not be null")
	@NotBlank(message = "BankName should not be BLANK")
	private String bankName;

	@NotNull(message = "AccountType should not be null")
	@NotBlank(message = "BccountType should not be BLANK")
	private String accountType;

	@NotNull(message = "Ifsc should not be NULL")
	@NotBlank(message = "Ifsc should not be BLANK")
	private String ifsc;

	@NotNull(message = "Branch should not be null")
	@NotBlank(message = "Branch should not be BLANK")
	private String branch;

	@NotNull(message = "Branch should not be null")
	@NotBlank(message = "Branch should not be BLANK")
	private String state;
}
