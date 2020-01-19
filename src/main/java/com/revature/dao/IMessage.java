package com.revature.dao;

import java.util.List;

import com.revature.models.Message;

public interface IMessage {
	

	public List<Message> findAll();
	public Message findById(int id);
	public Message save(Message m);
	public boolean update(Message m);

}
