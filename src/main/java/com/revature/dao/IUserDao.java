package com.revature.dao;

import java.util.List;

import com.revature.models.User;

public interface IUserDao {

	public List<User> findAll();
	public User findById(int id);
	public User save(User u);
	public boolean update(User u);
}
