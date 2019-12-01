package com.ShankarEmpManagement.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.stereotype.Service;

import com.ShankarEmpManagement.Repository.EmployeeRepository;
import com.ShankarEmpManagement.model.Employee;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public List<Employee> get(Employee employee) {
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

	public Employee updateEmployee(long emp_Id, Employee employee) {

		if (repository.findById(emp_Id).isPresent()) {

			Employee exsitingEmployee = repository.findById(emp_Id).get();

			exsitingEmployee.setFirstname(exsitingEmployee.getFirstname());
			exsitingEmployee.setLastname(exsitingEmployee.getLastname());

			Employee udateEmployee = repository.save(exsitingEmployee);

			return new Employee(udateEmployee.getEmp_Id(), udateEmployee.getFirstname(), udateEmployee.getLastname());
		} else {
			return null;
		}

	}

	public Employee getEmployeeById(Long id) throws Exception {
		Optional<Employee> employee = repository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new Exception("No employee record exist for given id");
		}
	}

	public Employee UpdateEmployees(Employee employee) throws RecordTypeNotSupportedException {
		Optional<Employee> emplo = repository.findById(employee.getEmp_Id());

		if (emplo.isPresent()) {
			Employee newEmployee = emplo.get();
			newEmployee.setAddress1(employee.getAddress1());
			
			newEmployee = repository.save(newEmployee);

			return newEmployee;
		} else {
			employee = repository.save(employee);

			return employee;
		}
	}

	public void deleteEmployeeById(Long id) throws Exception {
		Optional<Employee> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new Exception("No employee record exist for given id");
		}
	}

	// add/update/delete address types employee
	public Employee getEmployeesAddress(String address1, String address2, String address3) throws Exception {
		Optional<Employee> employee = repository.findOne(address1, address2, address3);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new Exception("No employee record exist for given String");
		}
	}
	
	public Employee UpdateAddressEmployee(Employee employee) throws Exception {
		Optional<Employee> emplo = repository.findById(employee.getEmp_Id());

		if (emplo.isPresent()) {
			Employee newEmployee = emplo.get();
			newEmployee.setAddress1(employee.getAddress1());
			newEmployee.setAddress1(employee.getAddress2());
			newEmployee.setAddress1(employee.getAddress3());

			newEmployee = repository.save(newEmployee);

			return newEmployee;
		} else {
			employee = repository.save(employee);

			return employee;
		}
	}	
		public void deleteEmployeeAddress(Long id,Employee address1 ,
				Employee address2 ,Employee address3) throws Exception {
			Optional<Employee> employee = repository.findById(id);

			if (employee.isPresent()) {
				repository.delete(address1);
				repository.delete(address2);
				repository.delete(address3);
			} else {
				throw new Exception("No employee record exist for given id");
			}
		}
	
}
