package com.example.domain;

public class Quiz {
	private Integer id;
	
	private Integer category;
	
	private String questionContent;
	
	private Integer area;
	
	private String answerContent;
	
	private String answerMemo;
	
	private String categoryName;
	
	private String areaName; 

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

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public String getAnswerMemo() {
		return answerMemo;
	}

	public void setAnswerMemo(String answerMemo) {
		this.answerMemo = answerMemo;
	}
	
	

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", category=" + category + ", questionContent=" + questionContent + ", area=" + area
				+ ", answerContent=" + answerContent + ", answerMemo=" + answerMemo + ", categoryName=" + categoryName
				+ ", areaName=" + areaName + "]";
	}

	
	
	

}
