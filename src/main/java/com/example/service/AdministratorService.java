package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Administrator;
import com.example.domain.Employee;
import com.example.repository.AdministratorRepository;
import com.example.repository.EmployeeRepository;

@Service
@Transactional
public class AdministratorService {

	@Autowired
	private AdministratorRepository administratorRepository;
	
	public void insert(Administrator administrator) {
		administratorRepository.insert(administrator);
	}
	
	public Administrator load(Integer id) {
		return administratorRepository.load(id);
	}
	
	public Administrator findByIdAndPass(Integer id, String pass) {
		return administratorRepository.findByIdAndPass(id, pass);
	}
}
