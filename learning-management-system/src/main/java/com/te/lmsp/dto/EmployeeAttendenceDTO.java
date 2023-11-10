package com.te.lmsp.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
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
public class EmployeeAttendenceDTO {
	@NotNull(message = "Attendence date should not be null")
	@Column(name = "attendence_date")
	private LocalDate attendenceDate;

//	@NotNull(message = "Morning Attendence should not be null")
	@Column(name = "attendence_morning")
	private Boolean attendenceMorning;

//	@NotNull(message = "After noon Attendence should not be null")
	@Column(name = "attendence_noon")
	private Boolean attendenceNoon;
}
