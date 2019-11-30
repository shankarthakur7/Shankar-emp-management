package com.ShankarEmpManagement.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShankarEmpManagement.Repository.EmployeeRepository;
import com.ShankarEmpManagement.model.Employee;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	
	public List<Employee> get(Employee employee){
		return repository.findAll();		
	}
	
	public void add(Employee emp) {
		repository.save(emp);
	}
	
	/*
	 * public void addprofile(EmpProfile empProfile) { repository2.save(empProfile);
	 * }
	 * 
	 * public List<EmpProfile> getProfile(EmpProfile empProfile) { return
	 * repository2.findAll(); }
	 */
}
