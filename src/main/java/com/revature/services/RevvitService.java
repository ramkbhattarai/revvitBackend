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

@Service
public class RevvitService {
	
	
	@Autowired
	private RevvitDao dao;// = new RevvitDao(); 
	
	public List<Revvit> findAll(){
		return dao.findAll();
	}
	
	public Revvit findById(int id) {
		return dao.findById(id);
	}
	
	public Revvit save(Revvit r) {
		return dao.save(r);
	}
	
	public boolean update(Revvit r) {
		 return dao.update(r);
	}

}
