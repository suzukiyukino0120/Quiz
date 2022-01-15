package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.Area;

@Repository
public class AreaRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Area> AREA_ROW_MAPPER = new BeanPropertyRowMapper<>(Area.class);
	
	public List<Area> findAll(){
		String sql = "SELECT * FROM areas";
		
		
		List<Area> arealist = template.query(sql, AREA_ROW_MAPPER);
		
		return arealist;
	}


	
}
