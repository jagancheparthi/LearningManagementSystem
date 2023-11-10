package com.te.lmsp.dto;

import com.te.lmsp.enums.MockNo;
import com.te.lmsp.enums.MockType;

import jakarta.persistence.Column;
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
public class MockDetailsDTO {
	@Enumerated(EnumType.STRING)
	private MockType type;
	
	private String MockTakenBy;
	
	private String technology;

	@NotNull(message = "NULL data passed for practical")
	@Column(name = "practical")
	private Integer practical;

	@NotNull(message = "NULL data passed for theoritical")
	private Integer theoritical;
	
	@NotNull(message = "NULL data passed for theoritical")
	private Integer overAll;

	@NotNull(message = "NULL data passed for mockFeedback")
	@NotBlank(message = "BLANK data passes mockFeedback")
	private String mockFeedback;
	
	@Enumerated(EnumType.STRING)
	private MockNo mockNo;
	
}
