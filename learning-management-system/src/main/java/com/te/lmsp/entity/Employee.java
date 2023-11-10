package com.te.lmsp.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.te.lmsp.enums.BloodGroup;
import com.te.lmsp.enums.Degree;
import com.te.lmsp.enums.EmployeeStatus;
import com.te.lmsp.enums.Gender;
import com.te.lmsp.enums.Nationality;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name = "emp_id")
	private String empId;

	@NotNull(message = "NULL data passed for empName")
	@NotBlank(message = "BLANK data passes empName")
	@Size(min = 2, max = 100)
	@Column(name = "emp_name")
	private String empName;

	@NotNull
	@NotBlank
	@Email(message = "Email is not valid")
	@Column(name = "emp_email", unique = true)
	private String email;

	@NotNull(message = "NULL data passed for dateOfBirth")
	@Column(name = "emp_dob")
	private LocalDate dateOfBirth;

	@NotNull(message = "NULL data passed for dateOfJoining")
	@Column(name = "emp_doj")
	private LocalDate dateOfJoining;

	@NotNull(message = "NULL data passed for designation")
	@NotBlank(message = "BLANK data passes designation")
	@Column(name = "designation")
	private String designation;

	@NotNull(message = "NULL data passed for nationality")
	@Enumerated(EnumType.STRING)
	private Nationality nationality;

	@NotNull(message = "NULL data passed for gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@NotNull(message = "NULL data passed for bloodGroup")
	@Enumerated(EnumType.STRING)
	private BloodGroup bloodGroup;

	@NotNull(message = "NULL data passed for degree")
	@Enumerated(EnumType.STRING)
	private Degree degree;

	@NotNull(message = "Status should not be null")
	@Enumerated(EnumType.STRING)
	private EmployeeStatus status;

	@OneToMany(cascade = CascadeType.ALL)
	private List<EmployeeAttendence> employeeAttendence;

	@ManyToOne(cascade = CascadeType.ALL)
	private Batch batch;
	
	@NotNull(message = "SecondaryDetails should not be null")
	@OneToOne(cascade = CascadeType.ALL)
	private SecondaryInfo secondaryInfo;

	@OneToMany(cascade = CascadeType.ALL)
	private List<EmployeeEducationalDetails> educationDetails;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> addresses;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<MockDetails> mockDetails;

	@OneToOne(cascade = CascadeType.ALL)
	private EmployeeBankDetails bankDetails;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Technology> technologies;

	@Nullable
	@OneToMany(cascade = CascadeType.ALL)
	private List<EmployeeExperience> experiences;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Contact> contacts;
}
