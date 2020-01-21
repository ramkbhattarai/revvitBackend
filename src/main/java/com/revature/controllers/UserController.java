package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.User;
import com.revature.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService us;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody 
	public List<User> findAll() {
		return us.findAll();
		 
	}
	
	@GetMapping("/users/{id}")
	@ResponseBody
	public ResponseEntity<User> findById(@PathVariable("id") int id) {
		List<User> list = us.findAll();
		if(id >= list.size()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		User u = list.get(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}
	
	@PostMapping("/register")
	@ResponseBody
	public ResponseEntity<User> signup(@RequestBody User u) {
		return ResponseEntity.ok(us.save(u));
	}
	
	@PatchMapping("/user")
	@ResponseBody
	public ResponseEntity<Boolean> update(@RequestBody User u) {
		return ResponseEntity.ok(us.update(u));
	}
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<User> login(@RequestBody User u) {
		return ResponseEntity.ok(us.login(u));
	}
	
	@PostMapping("/logout")
	@ResponseBody
	public ResponseEntity<Boolean> logout(HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return ResponseEntity.ok(new Boolean("true"));
	}
	
	@GetMapping("/usersFollowers")
	@ResponseBody
	public List<User> getAllFollowers(User u){
		return us.getAllFollowers(u);
	}
	
	@GetMapping("/usersFollowing")
	@ResponseBody
	public List<User> getAllGuruUserIsFollowing(User u){
		return us.getAllGuruUserIsFollowing(u);
	}
}
