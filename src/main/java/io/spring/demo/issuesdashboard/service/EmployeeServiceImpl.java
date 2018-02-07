package io.spring.demo.issuesdashboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.spring.demo.issuesdashboard.domain.Employee;
import io.spring.demo.issuesdashboard.repo.EmployeeRepository;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository empRepo;
	
	public EmployeeServiceImpl(EmployeeRepository empRepo){
		this.empRepo = empRepo;
	}
	
	//TODO - USE OPTIONAL AND @Transactional Later
	public List<Employee> getAllEmployees(){
		return this.empRepo.findAll();
	}
}
