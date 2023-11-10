package com.te.lmsp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lmsp.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String>{

	Optional<AppUser> findByPassword(String password);

}
