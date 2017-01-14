package gr.quizbomb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.quizbomb.model.User;
import gr.quizbomb.repository.UserDAO;
import gr.quizbomb.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService{
	
	@Autowired
	private UserDAO dao;

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		
	
		return dao.findByUsernameAndPassword(username, password);
	}
	

}
