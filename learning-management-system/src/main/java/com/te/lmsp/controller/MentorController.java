package com.te.lmsp.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.lmsp.dto.BatchMentorListDTO;
import com.te.lmsp.dto.EmpAttendenceDTO;
import com.te.lmsp.dto.MentorEmpDetailsDTO;
import com.te.lmsp.dto.MockDetailsDTO;
import com.te.lmsp.dto.MockSheduleDTO;
import com.te.lmsp.exception.DuplicateMockException;
import com.te.lmsp.exception.MockReportDuplicateException;
import com.te.lmsp.exception.NoDataFoundForTheSpecificDate;
import com.te.lmsp.response.SuccessResponse;
import com.te.lmsp.service.MentorService;

import lombok.RequiredArgsConstructor;

@RequestMapping(path = "/mentor")
@RequiredArgsConstructor
@RestController
public class MentorController {

	private final MentorService mentorService;

	/* BATCH DETAILS TO SHOW AS GRAPHICAL VIEW */

	@GetMapping(path = "/batch")
	public ResponseEntity<SuccessResponse> getBatchDetails(@RequestParam("id") String batchId) {
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().message("BATCH DETAILS ARE FOUND")
				.data(mentorService.getBatchDetails(batchId)).timeStamp(new Timestamp(System.currentTimeMillis()))
				.build(), HttpStatus.FOUND);
	}

	/* BATCH DETAILS WITH BATCH STRENGTH */

	@GetMapping(path = "/batchlist")
	public ResponseEntity<SuccessResponse> getBatchList() {
		List<BatchMentorListDTO> batches = mentorService.getBatchList();
		return new ResponseEntity<SuccessResponse>(
				SuccessResponse.builder().message("NUMBER OF BATCHES FOUND ARE : " + batches.size()).data(batches)
						.timeStamp(new Timestamp(System.currentTimeMillis())).build(),
				HttpStatus.FOUND);
	}

	/* API TO GET ATTENDENCE DATA FROM BATCH */

	@GetMapping(path = "/employees")
	public ResponseEntity<SuccessResponse> getEmployees(@RequestParam("id") String batchId,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws NoDataFoundForTheSpecificDate {
		List<EmpAttendenceDTO> employees = mentorService.getEmployees(batchId, date);
		return new ResponseEntity<SuccessResponse>(
				SuccessResponse.builder().message("NUMBER OF EMPLOYEES FOUND ARE : " + employees.size()).data(employees)
						.timeStamp(new Timestamp(System.currentTimeMillis())).build(),
				HttpStatus.FOUND);
	}

	/* API FOR GETTING EMPLOYEES WITH MOCK RATINGS ANG ATTENDENCE */

	@GetMapping(path = "/batch/employees")
	public ResponseEntity<SuccessResponse> getEmployee(@RequestParam("id") String batchId) {
		List<MentorEmpDetailsDTO> employees = mentorService.getEmployee(batchId);
		return new ResponseEntity<SuccessResponse>(
				SuccessResponse.builder().message("NUMBER OF EMPLOYEES FOUND ARE : " + employees.size()).data(employees)
						.timeStamp(new Timestamp(System.currentTimeMillis())).build(),
				HttpStatus.FOUND);
	}

	/* ADDING ATTENDENCE FOR MORNING AND NOON */

	@PostMapping(path = "/morning")
	public ResponseEntity<SuccessResponse> morningAttendence(@RequestParam boolean status, @RequestParam String empId,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		String message = mentorService.morningAttendence(status, empId, date);
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().message("ATTENDENCE ADDED SUCCESSFULLY")
				.data(message).timeStamp(new Timestamp(System.currentTimeMillis())).build(), HttpStatus.ACCEPTED);
	}

	@PostMapping(path = "/noon")
	public ResponseEntity<SuccessResponse> noonAttendence(@RequestParam boolean status, @RequestParam String empId,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		String message = mentorService.noonAttendence(status, empId, date);
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().message("ATTENDENCE ADDED SUCCESSFULLY")
				.data(message).timeStamp(new Timestamp(System.currentTimeMillis())).build(), HttpStatus.ACCEPTED);
	}

	/* ADDING MOCK TO A SPECIFIC BATCH */

	@PostMapping(path = "/add-mock")
	public ResponseEntity<SuccessResponse> addMock(@RequestBody MockSheduleDTO mockSheduleDTO)
			throws DuplicateMockException {
		String msg = mentorService.registerMock(mockSheduleDTO);
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().message("MOCK ADDED SUCCESSFULLY")
				.data(msg).timeStamp(new Timestamp(System.currentTimeMillis())).build(), HttpStatus.ACCEPTED);
	}

	/* ADDING MOCK RARTINGS TO EMPLOYEES */

	@PostMapping(path = "/add-rating")
	public ResponseEntity<SuccessResponse> addRating(@RequestParam("id") String empId,
			@RequestBody MockDetailsDTO mockDTO) throws MockReportDuplicateException {
		String msg = mentorService.addRating(empId, mockDTO);
		return new ResponseEntity<SuccessResponse>(SuccessResponse.builder().message("RATING ADDED SUCCESSFULLY")
				.data(msg).timeStamp(new Timestamp(System.currentTimeMillis())).build(), HttpStatus.ACCEPTED);
	}

}
