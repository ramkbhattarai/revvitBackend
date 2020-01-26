package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.revature.dao.RevvitDao;
import com.revature.models.Revvit;
import com.revature.models.User;

@Service
public class RevvitService {
	
	
	@Autowired
	private RevvitDao revvitDao;
	
	public List<Revvit> findAll(){
		return revvitDao.findAll();
	}
	
	public Revvit findById(int id) {
		return revvitDao.findById(id);
	}
	
	public Revvit save(Revvit r) {
		return revvitDao.save(r);
	}
	
	public boolean update(Revvit r) {
		 return revvitDao.update(r);
	}
	
	public List<Revvit> findByAuthor(User u){
		return revvitDao.findByAuthor(u);
		 
	}
	
	public boolean delete(int id) {
		return revvitDao.delete(id);
	}

}
