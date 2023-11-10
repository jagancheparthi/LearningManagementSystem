package com.te.lmsp.util;

import org.springframework.stereotype.Component;

import com.te.lmsp.dto.BatchDTO;
import com.te.lmsp.dto.BatchMentorListDTO;
import com.te.lmsp.dto.EmpAttendenceDTO;
import com.te.lmsp.dto.SkillDTO;
import com.te.lmsp.entity.Batch;
import com.te.lmsp.entity.Employee;
import com.te.lmsp.entity.Skill;
@Component
public class BatchUtils {
	public Skill dtoToSkill(SkillDTO skillDTO) {
		return Skill.builder()
				.skillName(skillDTO.getSkillName())
				.build();
	}
	public SkillDTO skillToDto(Skill skill) {
		return SkillDTO.builder()
				.skillName(skill.getSkillName())
				.build();
	}
	public BatchDTO batchToDto(Batch batch) {
		return BatchDTO.builder()
						.batchId(batch.getBatchId())
						.batchName(batch.getBatchName())
						.batchStatus(batch.getBatchStatus())
						.batchStrength(batch.getBatchStrength())
						.batStartDate(batch.getBatStartDate())
						.batEndDate(batch.getBatEndDate())
					    .build();
	}
	public BatchMentorListDTO batchMentorToDto(Batch batch) {
		return BatchMentorListDTO.builder()
						.batchId(batch.getBatchId())
						.batchName(batch.getBatchName())
						.batchStatus(batch.getBatchStatus())
						.batchStrength(batch.getBatchStrength())
						.batStartDate(batch.getBatStartDate())
						.batEndDate(batch.getBatEndDate())
					    .build();
	}
	public EmpAttendenceDTO empToEmpAttDto(Employee employee) {
		return EmpAttendenceDTO.builder()
								.employeeId(employee.getEmpId())
								.employeeName(employee.getEmpName())
								.build();
	}
}
