package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateQuizForm {
	@NotNull(message="カテゴリーを選択してください")
	private Integer category;
	
	@NotBlank(message="問題文を入力してください")
	private String questionContent;
	
	@NotNull(message="地域を選択してください")
	private Integer area;
	
	@NotBlank(message="答えを入力してください")
	private String answerContent;
	
	@NotBlank(message="答えの一言メモを入力してください")
	private String answerMemo;

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

	@Override
	public String toString() {
		return "CreateQuizForm [category=" + category + ", questionContent=" + questionContent + ", area=" + area
				+ ", answerContent=" + answerContent + ", answerMemo=" + answerMemo + "]";
	}

	
	
	

}
