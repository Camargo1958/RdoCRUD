package rdo_crud.dao;

import java.util.List;

import rdo_crud.model.User;

public interface UserDao {

	public List<User> listAllUsers();
	
	public void addUser(User user);
	
	public void updateUser(User rdo);
	
	public void deleteUser(int id);
	
	public User findUserById(int id);
}
