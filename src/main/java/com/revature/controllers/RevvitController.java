package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Revvit;
import com.revature.models.User;
import com.revature.services.RevvitService;

@CrossOrigin
@Controller
public class RevvitController {
	
	@Autowired
	private RevvitService revvitService;// = new RevvitService(); 
	
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
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@PostMapping("/saveRevvit")
	@ResponseBody
	public ResponseEntity<Revvit> save(@RequestBody Revvit r) {	
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
		return ResponseEntity.ok(revvitService.delete(r.getId()));
	}

}
