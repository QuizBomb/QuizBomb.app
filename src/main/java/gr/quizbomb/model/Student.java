package gr.quizbomb.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student extends User {

	@ManyToOne(optional = false)
    @JoinColumn(name="sclass_id")
	private SClass sClass;

	public SClass getsClass() {
		return sClass;
	}

	public void setsClass(SClass sClass) {
		this.sClass = sClass;
	}

}
