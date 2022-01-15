package com.example.domain.notuse;

import java.util.List;

public class Question {
	private Integer id;
	
	private Integer category;
	
	private String content;
	
	private String area;
	
	private List<Answer> answerList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", category=" + category + ", content=" + content + ", area=" + area
				+ ", answerList=" + answerList + "]";
	}


	
	
	

}
