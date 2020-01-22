package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.dao.IMessage;
import com.revature.dao.MessageDao;
import com.revature.dao.RevvitDao;
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
