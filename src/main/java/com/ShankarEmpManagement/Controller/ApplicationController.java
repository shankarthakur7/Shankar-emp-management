package com.ShankarEmpManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ShankarEmpManagement.Service.EmployeeService;
import com.ShankarEmpManagement.model.Employee;

@RestController
public class ApplicationController {

	@Autowired
	private EmployeeService servicere;


	@GetMapping("/")
	public String hello() {
		return "";
	}

	// Employee Get API
	@GetMapping("/get/employee/")
	public List<Employee> getall(@RequestBody Employee employee) {
		return servicere.get(employee);
	}

	// Employee POST API
	@PostMapping("/add/employee/")
	public String add(@RequestBody Employee emp) {
		servicere.add(emp);
		return "employee add successfully";

	}

}
