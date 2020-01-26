package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.revature.dao.HashTagDao;

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
