package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.revature.dao.UserDao;
import com.revature.models.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<User> findAll(){
		return userDao.findAll();
	}
	
	public User findById(int id) {
		return userDao.findById(id);
	}
	
	public User save(User u) {
		return userDao.save(u);
	}
	
	public boolean update(User u) {
		 return userDao.update(u);
	}
	
	public User login(String username, String password ) {
		return userDao.login(username, password);
	}
	
	public List<User> getAllFollowers(User u){
		return userDao.getAllFollowers(u);
	}
	
	public List<User> getAllGuruUserIsFollowing(User u){
		return userDao.getAllGuruUserIsFollowing(u);
	}
}
