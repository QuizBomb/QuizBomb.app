package gr.quizbomb.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table(name ="answer")
public class Answer {
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;
	
	private String content;
	
	private boolean correct;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "question_id")
	private Question question;

	public Answer() {
		super();
	}

	
	public Answer(String content, boolean correct, Question question) {
		super();
		this.content = content;
		this.correct = correct;
		this.question = question;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
		
	
}
