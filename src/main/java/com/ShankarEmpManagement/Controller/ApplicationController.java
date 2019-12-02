package com.ShankarEmpManagement.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ShankarEmpManagement.Service.EmployeeService;
import com.ShankarEmpManagement.model.Employee;

@RestController
public class ApplicationController {

	@Autowired
	private EmployeeService servicere;

	// Get/Add/Update/Delete Operations

	// Getting An Employee API
	@GetMapping("/get/{id}/employee/")
	public Employee getEmployeeById(@PathVariable long id) throws Exception {
		Optional<Employee> emp = servicere.findById(id);

		if (!emp.isPresent())
			throw new Exception("id-" + id);

		return emp.get();
	}

	// Adding an Employee API
	@PostMapping("/add/employee/")
	public String add(@RequestBody Employee emp) {
		servicere.add(emp);
		return "employee add successfully";

	}

	// updating an Employee API
	@PutMapping(value = "update/{emp_Id}/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "emp_Id") long emp_Id,
			@RequestBody Employee employee) {
		return new ResponseEntity<>(servicere.updateEmployee(emp_Id, employee), HttpStatus.OK);
	}

	// Delete An Employee API
	@DeleteMapping("/delete/{id}/employee")
	public String deleteStudent(@PathVariable long id) {
		servicere.deleteById(id);
		return "employee Deleted Succesfully";
	}

	// List all employees
	@GetMapping("/get/allEmployee/")
	public List<Employee> getall(@RequestBody Employee employee) {
		return servicere.get(employee);
	}


	//Address APIs for add/update/delete 
	@GetMapping("getaddress/{id}/")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws Exception {
		Employee entity = servicere.getEmployeeById(id);

		return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	//update API
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> createOrUpdateEmployee(Employee employee)
			throws Exception {
		Employee updated = servicere.UpdateEmployees(employee);
		return new ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	//delete API
	@DeleteMapping("getaddress/{id}/")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws Exception {
		servicere.deleteEmployeeById(id);
		return HttpStatus.FORBIDDEN;
	}
	
	
	
	//Address Types APIs for get/add/update/delete
	@GetMapping("getaddresstypes/{id}/")
	public ResponseEntity<Employee> getEmployeesAddress(@PathVariable("id") Long id, 
			String address1, String address2, String address3) throws Exception {
		Employee entity = servicere.getEmployeesAddress(address1, address2, address3);

		return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	

	@PutMapping("/updateaddress/{id}")
	public ResponseEntity<Employee> UpdateAddressEmployee(Employee employee)
			throws Exception {
		Employee updated = servicere.UpdateAddressEmployee(employee);
		return new ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("deleteAddress/{id}/")
	public HttpStatus deleteEmployeeAddress(@PathVariable("id") Long id,Employee address1 ,
			Employee address2 ,Employee address3) throws Exception {
		servicere.deleteEmployeeAddress(id, address1, address2, address3);
		return HttpStatus.FORBIDDEN;
	}
	
}
