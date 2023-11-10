package com.te.lmsp.entity;

import com.te.lmsp.enums.MockNo;
import com.te.lmsp.enums.MockRating;
import com.te.lmsp.enums.MockType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class MockDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mock_id")
	private Integer mockId;

	@Enumerated(EnumType.STRING)
	private MockType type;
	
	private String MockTakenBy;

	private String technology;

	@NotNull(message = "NULL data passed for practical")
	@Column(name = "practical")
	private Integer practical;

	@NotNull(message = "NULL data passed for theoritical")
	@Column(name = "theoritical")
	private Integer theoritical;

	@NotNull(message = "NULL data passed for mockFeedback")
	@NotBlank(message = "BLANK data passes mockFeedback")
	@Column(name = "mock_feedback")
	private String mockFeedback;

	@NotNull(message = "NULL data passed for theoritical")
	private Integer overAll;

	@Enumerated(EnumType.STRING)
	private MockNo mockNo;

	@Enumerated(EnumType.STRING)
	private MockRating mockRating;

	@ManyToOne
	private Employee employee;

}
