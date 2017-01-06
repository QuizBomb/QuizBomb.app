package gr.quizbomb.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="question")

public class Question {

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "content")
	private String text;
	
	@Column(name = "isapproved",columnDefinition = "TINYINT")
	private boolean approved ;
	
	@Column(name = "pcd_id",columnDefinition = "UNSIGNED INT(10)")
	private int pcd ;
	
	@Column(updatable = false)
	private Date created_at;
	
	@OneToMany(mappedBy="question_id")
	private  List<Answer> answer;
	
	public Question(int id,String text,int pcd )
	{
		this.id = id;
		this.text = text;
		this.approved = false;
		this.pcd = pcd;
		

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getPcd() {
		return pcd;
	}

	public void setPcd(int pcd) {
		this.pcd = pcd;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	public List<Answer> getAnswerList() {
		return answer;
	}

	public void setAnswerList(List<Answer> ans) {
		this.answer = ans;
	}
}
	