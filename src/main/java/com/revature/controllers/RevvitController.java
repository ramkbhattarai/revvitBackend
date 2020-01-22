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

import com.revature.models.Revvit;
import com.revature.services.RevvitService;

@CrossOrigin
@Controller
public class RevvitController {
	
	@Autowired
	private RevvitService rs;// = new RevvitService(); 
	
	@GetMapping(value = "/revvits")
	@ResponseBody 
	public List<Revvit> findAll() {
		return rs.findAll();
	}
	
	@GetMapping("/revvits/{id}")
	@ResponseBody
	public ResponseEntity<Revvit> findById(@PathVariable("id") int id) {
		List<Revvit> list = rs.findAll();
		if(id >= list.size()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		Revvit r = list.get(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(r);
	}
	
	@PostMapping("/revvit")
	@ResponseBody
	public ResponseEntity<Revvit> save(@RequestBody Revvit r) {
		return ResponseEntity.ok(rs.save(r));
	}
	
	@PatchMapping("/revvit")
	@ResponseBody
	public ResponseEntity<Boolean> update(@RequestBody Revvit r) {
		return ResponseEntity.ok(rs.update(r));
	}

}
