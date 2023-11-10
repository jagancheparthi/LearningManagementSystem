package com.te.lmsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lmsp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

}
