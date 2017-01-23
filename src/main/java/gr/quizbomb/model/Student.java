package gr.quizbomb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "student")
public class Student extends User {

	@ManyToOne(optional = false)
    @JoinColumn(name="sclass_id")
	private SClass sClass;
	
	@OneToMany(mappedBy="student")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Score> score;

	public Student() {
		super();
	}

	public Student(String fullName, String username, String email, String password, SClass sClass) {
		super(fullName, username, email, password);
		this.sClass = sClass;
	}
	
	public String getRole(){
		
		return "student";
	}

	public SClass getsClass() {
		return sClass;
	}

	public void setsClass(SClass sClass) {
		this.sClass = sClass;
	}

	public List<Score> getScore() {
		return score;
	}

	public void setScore(List<Score> score) {
		this.score = score;
	}

}
