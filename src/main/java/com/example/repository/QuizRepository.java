package com.example.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Quiz;


@Repository
public class QuizRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Quiz> QUIZ_ROW_MAPPER = new BeanPropertyRowMapper<>(Quiz.class);
	
	private static ResultSetExtractor<List<Quiz>> QUIZ_EXTRACTOR
	=(rs) ->{
		Map<Integer, Quiz> quizMap = new LinkedHashMap();
		
		Quiz quiz = null;
		
		while(rs.next()) {
			
			Integer quizId = rs.getInt("q_id");
			
				quiz = new Quiz();
				quiz.setId(rs.getInt("q_id"));
				quiz.setCategory(rs.getInt("q_category"));
				quiz.setQuestionContent(rs.getString("question_content"));
				quiz.setArea(rs.getInt("q_area"));
				quiz.setAnswerContent(rs.getString("answer_content"));
				quiz.setAnswerMemo(rs.getString("answer_memo"));
				quiz.setAreaName(rs.getString("a_name"));
				quiz.setCategoryName(rs.getString("c_name"));
				quizMap.put(quizId, quiz);
			
		}
		if(quizMap.size() == 0) {
			return null;
		}
		
		return new ArrayList<Quiz>(quizMap.values());
	};
	
	public List<Quiz> findRandom(Integer category) {
		String sql = "SELECT * FROM quizzes WHERE category = :category ORDER BY RAND() LIMIT 3";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("category", category);
	    List<Quiz> quizList = template.query(sql, param, QUIZ_ROW_MAPPER);
		
	    return quizList;
	}

	public void insert(Quiz quiz) {
		String sql = "INSERT INTO quizzes (category, question_content, area, answer_content, answer_memo) "
				+ "VALUES(:category, :questionContent, :area, :answerContent, :answerMemo)";
		
		SqlParameterSource param = new BeanPropertySqlParameterSource(quiz);
		
		template.update(sql, param);
	}
	
	public void delete(Integer id) {
		String sql = "DELETE FROM quizzes WHERE id = :id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		template.update(sql, param);
		
	}
	
	public Quiz findByCategoryAndArea(Integer category, Integer area){
		String sql = "SELECT * FROM quizzes WHERE category = :category AND area = :area";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("category", category).addValue("area", area);
		
		List<Quiz> quizList = template.query(sql, param, QUIZ_ROW_MAPPER);
		
		if(quizList.size() == 0) {
			return null;
		}
		
		return quizList.get(0);
	}
	
	public List<Quiz> findAll(){
		String sql = "SELECT q.id AS q_id, q.area AS q_area, q.category AS q_category, q.question_content, q.answer_content, q.answer_memo,"
				+ "a.id AS a_id, a.name AS a_name, c.id AS c_id, c.name AS c_name "
				+ "FROM quizzes AS q "
				+ "JOIN areas AS a ON q.area = a.id "
				+ "JOIN categories AS c ON q.category = c.id "
				+ "ORDER BY q.id";
		
		List<Quiz> quizlist = template.query(sql, QUIZ_EXTRACTOR);
		
		return quizlist;
	}
	
	public Quiz findById(Integer id) {
		String sql = "SELECT q.id AS q_id, q.area AS q_area, q.category AS q_category, q.question_content, q.answer_content, q.answer_memo,"
				+ "a.id AS a_id, a.name AS a_name, c.id AS c_id, c.name AS c_name "
				+ "FROM quizzes AS q "
				+ "JOIN areas AS a ON q.area = a.id "
				+ "JOIN categories AS c ON q.category = c.id "
				+ "HAVING q.id = :id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		List<Quiz> quizList = template.query(sql, param, QUIZ_EXTRACTOR);
		
		if(quizList.size() == 0) {
			return null;
		}
		
		return quizList.get(0);
	}
	
	public void update(Quiz quiz) {
		String sql = "UPDATE quizzes "
				+ "SET question_content = :questionContent, answer_content = :answerContent, answer_memo = :answerMemo "
				+ "WHERE id = :id";
		
		SqlParameterSource param = new BeanPropertySqlParameterSource(quiz);
		
		template.update(sql, param);
	}
	
}

