package rdo_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rdo_crud.dao.UserDao;
import rdo_crud.model.User;

/**
 * @author Aldrovando
 * Version 2.0
 */
@Service
public class UserServiceImpl implements UserService{

	UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> listAllUsers() {
		return userDao.listAllUsers();
	}

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);	
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	public User findUserById(int id) {
		return userDao.findUserById(id);
	}
	
	public User findUserByName(String user_name) {
		return userDao.findUserByName(user_name);
	}

	
}
