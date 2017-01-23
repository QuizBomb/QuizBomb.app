package gr.quizbomb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "score")
public class Score {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "student_id")
	private Student student;
	
	private float successrate;
	
	@Column(name="created_at", updatable = false)
	private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Quiz getStudentQuiz(){
		return quiz;
	}
	
	public void setStudentQuiz(Quiz quiz){
		this.quiz = quiz;
	}
	
	public Student getStudent(){
		return student;
	}
	
	public void setStudent(Student student){
		this.student = student;
	}

	public float getSuccessRate() {
		return successrate;
	}

	public void setSuccessRate(float successrate) {
		this.successrate = successrate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
}
