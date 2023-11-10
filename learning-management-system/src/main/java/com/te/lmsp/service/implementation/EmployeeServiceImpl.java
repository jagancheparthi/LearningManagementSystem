package com.te.lmsp.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.lmsp.dto.EmployeeDTO;
import com.te.lmsp.dto.UpdatePasswordDTO;
import com.te.lmsp.entity.Address;
import com.te.lmsp.entity.AppUser;
import com.te.lmsp.entity.Batch;
import com.te.lmsp.entity.Contact;
import com.te.lmsp.entity.Employee;
import com.te.lmsp.entity.EmployeeBankDetails;
import com.te.lmsp.entity.EmployeeEducationalDetails;
import com.te.lmsp.entity.EmployeeExperience;
import com.te.lmsp.entity.RawPasswords;
import com.te.lmsp.entity.RequestData;
import com.te.lmsp.entity.SecondaryInfo;
import com.te.lmsp.entity.Technology;
import com.te.lmsp.enums.RequestStatus;
import com.te.lmsp.exception.NoOfRequestNotPossibleException;
import com.te.lmsp.exception.RegistrationErrorException;
import com.te.lmsp.exception.UserNotFoundException;
import com.te.lmsp.repository.AppUserRepository;
import com.te.lmsp.repository.EmployeeRepository;
import com.te.lmsp.repository.RawPasswordRepository;
import com.te.lmsp.repository.RequestDataRepository;
import com.te.lmsp.service.EmployeeService;
import com.te.lmsp.util.EmployeeUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
	Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	private final EmployeeRepository employeeRepository;
	private final EmployeeUtils employeeUtils;
	private final AppUserRepository appUserRepository;
	private final PasswordEncoder encoder;
	private final RequestDataRepository requestDataRepository;
	private final RawPasswordRepository rawPasswordRepository;
	private final AuthenticationManager manager;

	public String saveEmployee(EmployeeDTO employeeDTO) throws RegistrationErrorException {
		Employee employee = employeeUtils.dtoToEntity(employeeDTO);
		SecondaryInfo secInfo = employeeUtils.dtoToSecondary(employeeDTO.getSecondaryInfoDTO());
		List<EmployeeEducationalDetails> eduDetails = employeeDTO.getEducationDetailsDTO().stream()
				.map(edu -> employeeUtils.dtoToEducation(edu)).collect(Collectors.toList());
		List<Address> addresses = employeeDTO.getAddressesDTO().stream()
				.map(add -> employeeUtils.AddressdtoToEntity(add)).collect(Collectors.toList());
		EmployeeBankDetails bankDetails = employeeUtils.dtoToBank(employeeDTO.getBankDetailsDTO());
		Set<Technology> techs = employeeDTO.getTechnologiesDTO().stream()
				.map(tech -> employeeUtils.dtoToTechnology(tech)).collect(Collectors.toSet());
		List<EmployeeExperience> exps = employeeDTO.getExperiencesDTO().stream()
				.map(exp -> employeeUtils.dtoToExperience(exp)).collect(Collectors.toList());
		List<Contact> contacts = employeeDTO.getContacts().stream().map(con -> employeeUtils.contactDTOToEntity(con))
				.collect(Collectors.toList());
		String userName = UUID.randomUUID().toString();
		employee.setEmpId(userName);
		employee.setSecondaryInfo(secInfo);
		employee.setEducationDetails(eduDetails);
		employee.setAddresses(addresses);
		employee.setBankDetails(bankDetails);
		employee.setTechnologies(techs);
		employee.setExperiences(exps);
		employee.setContacts(contacts);

		AppUser appUser = new AppUser();
		appUser.setUsername(userName);
		String password = UUID.randomUUID().toString();
		RawPasswords pw = new RawPasswords();
		pw.setUsername(userName);
		pw.setPassword(password);
		rawPasswordRepository.save(pw);
		appUser.setPassword(encoder.encode(password));
		appUser.setRole("ROLE_EMPLOYEE");
		appUserRepository.save(appUser);

		Employee emp = employeeRepository.save(employee);

		String msg = "";
		if (emp != null)
			msg = " USER NAME : " + userName + " PASSWORD : " + password;
		else
			throw new RegistrationErrorException("Registration is Interrupted");

		return msg;
	}

	@Override
	public EmployeeDTO findEmployee(String empId) throws UserNotFoundException {
		Employee employee = employeeRepository.findById(empId)
				.orElseThrow(() -> new UserNotFoundException("User Not Present with this EMPLOYEE ID"));
		EmployeeDTO empl = employeeUtils.employeeToDto(employee);
		empl.setSecondaryInfoDTO(employeeUtils.SecondaryToDto(employee.getSecondaryInfo()));
		empl.setEducationDetailsDTO(employee.getEducationDetails().stream().map(ed -> employeeUtils.EducationToDto(ed))
				.collect(Collectors.toList()));
		empl.setAddressesDTO(employee.getAddresses().stream().map(add -> employeeUtils.AddressToDto(add))
				.collect(Collectors.toList()));
		empl.setBankDetailsDTO(employeeUtils.BankToDto(employee.getBankDetails()));
		empl.setTechnologiesDTO(employee.getTechnologies().stream().map(tech -> employeeUtils.technologyToDto(tech))
				.collect(Collectors.toSet()));
		empl.setExperiencesDTO(
				employee.getExperiences().stream().map(exp -> employeeUtils.experienceToDto(exp)).toList());
		empl.setContacts(employee.getContacts().stream().map(con -> employeeUtils.contactToDto(con)).toList());
		return empl;
	}

	@Override
	public List<EmployeeDTO> findEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDTO> emps = employees.stream().map(employee -> {
			EmployeeDTO empl = employeeUtils.employeeToDto(employee);
			empl.setSecondaryInfoDTO(employeeUtils.SecondaryToDto(employee.getSecondaryInfo()));
			empl.setEducationDetailsDTO(employee.getEducationDetails().stream()
					.map(ed -> employeeUtils.EducationToDto(ed)).collect(Collectors.toList()));
			empl.setAddressesDTO(employee.getAddresses().stream().map(add -> employeeUtils.AddressToDto(add))
					.collect(Collectors.toList()));
			empl.setBankDetailsDTO(employeeUtils.BankToDto(employee.getBankDetails()));
			empl.setTechnologiesDTO(employee.getTechnologies().stream().map(tech -> employeeUtils.technologyToDto(tech))
					.collect(Collectors.toSet()));
			empl.setExperiencesDTO(
					employee.getExperiences().stream().map(exp -> employeeUtils.experienceToDto(exp)).toList());
			empl.setContacts(employee.getContacts().stream().map(con -> employeeUtils.contactToDto(con)).toList());
			return empl;
		}).collect(Collectors.toList());
		return emps;
	}
	@Override
	public String updatePassword(UpdatePasswordDTO updatePasswordDto) throws UserNotFoundException {

		if (updatePasswordDto.getNewpassword().equals(updatePasswordDto.getReenteredpassword())) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Object principal = authentication.getName();
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(principal,
					updatePasswordDto.getPassword());
			manager.authenticate(token);
			Optional<AppUser> appUser = appUserRepository.findById(principal.toString());
			Optional<RawPasswords> rawUser = rawPasswordRepository.findById(principal.toString());
			rawUser.get().setPassword(updatePasswordDto.getNewpassword());
			rawPasswordRepository.save(rawUser.get());
			String encode = encoder.encode(updatePasswordDto.getNewpassword());
			appUser.get().setPassword(encode);
			appUserRepository.save(appUser.get());
			return "PASSWORD UPDATED SUCCESSFULLY";
		} else
			return "NEW PASSWORD AND RE-ENTERED PASSWORD SHOULD BE SAME";
	}

	@Override
	public String sendRequest(String empId) throws UserNotFoundException, NoOfRequestNotPossibleException {

		Employee employee = employeeRepository.findById(empId).orElseThrow(
				() -> new UserNotFoundException("SENDING REQUEST IS NOT POSSIBLE DUE TO USER ID IS NOT VALID"));
		RequestData emp = requestDataRepository.findByEmployee(employee).orElse(null);
		RequestData req ;
		if(emp==null) {
		Batch batch = employee.getBatch();
		
		if(batch==null) {
		RequestData requestData = new RequestData();
		String empI = employee.getEmpId();
		employee.setEmpId(empI);
		requestData.setEmployee(employee);
		requestData.setRequestStatus(RequestStatus.NOT_SELECTED);

		req = requestDataRepository.save(requestData);
		}
		else throw new NoOfRequestNotPossibleException("ALREADY REQUEST EXIST && ACCEPTED");
		}
		else throw new NoOfRequestNotPossibleException("ALREADY REQUEST REJECTED");
		return req.getEmployee().getEmpId();
	}

	@Override
	public String updateEmpDetails(EmployeeDTO employeeDTO) {
		Employee employe = employeeRepository.findById(employeeDTO.getEmpId()).orElse(null);
		
		Employee employee = employeeUtils.dtoToEntity(employeeDTO);
		
		employe.setEmpId(employe.getEmpId());
		employe.setEmpName(employee.getEmpName());
		employe.setEmail(employee.getEmail());
		employe.setDateOfBirth(employee.getDateOfBirth());
		employe.setDateOfJoining(employee.getDateOfJoining());
		employe.setDesignation(employee.getDesignation());
		employe.setNationality(employee.getNationality());
		employe.setGender(employee.getGender());
		employe.setBloodGroup(employee.getBloodGroup());
		employe.setDegree(employee.getDegree());
		employe.setStatus(employee.getStatus());
		
		SecondaryInfo secInfo = employeeUtils.dtoToSecondary(employeeDTO.getSecondaryInfoDTO());
		List<EmployeeEducationalDetails> eduDetails = employeeDTO.getEducationDetailsDTO().stream()
				.map(edu -> employeeUtils.dtoToEducation(edu)).collect(Collectors.toList());
		List<Address> addresses = employeeDTO.getAddressesDTO().stream()
				.map(add -> employeeUtils.AddressdtoToEntity(add)).collect(Collectors.toList());
		EmployeeBankDetails bankDetails = employeeUtils.dtoToBank(employeeDTO.getBankDetailsDTO());
		Set<Technology> techs = employeeDTO.getTechnologiesDTO().stream()
				.map(tech -> employeeUtils.dtoToTechnology(tech)).collect(Collectors.toSet());
		List<EmployeeExperience> exps = employeeDTO.getExperiencesDTO().stream()
				.map(exp -> employeeUtils.dtoToExperience(exp)).collect(Collectors.toList());
		List<Contact> contacts = employeeDTO.getContacts().stream().map(con -> employeeUtils.contactDTOToEntity(con))
				.collect(Collectors.toList());
		
		
		employe.setSecondaryInfo(secInfo);
		employe.setEducationDetails(eduDetails);
		employe.setAddresses(addresses);
		employe.setBankDetails(bankDetails);
		employe.setTechnologies(techs);
		employe.setExperiences(exps);
		employe.setContacts(contacts);
		

		return employe.getEmpId()+"UPDATED SUCCESSFULLY";
	}

}
