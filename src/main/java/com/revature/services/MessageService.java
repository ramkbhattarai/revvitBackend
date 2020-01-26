package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.dao.MessageDao;

import com.revature.models.Message;

@Service
public class MessageService {
	
	
	private MessageDao dao = new MessageDao();
	
	public List<Message> findAll(){
		return dao.findAll();
	}
	
	public Message findById(int id) {
		return dao.findById(id);
	}
	
	public Message save(Message m) {
		return dao.save(m);
	}
	
	public boolean update(Message m) {
		 return dao.update(m);
	}

}
