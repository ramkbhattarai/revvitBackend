package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Message;
import com.revature.services.MessageService;

@CrossOrigin
@Controller
public class MessageController {
	
	
	private MessageService ms = new MessageService();
	
	@GetMapping(value = "/messages")
	@ResponseBody 
	public List<Message> findAll() {
		return ms.findAll();
	}
	
	@GetMapping("/messages/{id}")
	@ResponseBody
	public ResponseEntity<Message> findById(@PathVariable("id") int id) {
		List<Message> list = ms.findAll();
		if(id >= list.size()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		Message m = list.get(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(m);
	}
	
	@PostMapping("/message")
	@ResponseBody
	public ResponseEntity<Message> save(@RequestBody Message m) {
		return ResponseEntity.ok(ms.save(m));
	}
	
	@PatchMapping("/message")
	@ResponseBody
	public ResponseEntity<Boolean> update(@RequestBody Message m) {
		return ResponseEntity.ok(ms.update(m));
	}

}
