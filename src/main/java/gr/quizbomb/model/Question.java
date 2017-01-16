package gr.quizbomb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name ="question")

public class Question {

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "content")
	private String text;
	
	@Column(name = "isapproved",columnDefinition = "TINYINT")
	private boolean approved ;
	
	@Column(updatable = false)
	private Date created_at;
	
	@OneToMany(mappedBy="question", fetch = FetchType.EAGER)
	private List<Answer> answer;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id")
	private Course course;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "sclass_id")
	private SClass sClass;

	public Question() {
		super();
	}

	public Question(String text, boolean approved, int pcd, Date created_at, List<Answer> answer) {
		super();
		this.text = text;
		this.approved = approved;
		this.created_at = created_at;
		this.answer = answer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public SClass getsClass() {
		return sClass;
	}

	public void setsClass(SClass sClass) {
		this.sClass = sClass;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", text=" + text + ", approved=" + approved + ", created_at=" + created_at
				+ ", answer=" + answer + ", course=" + course + ", sClass=" + sClass + "]";
	}
	
}
	