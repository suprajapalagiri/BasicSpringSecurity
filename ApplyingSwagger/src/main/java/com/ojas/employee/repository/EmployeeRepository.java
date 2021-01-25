package com.ojas.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
public Optional<Employee> findByName(String name);
}
