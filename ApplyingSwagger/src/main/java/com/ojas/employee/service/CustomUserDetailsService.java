package com.ojas.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ojas.employee.model.CustomUserDetails;
import com.ojas.employee.model.Employee;
import com.ojas.employee.repository.EmployeeRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee> findByName = employeeRepository.findByName(username);
		if (findByName.isPresent()) {
			return new CustomUserDetails(findByName.get());

		} else
			throw new UsernameNotFoundException("User Not Found!!!!");
	}

}
