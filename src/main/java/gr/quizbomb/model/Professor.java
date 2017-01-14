package gr.quizbomb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor extends User {
	
	/* Triple manyToMany association as described here:
	 * http://stackoverflow.com/questions/9986569/hibernate-triple-many-to-many-join
	 */
	@OneToMany(mappedBy="professor", fetch = FetchType.EAGER) 
	public List<PSC> classCourse;
	
	public String getRole(){
		
		return "professor";
	}

	public List<PSC> getClassCourse() {
		return classCourse;
	}

	public void setClassCourse(List<PSC> classCourse) {
		this.classCourse = classCourse;
	}
	
}
