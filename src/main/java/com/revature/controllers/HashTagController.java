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

import com.revature.models.HashTag;
import com.revature.services.HashTagService;

@CrossOrigin
@Controller
public class HashTagController {
	
	
    private HashTagService hs = new HashTagService();
	
	@GetMapping(value = "/hashTags")
	@ResponseBody 
	public List<HashTag> findAll() {
		return hs.findAll();
	}
	
	@GetMapping("/hashTags/{id}")
	@ResponseBody
	public ResponseEntity<HashTag> findById(@PathVariable("id") int id) {
		List<HashTag> list = hs.findAll();
		if(id >= list.size()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		HashTag h = list.get(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(h);
	}
	
	@PostMapping("/hashTag")
	@ResponseBody
	public ResponseEntity<HashTag> save(@RequestBody HashTag h) {
		return ResponseEntity.ok(hs.save(h));
	}
	
	@PatchMapping("/hashTag")
	@ResponseBody
	public ResponseEntity<Boolean> update(@RequestBody HashTag h) {
		return ResponseEntity.ok(hs.update(h));
	}

}
