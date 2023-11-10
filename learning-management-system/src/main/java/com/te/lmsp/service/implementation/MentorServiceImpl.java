package com.te.lmsp.service.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.te.lmsp.dto.BatchMentorDTO;
import com.te.lmsp.dto.BatchMentorListDTO;
import com.te.lmsp.dto.EmpAttendenceDTO;
import com.te.lmsp.dto.MentorEmpDetailsDTO;
import com.te.lmsp.dto.MockDetailsDTO;
import com.te.lmsp.dto.MockSheduleDTO;
import com.te.lmsp.dto.SkillDTO;
import com.te.lmsp.entity.Batch;
import com.te.lmsp.entity.Employee;
import com.te.lmsp.entity.EmployeeAttendence;
import com.te.lmsp.entity.MockDetails;
import com.te.lmsp.entity.MockShedule;
import com.te.lmsp.enums.Degree;
import com.te.lmsp.enums.Gender;
import com.te.lmsp.enums.MockNo;
import com.te.lmsp.enums.MockRating;
import com.te.lmsp.enums.YearsOfExperience;
import com.te.lmsp.exception.DuplicateMockException;
import com.te.lmsp.exception.MockReportDuplicateException;
import com.te.lmsp.repository.BatchRepository;
import com.te.lmsp.repository.EmployeeRepository;
import com.te.lmsp.repository.MockDetailsRepository;
import com.te.lmsp.service.MentorService;
import com.te.lmsp.util.BatchUtils;
import com.te.lmsp.util.EmployeeUtils;
import com.te.lmsp.util.MentorUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MentorServiceImpl implements MentorService {
	private final EmployeeUtils employeeUtils;
	private final BatchRepository batchRepository;
	private final BatchUtils batchUtils;
	private final EmployeeRepository employeeRepository;
	private final MockDetailsRepository mockDetailsRepository;
	private final MentorUtils mentorUtils;
	
	@Cacheable(value = "BatchCache",key = "#batchId")
	@Override
	public BatchMentorDTO getBatchDetails(String batchId) {
		Batch batch = batchRepository.findById(batchId).orElse(null);
		
		Map<Gender, Long> genderCount = batch.getEmployees().stream()
				.collect(Collectors.groupingBy(emp -> emp.getGender(), Collectors.counting()));

		Map<Object, Long> passYearMap = batch.getEmployees().stream().flatMap(emp -> emp.getEducationDetails().stream())
				.collect(Collectors.groupingBy(edu -> edu.getYearOfPassing(), Collectors.counting()));

		Map<YearsOfExperience, Long> expMap = batch.getEmployees().stream()
				.flatMap(emp -> emp.getExperiences().stream())
				.collect(Collectors.groupingBy(exp -> exp.getYearsOfExperience(), Collectors.counting()));
		
		Map<Degree, Long> degMap = batch.getEmployees().stream()
				.collect(Collectors.groupingBy(emp -> emp.getDegree(), Collectors.counting()));
		
		BatchMentorDTO dto = new BatchMentorDTO();
		dto.setGender(genderCount);
		dto.setExperience(expMap);
		dto.setDegree(degMap);
		dto.setYearOfPass(passYearMap);
		
		Map<MockRating, Long> mockpers = batch.getEmployees().stream()
							.flatMap(emp->emp.getMockDetails().stream())
							.collect(Collectors.groupingBy(mock->mock.getMockRating(),Collectors.counting()));
		dto.setPerformance(mockpers);
		return dto;
	}
	
	@Cacheable(value = "BatchListCache",key = "'batchList'")
	@Override
	public List<BatchMentorListDTO> getBatchList() {
		List<Batch> batches = batchRepository.findAll();
		List<BatchMentorListDTO> batchDto = batches.stream().map(batch -> {
			Set<SkillDTO> skill = batch.getTechnologies().stream().map(tech -> batchUtils.skillToDto(tech))
					.collect(Collectors.toSet());
			 BatchMentorListDTO batchMentorToDto = batchUtils.batchMentorToDto(batch);
			 batchMentorToDto.setTechnologies(skill);
			return batchMentorToDto;
		}).collect(Collectors.toList());
		return batchDto;
	}

	@Override
	public List<EmpAttendenceDTO> getEmployees(String batchId, LocalDate date) {
		Optional<Batch> batch = batchRepository.findById(batchId);
		List<Employee> employees = batch.get().getEmployees();

				List<EmpAttendenceDTO> attendence = employees
				.stream().map(emp -> {
					
					List<EmployeeAttendence> atts=emp.getEmployeeAttendence().stream()
						.filter(att -> att.getAttendenceDate().equals(date)).toList();
					
					EmployeeAttendence att;
					if(atts.size()==0) {
						att=new EmployeeAttendence();
						att.setAttendenceDate(date);
						att.setAttendenceMorning(false);
						att.setAttendenceNoon(false);
					}					
					else {
					att=atts.get(0);
					}
					EmpAttendenceDTO dto=new EmpAttendenceDTO();
					dto.setEmployeeId(emp.getEmpId());
					dto.setEmployeeName(emp.getEmpName());
					dto.setAttendence(employeeUtils.attendenceToDto(att));
					
					return dto;
					
				}).collect(Collectors.toList());
		return attendence;
	}

	@Override
	public String morningAttendence(boolean status, String empId, LocalDate date) {
		Optional<Employee> employee = employeeRepository.findById(empId);
		List<EmployeeAttendence> atte = employee.get().getEmployeeAttendence().stream()
				.filter(att -> att.getAttendenceDate().isEqual(date)).collect(Collectors.toList());
		if (atte.size() != 0) {
			EmployeeAttendence att = atte.get(0);
			att.setAttendenceMorning(status);
			atte.add(att);
		} else {
			EmployeeAttendence atten = new EmployeeAttendence();
			atten.setAttendenceDate(date);
			atten.setAttendenceMorning(status);
			atten.setAttendenceNoon(false);
			atte.add(atten);
		}
		employee.get().setEmployeeAttendence(atte);
		employeeRepository.save(employee.get());
		return "SUCCESS";
	}

	@Override
	public String noonAttendence(boolean status, String empId, LocalDate date) {
		Optional<Employee> employee = employeeRepository.findById(empId);
		List<EmployeeAttendence> atte = employee.get().getEmployeeAttendence().stream()
				.filter(att -> att.getAttendenceDate().isEqual(date)).collect(Collectors.toList());
		if (atte.size() != 0) {
			EmployeeAttendence att = atte.get(0);
			att.setAttendenceNoon(status);
		} else {
			EmployeeAttendence atten = new EmployeeAttendence();
			atten.setAttendenceDate(date);
			atten.setAttendenceNoon(status);
			atte.add(atten);
		}
		employee.get().setEmployeeAttendence(atte);
		employeeRepository.save(employee.get());
		return "SUCCESS";
	}

	@Override
	public String registerMock(MockSheduleDTO mockSheduleDTO) throws DuplicateMockException {
		Optional<Batch> batch = batchRepository.findById(mockSheduleDTO.getBatchId());
		List<MockShedule> schedules = batch.get().getSchedules();
		List<MockShedule> mss = schedules.stream().filter(sce -> sce.getMockNo().equals(mockSheduleDTO.getMockNo()))
				.collect(Collectors.toList());
		if (mss.size() > 0) {
			throw new DuplicateMockException("Same batch same mock number is not permited");
		}
		MockShedule ms = new MockShedule();
		BeanUtils.copyProperties(mockSheduleDTO, ms);
		schedules.add(ms);
		batch.get().setSchedules(schedules);
		batchRepository.save(batch.get());
		return "SUCCESS";
	}

	@Override
	public String addRating(String empId, MockDetailsDTO mockDTO) throws MockReportDuplicateException {
		Optional<Employee> employee = employeeRepository.findById(empId);
		List<MockDetails> mocks = employee.get().getMockDetails();
		List<MockDetails> filterMock = mocks.stream().filter(
				mock -> mock.getMockNo().equals(mockDTO.getMockNo()) && mock.getType().equals(mockDTO.getType()))
				.collect(Collectors.toList());
		if (filterMock.size() > 0) {
			throw new MockReportDuplicateException("for one mock only one report");
		}
		MockDetails details = mentorUtils.dtoToMockDetails(mockDTO);
		if (mockDTO.getOverAll() >= 90)
			details.setMockRating(MockRating.EXCELENT);
		else if (mockDTO.getOverAll() >= 80 && mockDTO.getOverAll() <= 89)
			details.setMockRating(MockRating.GOOD);
		else if (mockDTO.getOverAll() >= 70 && mockDTO.getOverAll() <= 79)
			details.setMockRating(MockRating.ABOVE_AVERAGE);
		else if (mockDTO.getOverAll() >= 60 && mockDTO.getOverAll() <= 69)
			details.setMockRating(MockRating.AVERAGE);
		else if (mockDTO.getOverAll() >= 50 && mockDTO.getOverAll() <= 59)
			details.setMockRating(MockRating.BELOW_AVERAGE);
		mocks.add(details);
		employeeRepository.save(employee.get());
		details.setEmployee(employee.get());
		mockDetailsRepository.save(details);
		return "SUCCESS";
	}

	@Override
	public List<MentorEmpDetailsDTO> getEmployee(String batchId) {
		Optional<Batch> batch = batchRepository.findById(batchId);

		List<MentorEmpDetailsDTO> menEmpDTO =

				batch.get().getEmployees().stream().map(emp -> {
					Map<MockNo, MockRating> ratings = emp.getMockDetails().stream()
							.filter(mock -> mock.getType().getMockType().equalsIgnoreCase("MOCK"))
							.collect(Collectors.toMap(MockDetails::getMockNo, MockDetails::getMockRating));
					int noOfMocks = ratings.size();
					int attNo = emp.getEmployeeAttendence().size();
					List<EmployeeAttendence> atte = emp.getEmployeeAttendence().stream()
							.filter(att -> att.getAttendenceMorning() && att.getAttendenceNoon())
							.collect(Collectors.toList());

					MentorEmpDetailsDTO dto = new MentorEmpDetailsDTO();
					dto.setEmpId(emp.getEmpId());
					dto.setEmpName(emp.getEmpName());
					dto.setMockTaken(noOfMocks);
					dto.setMockRatings(ratings);
					dto.setTotalClasses(attNo);
					dto.setNumberOfPresent(atte.size());
					dto.setStatus(emp.getStatus().getEmpStatus());
					return dto;
				}).collect(Collectors.toList());

		return menEmpDTO;
	}

}
