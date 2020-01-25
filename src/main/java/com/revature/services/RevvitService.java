package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.dao.HashTagDao;
import com.revature.dao.IRevvitDao;
import com.revature.dao.RevvitDao;
import com.revature.models.Revvit;
import com.revature.models.User;

@Service
public class RevvitService {
	
	
	@Autowired
	private RevvitDao revvitDao;// = new RevvitDao(); 
	
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
