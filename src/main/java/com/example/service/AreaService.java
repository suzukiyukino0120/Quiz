package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Area;
import com.example.repository.AreaRepository;

@Service
@Transactional
public class AreaService {

	@Autowired
	private AreaRepository areaRepository;
	
	public List<Area> findAll() {
		return areaRepository.findAll();
	}
}
