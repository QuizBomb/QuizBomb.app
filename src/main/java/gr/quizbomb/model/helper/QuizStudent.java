package gr.quizbomb.model.helper;

import java.util.List;

import gr.quizbomb.model.Question;

public class QuizStudent {
	
	private Long id;
	private String title;
	private float successrate;
	private String course;
	
	
	private List<Question> questions;

	public QuizStudent(Long id, String title, String course, List<Question> questions) {
		super();
		this.id = id;
		this.title = title;
		this.course = course;
		this.questions = questions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public float getSuccessrate() {
		return successrate;
	}

	public void setSuccessrate(float successrate) {
		this.successrate = successrate;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
