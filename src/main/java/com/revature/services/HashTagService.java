package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.dao.HashTagDao;
import com.revature.dao.IHashTag;
import com.revature.dao.UserDao;
import com.revature.models.HashTag;

@Service
public class HashTagService {
	

	
	private HashTagDao dao = new HashTagDao(); 
	
	public List<HashTag> findAll(){
		return dao.findAll();
	}
	
	public HashTag findById(int id) {
		return dao.findById(id);
	}
	
	public HashTag save(HashTag m) {
		return dao.save(m);
	}
	
	public boolean update(HashTag m) {
		 return dao.update(m);
	}

}
