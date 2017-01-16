package gr.quizbomb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "quiz")
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "sclass_id")
	private SClass sClass;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "course_id")
	private Course course;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "quiz_question", joinColumns = @JoinColumn(name = "quiz_id", referencedColumnName = "id"), 
               inverseJoinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id"))
	private List<Question> questions;
	
	private String title;
	
	@Column(updatable = false)
	private Date created_at;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public SClass getsClass() {
		return sClass;
	}
	
	public void setsClass(SClass sClass) {
		this.sClass = sClass;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}

	public List<Question> getQuestions() {
        return questions;
    }
	
	public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

}
