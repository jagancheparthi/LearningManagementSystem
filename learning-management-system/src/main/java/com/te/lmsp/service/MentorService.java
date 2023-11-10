package com.te.lmsp.service;

import java.time.LocalDate;
import java.util.List;

import com.te.lmsp.dto.BatchMentorDTO;
import com.te.lmsp.dto.BatchMentorListDTO;
import com.te.lmsp.dto.EmpAttendenceDTO;
import com.te.lmsp.dto.MentorEmpDetailsDTO;
import com.te.lmsp.dto.MockDetailsDTO;
import com.te.lmsp.dto.MockSheduleDTO;
import com.te.lmsp.exception.DuplicateMockException;
import com.te.lmsp.exception.MockReportDuplicateException;
import com.te.lmsp.exception.NoDataFoundForTheSpecificDate;

public interface MentorService {

	BatchMentorDTO getBatchDetails(String batchId);

	List<BatchMentorListDTO> getBatchList();

	List<EmpAttendenceDTO> getEmployees(String batchId,LocalDate date) throws NoDataFoundForTheSpecificDate;

	String morningAttendence(boolean status, String empId,LocalDate date);
	
	String noonAttendence(boolean status, String empId,LocalDate date);

	List<MentorEmpDetailsDTO> getEmployee(String batchId);

	String registerMock(MockSheduleDTO mockSheduleDTO) throws DuplicateMockException;

	String addRating(String empId, MockDetailsDTO mockDTO) throws MockReportDuplicateException;


}
