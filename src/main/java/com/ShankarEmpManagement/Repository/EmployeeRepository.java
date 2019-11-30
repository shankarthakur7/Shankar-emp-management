package com.ShankarEmpManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShankarEmpManagement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	List<Employee> save(long id);
	
}
