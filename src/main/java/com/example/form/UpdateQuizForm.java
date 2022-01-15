package com.example.form;

import javax.validation.constraints.NotBlank;

public class UpdateQuizForm {
	@NotBlank(message="��蕶����͂��Ă�������")
	private String questionContent;
	
	@NotBlank(message="��������͂��Ă�������")
	private String answerContent;
	
	@NotBlank(message="�����̈ꌾ��������͂��Ă�������")
	private String answerMemo;
	
	private Integer id;

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
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
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UpdateQuizForm [questionContent=" + questionContent + ", answerContent=" + answerContent
				+ ", answerMemo=" + answerMemo + ", id=" + id + "]";
	}

	
	
	

}
