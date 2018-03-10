package rdo_crud.service;

import java.util.List;

import rdo_crud.model.User;

public interface UserService {

	public List<User> listAllUsers();
	
	public void addUser(User user);
	
	public void updateUser(User rdo);
	
	public void deleteUser(int id);
	
	public User findUserById(int id);
	
}
