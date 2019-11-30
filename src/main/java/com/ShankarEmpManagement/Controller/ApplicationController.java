package com.ShankarEmpManagement.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ShankarEmpManagement.Service.EmployeeService;
import com.ShankarEmpManagement.model.Employee;

@RestController
public class ApplicationController {

	@Autowired
	private EmployeeService servicere;
	
	//Get/Add/Update/Delete Operations
	
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
	@PutMapping("/update/{id}/employee/")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee emp, @PathVariable long id) {

		Optional<Employee> studentOptional = servicere.findById(id);

		if (!studentOptional.isPresent())
			return ResponseEntity.notFound().build();

		emp.setEmp_Id(id);

		 servicere.save(emp);

		return ResponseEntity.noContent().build();
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
	
	 
	// Adding an address 
		@PostMapping("/add/{address2}/employee/")
		public String addaddress(@RequestBody Employee emp , @PathVariable String address2) {
			servicere.add(emp);
			return "defined";

		}
		
		

}
