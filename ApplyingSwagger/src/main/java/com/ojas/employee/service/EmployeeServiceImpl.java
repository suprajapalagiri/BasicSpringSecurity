package com.ojas.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.employee.model.Employee;
import com.ojas.employee.repository.EmployeeRepository;
import com.ojas.employee.response.EmployeeResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	EmployeeResponse employeeResponse = null;

	@Override
	public EmployeeResponse saveorupdateEmployee(Employee employee) {
		EmployeeResponse employeeResponse = null;

		if (employee == null) {
			employeeResponse = new EmployeeResponse();
			employeeResponse.setMessage("Employee not saved Successfully");
			employeeResponse.setStatusCode("422");
			employeeResponse.setData(null);
		} else {
			employeeResponse = new EmployeeResponse();
			Employee save = employeeRepository.save(employee);
			employeeResponse.setStatusCode("200");
			employeeResponse.setMessage("Employee saved successfully");
			employeeResponse.setData(save);
		}
		return employeeResponse;
	}

	@Override
	public EmployeeResponse getEmployee(Integer id) {
		employeeResponse = new EmployeeResponse();
		Optional<Employee> findById = employeeRepository.findById(id);
		if (findById.isPresent()) {
			employeeResponse.setStatusCode("200");
			employeeResponse.setMessage("Employee Record fetched successfully!!");
			employeeResponse.setData(findById);

		} else {
			employeeResponse.setStatusCode("422");
			employeeResponse.setMessage("Employee is not present with id :: " + id + " !!!");
			employeeResponse.setData(null);
		}
		return employeeResponse;
	}

	@Override
	public EmployeeResponse deleteEmployee(Integer id) {
		employeeResponse = new EmployeeResponse();
		Optional<Employee> findById = employeeRepository.findById(id);
		if (findById.isPresent()) {
			employeeRepository.delete(findById.get());
			employeeResponse.setStatusCode("200");
			employeeResponse.setMessage("Employee Record deleted successfully!!");
			employeeResponse.setData(findById);

		} else {
			employeeResponse.setStatusCode("422");
			employeeResponse.setMessage("Employee is not present with id :: " + id + " !!!");
			employeeResponse.setData(null);
		}
		return employeeResponse;
	}

	@Override
	public EmployeeResponse getAllEmployee() {
		employeeResponse = new EmployeeResponse();
		List<Employee> findAll = employeeRepository.findAll();
		if (findAll != null) {
			employeeResponse.setStatusCode("200");
			employeeResponse.setMessage("Employee Records fetched successfully!!");
			employeeResponse.setData(findAll);
		} else {
			employeeResponse.setStatusCode("422");
			employeeResponse.setMessage("No records found");
			employeeResponse.setData(null);
		}

		return employeeResponse;
	}

}
