package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Quiz;
import com.example.repository.QuizRepository;

@Service
@Transactional
public class QuizService {

	@Autowired
	private QuizRepository quizRepository;
	
	public List<Quiz>findRandom(Integer category){
		return quizRepository.findRandom(category);
	}
	
	public void insert(Quiz quiz){
		quizRepository.insert(quiz);
	}
	
	public Quiz findByCategoryAndArea(Integer category, Integer area){
		return quizRepository.findByCategoryAndArea(category, area);
		
	}
	
	public List<Quiz> findAll(){
		return quizRepository.findAll();
	}
	
	public Quiz findById(Integer id) {
		return quizRepository.findById(id);
	}
	
	public void update(Quiz quiz) {
		quizRepository.update(quiz);
	}
	
	public void delete(Integer id) {
		quizRepository.delete(id);
	}
	

}
