package com.ShankarEmpManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShankarEmpManagement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
