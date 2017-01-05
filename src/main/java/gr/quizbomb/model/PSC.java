package gr.quizbomb.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class PSC {
	
	@EmbeddedId 
    public PSCID id;

    @MapsId("professor")
    @ManyToOne 
	public Professor professor;

    @MapsId("sClass")
    @ManyToOne 
    public SClass sClass;

    @MapsId("course")
    @ManyToOne
    public Course course;

	public PSCID getId() {
		return id;
	}

	public void setId(PSCID id) {
		this.id = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
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

}
