package com.te.lmsp.util;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.te.lmsp.dto.AddressDTO;
import com.te.lmsp.dto.ContactDTO;
import com.te.lmsp.dto.EducationalDetailsDTO;
import com.te.lmsp.dto.EmployeeAttendenceDTO;
import com.te.lmsp.dto.EmployeeBankDetailsDTO;
import com.te.lmsp.dto.EmployeeDTO;
import com.te.lmsp.dto.ExperienceDTO;
import com.te.lmsp.dto.SecondaryInfoDTO;
import com.te.lmsp.dto.TechnologyDTO;
import com.te.lmsp.entity.Address;
import com.te.lmsp.entity.Contact;
import com.te.lmsp.entity.Employee;
import com.te.lmsp.entity.EmployeeAttendence;
import com.te.lmsp.entity.EmployeeBankDetails;
import com.te.lmsp.entity.EmployeeEducationalDetails;
import com.te.lmsp.entity.EmployeeExperience;
import com.te.lmsp.entity.SecondaryInfo;
import com.te.lmsp.entity.Technology;
@Component
public class EmployeeUtils {
	public Employee dtoToEntity(EmployeeDTO employeeDTO) {
		return Employee.builder()
					.bloodGroup(employeeDTO.getBloodGroup())
					.dateOfBirth(employeeDTO.getDateOfBirth())
					.dateOfJoining(employeeDTO.getDateOfJoining())
					.degree(employeeDTO.getDegree())
					.designation(employeeDTO.getDesignation())
					.email(employeeDTO.getEmail())
					.empName(employeeDTO.getEmpName())
					.gender(employeeDTO.getGender())
					.nationality(employeeDTO.getNationality())
					.status(employeeDTO.getStatus())
					.build();
	}
	public SecondaryInfo dtoToSecondary(SecondaryInfoDTO secDTO) {
		return SecondaryInfo.builder()
							.aadhaarNo(secDTO.getAadhaarNo())
							.fatherName(secDTO.getFatherName())
							.motherName(secDTO.getMotherName())
							.panNo(secDTO.getPanNo())
							.passportNo(secDTO.getPassportNo())
							.maritalStatus(secDTO.getMaritalStatus())
							.spouseName(secDTO.getSpouseName())
							.build();
	}
	public EmployeeEducationalDetails dtoToEducation(EducationalDetailsDTO eduDTO) {
		return EmployeeEducationalDetails.builder()
										.educationType(eduDTO.getEducationType())
										.yearOfPassing(eduDTO.getYearOfPassing())
										.percentage(eduDTO.getPercentage())
										.universityName(eduDTO.getUniversityName())
										.instituteName(eduDTO.getInstituteName())
										.specialization(eduDTO.getSpecialization())
										.state(eduDTO.getState())
										.build();
	}
	public Address AddressdtoToEntity(AddressDTO addressDTO) {
		return Address.builder()
					  .addCity(addressDTO.getAddCity())
					  .addDoorNo(addressDTO.getAddDoorNo())
					  .addLandMark(addressDTO.getAddLandMark())
					  .addLocality(addressDTO.getAddLocality())
					  .addPincode(addressDTO.getAddPincode())
					  .addressType(addressDTO.getAddressType())
					  .addState(addressDTO.getAddState())
					  .addStreet(addressDTO.getAddStreet())
					  .build();
	}
	public EmployeeBankDetails dtoToBank(EmployeeBankDetailsDTO bankDTO) {
		return EmployeeBankDetails.builder()
								.bankName(bankDTO.getBankName())
								.accountNo(bankDTO.getAccountNo())
								.accountType(bankDTO.getAccountType())
								.ifsc(bankDTO.getIfsc())
								.branch(bankDTO.getBranch())
								.state(bankDTO.getState())
								.build();
	}
	public Technology dtoToTechnology(TechnologyDTO techDTO) {
		return Technology.builder()
						.skillType(techDTO.getSkillType())
						.skillRating(techDTO.getSkillRating())
						.yearOfExperienceOnSkill(techDTO.getYearOfExperienceOnSkill())
						.build();
	}
	public Contact contactDTOToEntity(ContactDTO contactDTO) {
		return Contact.builder()
					   .contactNumber(contactDTO.getContactNumber())
					   .contactType(contactDTO.getContactType())
					   .build();
	}
	public EmployeeExperience dtoToExperience(ExperienceDTO expDTO) {
		return EmployeeExperience.builder()
								.companyName(expDTO.getCompanyName())
								.yearsOfExperience(expDTO.getYearsOfExperience())
								.dataOfJoining(expDTO.getDataOfJoining())
								.dataOfRelieving(expDTO.getDataOfRelieving())
								.designation(expDTO.getDesignation())
								.location(expDTO.getLocation())
								.build();
	}
	public EmployeeAttendence attendenceToEntity(EmployeeAttendenceDTO employeeAttendence) {
		return EmployeeAttendence.builder()
								 .attendenceDate(employeeAttendence.getAttendenceDate())
								 .attendenceMorning(employeeAttendence.getAttendenceMorning())
								 .attendenceNoon(employeeAttendence.getAttendenceNoon())
								 .build();
	}
	//Entity to Dto
	public EmployeeDTO employeeToDto(Employee employee) {
		return EmployeeDTO.builder()
				.bloodGroup(employee.getBloodGroup())
				.dateOfBirth(employee.getDateOfBirth())
				.dateOfJoining(employee.getDateOfJoining())
				.degree(employee.getDegree())
				.designation(employee.getDesignation())
				.email(employee.getEmail())
				.empId(employee.getEmpId())
				.empName(employee.getEmpName())
				.gender(employee.getGender())
				.nationality(employee.getNationality())
				.status(employee.getStatus())
						.build();
	}
	public SecondaryInfoDTO SecondaryToDto(SecondaryInfo sec) {
		return SecondaryInfoDTO.builder()
							.aadhaarNo(sec.getAadhaarNo())
							.fatherName(sec.getFatherName())
							.motherName(sec.getMotherName())
							.panNo(sec.getPanNo())
							.passportNo(sec.getPassportNo())
							.maritalStatus(sec.getMaritalStatus())
							.spouseName(sec.getSpouseName())
							.build();
	}
	public EducationalDetailsDTO EducationToDto(EmployeeEducationalDetails edu) {
		return EducationalDetailsDTO.builder()
										.educationType(edu.getEducationType())
										.yearOfPassing(edu.getYearOfPassing())
										.percentage(edu.getPercentage())
										.universityName(edu.getUniversityName())
										.instituteName(edu.getInstituteName())
										.specialization(edu.getSpecialization())
										.state(edu.getState())
										.build();
	}
	public AddressDTO AddressToDto(Address address) {
		return AddressDTO.builder()
					  .addCity(address.getAddCity())
					  .addDoorNo(address.getAddDoorNo())
					  .addLandMark(address.getAddLandMark())
					  .addLocality(address.getAddLocality())
					  .addPincode(address.getAddPincode())
					  .addressType(address.getAddressType())
					  .addState(address.getAddState())
					  .addStreet(address.getAddStreet())
					  .build();
	}
	public EmployeeBankDetailsDTO BankToDto(EmployeeBankDetails bank) {
		return EmployeeBankDetailsDTO.builder()
								.bankName(bank.getBankName())
								.accountNo(bank.getAccountNo())
								.accountType(bank.getAccountType())
								.ifsc(bank.getIfsc())
								.branch(bank.getBranch())
								.state(bank.getState())
								.build();
	}
	public TechnologyDTO technologyToDto(Technology tech) {
		return TechnologyDTO.builder()
						.skillType(tech.getSkillType())
						.skillRating(tech.getSkillRating())
						.yearOfExperienceOnSkill(tech.getYearOfExperienceOnSkill())
						.build();
	}
	public ContactDTO contactToDto(Contact contact) {
		return ContactDTO.builder()
					   .contactNumber(contact.getContactNumber())
					   .contactType(contact.getContactType())
					   .build();
	}
	public ExperienceDTO experienceToDto(EmployeeExperience exp) {
		return ExperienceDTO.builder()
								.companyName(exp.getCompanyName())
								.yearsOfExperience(exp.getYearsOfExperience())
								.dataOfJoining(exp.getDataOfJoining())
																		//			.dataOfRelieving(exp.getDataOfRelieving())
								.designation(exp.getDesignation())
																		//			.location(exp.getLocation())
								.build();
	}
	public EmployeeAttendenceDTO attendenceToDto(EmployeeAttendence employeeAttendence) {
		return EmployeeAttendenceDTO.builder()
								 .attendenceDate(employeeAttendence.getAttendenceDate())
								 .attendenceMorning(employeeAttendence.getAttendenceMorning())
								 .attendenceNoon(employeeAttendence.getAttendenceNoon())
								 .build();
	} 
	
}
