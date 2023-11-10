package com.te.lmsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lmsp.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill,String>{
	Skill findBySkillName(String skillName);
}
