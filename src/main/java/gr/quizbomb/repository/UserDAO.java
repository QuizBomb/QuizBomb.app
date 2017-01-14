package gr.quizbomb.repository;

import gr.quizbomb.model.User;

public interface UserDAO extends GenericRepository<User>{
	
	public User findByUsernameAndPassword(String username, String password);
}
