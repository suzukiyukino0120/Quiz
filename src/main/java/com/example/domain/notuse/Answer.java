package com.example.domain.notuse;

public class Answer {
	
	private Integer id;
	
	private Integer questionId;
	
	private Integer category;
	
	private String content;
	
	private String memo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", question_id=" + questionId + ", category=" + category + ", content=" + content
				+ ", memo=" + memo + "]";
	}
	
	

}
