package gr.quizbomb.model.dto;

import java.util.List;

public class CreateQuizSimpler {
	
	private String title;
	
	private List<QuestionForQuizSimpler> questions;

	public CreateQuizSimpler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreateQuizSimpler(String title, List<QuestionForQuizSimpler> questions) {
		super();
		this.title = title;
		this.questions = questions;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<QuestionForQuizSimpler> getQuestions() {
		return questions;
	}
	
	public void setQuestions(List<QuestionForQuizSimpler> questions) {
		this.questions = questions;
	}

}
