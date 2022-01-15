package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Administrator;

@Repository
public class AdministratorRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = new BeanPropertyRowMapper<>(Administrator.class);

	public void insert(Administrator administrator) {
		String sql = "INSERT INTO administrators (employee_id, password) "
				+ "VALUES (:employeeId, :password)";
		
		SqlParameterSource param = new BeanPropertySqlParameterSource(administrator);
	
		template.update(sql, param);
	}
	
	
	public Administrator load(Integer employeeId){
		String sql = "SELECT * FROM administrators WHERE employee_id = :employeeId";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("employeeId", employeeId);
		
		List<Administrator> adminlist = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
		
		if(adminlist.size() == 0) {
			return null;
		}
		
		return adminlist.get(0);
	}

	public Administrator findByIdAndPass(Integer employeeId, String password){
		String sql = "SELECT * FROM administrators WHERE employee_id = :employeeId AND password = :password";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("employeeId", employeeId).addValue("password", password);
		
		List<Administrator> administratorList =template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);
		
		if(administratorList.size() == 0) {
			return null;
		}
		
		return administratorList.get(0);
	}
}
