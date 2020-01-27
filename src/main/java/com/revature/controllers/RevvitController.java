package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.mapping.Array;
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

import com.revature.models.Revvit;
import com.revature.models.User;
import com.revature.services.RevvitService;
import org.apache.log4j.Logger;
@CrossOrigin
@Controller
public class RevvitController {
	
<<<<<<< HEAD
=======
	
>>>>>>> b9a6fd1501be77e732d6b67d026830cb33ba79e1
	private static Logger logger = Logger.getLogger(RevvitController.class);
	@Autowired
	private RevvitService revvitService;
	
	@GetMapping(value = "/revvits")
	@ResponseBody 
	public List<Revvit> findAll() {
		return revvitService.findAll();
		
	}
	
	@GetMapping("/revvits/{id}")
	@ResponseBody
	public ResponseEntity<Revvit> findById(@PathVariable("id") int id) {
		List<Revvit> list = revvitService.findAll();
		if(id >= list.size()) {
			logger.info("In Revvit Controller - Revvit returned by id: " + id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		Revvit r = list.get(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(r);
	}
	
	@PostMapping("/revvitsAuthor")
	@ResponseBody
	public ResponseEntity<List<Revvit>> findByAuthor(@RequestBody User u) {
		//System.out.println("inside right controller");
		List<Revvit> list = revvitService.findByAuthor(u);
		if(list.size() < 1) {
<<<<<<< HEAD
			logger.info("In Revvit Controller - author returned " + u);
=======
			logger.info("In Revvit Controller - author: " + u);
>>>>>>> b9a6fd1501be77e732d6b67d026830cb33ba79e1
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@PostMapping("/saveRevvit")
	@ResponseBody
	public ResponseEntity<Revvit> save(@RequestBody Revvit r) {	
<<<<<<< HEAD
		logger.info("In Revvit Controller - Revvit saved: " + r);
=======
		logger.info("In Revvit Controller - Revvit: " + r + " saved");
>>>>>>> b9a6fd1501be77e732d6b67d026830cb33ba79e1
		return ResponseEntity.ok(revvitService.save(r));
	}
	
	@PatchMapping("/revvit")
	@ResponseBody
	public ResponseEntity<Boolean> update(@RequestBody Revvit r) {
		return ResponseEntity.ok(revvitService.update(r));
	}
	
	@PostMapping("/deleteRevvit")
	@ResponseBody
	public ResponseEntity<Boolean> delete(@RequestBody Revvit r) {
<<<<<<< HEAD
		logger.info("In Revvit Controller - Revvit deleted " + r);
=======
		logger.info("In Revvit Controller - Revvit: " + r + "deleted!");
>>>>>>> b9a6fd1501be77e732d6b67d026830cb33ba79e1
		return ResponseEntity.ok(revvitService.delete(r.getId()));
	}
	
	
	@PostMapping("/likeRevvit")
	@ResponseBody
	public ResponseEntity<Integer> like(@RequestBody ArrayList<Object> o) {
		Revvit r =  (Revvit) o.get(0);
		User u = (User) o.get(1);
//		System.out.println(o.get(0));
//		System.out.println(o.get(1));
		logger.info("In Revvit Controller - Revvit liked " + r);
		return ResponseEntity.ok(revvitService.like(r, u));
		//return null;
	}

}
