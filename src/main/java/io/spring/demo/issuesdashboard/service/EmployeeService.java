package io.spring.demo.issuesdashboard.service;

import java.util.List;

import io.spring.demo.issuesdashboard.domain.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
}
