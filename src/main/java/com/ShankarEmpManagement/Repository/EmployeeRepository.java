package com.ShankarEmpManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShankarEmpManagement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Optional<Employee> findOne(String address1,String address2,
			String address3);

	


	
}
