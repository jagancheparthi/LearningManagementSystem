package com.te.lmsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lmsp.entity.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, String>{

	Mentor findByMentorName(String mentorName);

}
