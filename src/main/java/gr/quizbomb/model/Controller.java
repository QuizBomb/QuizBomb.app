package gr.quizbomb.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "controller")
public class Controller extends User {

	public String getRole(){
		
		return "controller";
	}
	
	public Controller(String fullName, String username, String email, String password) {
		super(fullName, username, email, password);
	}
	
}
