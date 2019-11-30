package com.ShankarEmpManagement.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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

	public Optional<Employee> findById(long id) {
		return repository.findById(id);
	}

	public void deleteById(long id) {
		repository.deleteById(id);
		
	}

	public void save(Employee emp) {
		repository.save(emp);
		
	}
	
	@Query("FROM employee WHERE address1 = ? 1")
	public List<Employee> addaddress1(long id, String address1){
		return repository.save(id);
	}
	
	/*
	 * public void addprofile(EmpProfile empProfile) { repository2.save(empProfile);
	 * }
	 * 
	 * public List<EmpProfile> getProfile(EmpProfile empProfile) { return
	 * repository2.findAll(); }
	 */
}
