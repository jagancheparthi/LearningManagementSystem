package com.te.lmsp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lmsp.entity.Employee;
import com.te.lmsp.entity.RequestData;

public interface RequestDataRepository extends JpaRepository<RequestData, String>{

	Optional<RequestData> findByEmployee(Employee employee);

}
