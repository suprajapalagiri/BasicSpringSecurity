package com.ojas.employee.service;

import com.ojas.employee.model.Employee;
import com.ojas.employee.response.EmployeeResponse;

public interface EmployeeService {
	public EmployeeResponse saveorupdateEmployee(Employee employee);

	public EmployeeResponse getEmployee(Integer id);
	
	public EmployeeResponse deleteEmployee(Integer id);
	
	public EmployeeResponse getAllEmployee();
}
