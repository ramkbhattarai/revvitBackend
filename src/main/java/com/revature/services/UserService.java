package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.dao.IUserDao;
import com.revature.dao.UserDao;
import com.revature.models.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;// = new UserDao() ;
	
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
	
	public User login(User u) {
		return userDao.login(u.getUsername(), u.getPassword());
	}
	
	public List<User> getAllFollowers(User u){
		return userDao.getAllFollowers(u);
	}
	
	public List<User> getAllGuruUserIsFollowing(User u){
		return userDao.getAllGuruUserIsFollowing(u);
	}
}
