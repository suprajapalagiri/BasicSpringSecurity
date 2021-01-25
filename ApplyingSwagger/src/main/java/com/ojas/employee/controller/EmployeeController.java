package com.ojas.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.employee.model.Employee;
import com.ojas.employee.response.EmployeeResponse;
import com.ojas.employee.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@PostMapping( "/saveorupdate")
	public EmployeeResponse saveorupdateEmployee(@RequestBody Employee employee) {
		EmployeeResponse saveEmployee = employeeService.saveorupdateEmployee(employee);
		System.err.println("savinnggg");

		return saveEmployee;
	}
	@GetMapping( "/getId/{id}")
	public EmployeeResponse getEmployee(@PathVariable Integer id) {
		EmployeeResponse getEmployee = employeeService.getEmployee(id);
		System.err.println("savinnggg");
		return getEmployee;
	}
	
	@PostMapping( "/delete/{id}")
	public EmployeeResponse deleteEmployee(@PathVariable Integer id) {
		EmployeeResponse deleteEmployee = employeeService.deleteEmployee(id);
		System.err.println("savinnggg");
		return deleteEmployee;
	}
	@GetMapping("/getAll")
	public EmployeeResponse getAll() {
		EmployeeResponse allEmployee = employeeService.getAllEmployee();
		return allEmployee;
		
	}
}
