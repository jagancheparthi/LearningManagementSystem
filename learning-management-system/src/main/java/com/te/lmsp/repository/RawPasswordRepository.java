package com.te.lmsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lmsp.entity.RawPasswords;

public interface RawPasswordRepository extends JpaRepository<RawPasswords, String>{

}
