package rdo_crud.service;

import java.util.List;

import rdo_crud.model.User;

/**
 * @author Aldrovando
 * Version 2.0
 */
public interface UserService {

	public List<User> listAllUsers();
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(int id);
	
	public User findUserById(int id);
	
	public User findUserByName(String user_name);
	
}
