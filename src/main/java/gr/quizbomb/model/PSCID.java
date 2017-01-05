package gr.quizbomb.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PSCID implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@ManyToOne 
	public Professor professor;
	
    @ManyToOne 
    public SClass sclass;
    
    @ManyToOne 
    public Course course;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((professor == null) ? 0 : professor.hashCode());
		result = prime * result + ((sclass == null) ? 0 : sclass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PSCID other = (PSCID) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		if (sclass == null) {
			if (other.sclass != null)
				return false;
		} else if (!sclass.equals(other.sclass))
			return false;
		return true;
	}

}
