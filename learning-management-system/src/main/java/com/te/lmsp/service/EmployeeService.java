package com.te.lmsp.service;

import java.util.List;

import com.te.lmsp.dto.EmployeeDTO;
import com.te.lmsp.dto.UpdatePasswordDTO;
import com.te.lmsp.exception.NoOfRequestNotPossibleException;
import com.te.lmsp.exception.RegistrationErrorException;
import com.te.lmsp.exception.UserNotFoundException;

public interface EmployeeService {

	String saveEmployee(EmployeeDTO employeeDTO) throws RegistrationErrorException;

	EmployeeDTO findEmployee(String empId) throws UserNotFoundException;

	List<EmployeeDTO> findEmployees();

	String updatePassword(UpdatePasswordDTO updatePasswordDto) throws UserNotFoundException;

	String sendRequest(String empId) throws UserNotFoundException, NoOfRequestNotPossibleException;

	String updateEmpDetails(EmployeeDTO employeeDTO);

}
