package gr.quizbomb.service;

import gr.quizbomb.model.User;

public interface UserService extends GenericService<User>{

	public User findUserByUsernameAndPassword(String username, String password);

}
