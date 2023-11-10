package com.te.lmsp.controller;

import java.sql.Timestamp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lmsp.dto.AppUserDTO;
import com.te.lmsp.dto.EmployeeDTO;
import com.te.lmsp.exception.RegistrationErrorException;
import com.te.lmsp.response.SuccessResponse;
import com.te.lmsp.security.JwtUtils;
import com.te.lmsp.service.EmployeeService;

import lombok.RequiredArgsConstructor;
@RequestMapping(path = "/auth")
@RequiredArgsConstructor
@RestController
public class AppUserController {
	private final EmployeeService employeeService;
	private final AuthenticationManager authenticationManager;
	private final JwtUtils jwtUtils;

	/* CHECKED */
	
	@PostMapping(path = "/register")
	public ResponseEntity<SuccessResponse> saveEmployee(@RequestBody EmployeeDTO employeeDTO)
			throws RegistrationErrorException {
		return new ResponseEntity<SuccessResponse>(
				SuccessResponse.builder().data(employeeService.saveEmployee(employeeDTO)).message("REGISTRATION SUCCESSFUL")
										.timeStamp(new Timestamp(System.currentTimeMillis())).build(),
				HttpStatus.ACCEPTED);
	}
	
	/* CHECKED */
	
	@PostMapping(path = "/login")
	public String logIn(@RequestBody AppUserDTO appUserDto) {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				appUserDto.getUsername(), appUserDto.getPassword());
		authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		return jwtUtils.generateToken(appUserDto.getUsername());

	}
	
}

/* JSON FOR REGISTER EMPLOYEE */

//{
//    "empName":"GOPI",
//    "email":"gopi@gmail.com",
//    "dateOfBirth":"1999-07-07",
//	"dateOfJoining":"2022-07-07",
//    "designation":"ASE",
//    "nationality":"INDIA",
//    "gender":"MALE",
//    "bloodGroup":"A_POSITIVE",
//    "degree":"B_TECH",
//    "status":"ACTIVE",
//    
//	"secondaryInfoDTO":
//            {
//                "aadhaarNo":"476157160424",
//                "panNo":"Y00YF3r2",
//                "fatherName":"HARI",
//                "motherName":"PARVATHI",
//                "spouseName":"NO",
//                "passportNo":"BFo6UF0V",
//                "maritalStatus":"MARRIED"
//            },
//    "educationDetailsDTO":[
//        {
//                "educationType":"REGULAR",
//                "yearOfPassing":"2020",
//                "percentage":"90",
//                "universityName":"KITS",
//                "instituteName":"KITS",
//                "specialization":"CIVIL",
//                "state":"ANDRA PRADESH"
//        }
//    ],
//    "addressesDTO":[
//        {
//            "addCity":"GUNTUR",
//            "addDoorNo":"2-156",
//            "addLandMark":"TEMPLE",
//            "addLocality":"MALL",
//            "addPincode":"522019",
//            "addState":"AP",
//            "addStreet":"MALL",
//            "addressType":"PERMANENT"
//        }
//    ],
//    "bankDetailsDTO":{
//             "accountNo":"3474220220573",
//             "bankName":"SDJ",
//			   "accountType":"SAVINGS",
//			   "ifsc":"SDHKJ",
//			   "branch":"PTP",
//			   "state":"AP"
//  },
//    "technologiesDTO":[
//        {
//            "skillType":"JAVA",
//            "skillRating":"GOOD",
//            "yearOfExperienceOnSkill":"2"
//        }
//    ],
//
//	"experiencesDTO":[
//        {
//            "companyName":"DXC",
//            "yearsOfExperience":"2",
//            "dataOfJoining":"2020-01-03",
//            "dataOfRelieving":"2023-01-03",
//            "designation":"ASE",
//            "location":"HYDERABAD"
//        }
//    ],
// "contacts":[
//     {
//
//            "contactNumber":"9000160304",
//            "contactType":"PRIMARY"
//     }
// ]
//    }

/* JSON FOR LOGIN EMPLOYEE */

//{
//    "username":"77e8437a-d23d-4ac8-9cbb-b0ac23a65807",
//    "password":"576f5b28-ad96-41c6-bb60-60bb74f3829a"
//}