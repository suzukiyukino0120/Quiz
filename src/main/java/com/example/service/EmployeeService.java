package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Employee;
import com.example.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee load(Integer id) {
		return employeeRepository.load(id);
	}
}
