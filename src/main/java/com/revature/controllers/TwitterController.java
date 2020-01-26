package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Revvit;
import com.revature.models.User;

import com.revature.twiter.TwitConfig;

import twitter4j.TwitterException;

@CrossOrigin
@Controller
public class TwitterController {

	
	@Autowired
	private TwitConfig tc;
	
	@GetMapping(value = "/tweets")
	@ResponseBody 
	public List<Revvit> findAll() throws TwitterException {
		return tc.getTimeline();
		
	}
	
	
	@PostMapping(value = "/tweet")
	@ResponseBody 
	public boolean postTweet(@RequestBody Revvit r) throws TwitterException {				
		return tc.postTweet(r.getText());
		
	}
	
	@PostMapping(value = "/followUser")
	@ResponseBody 
	public boolean followUser(@RequestBody User u) throws TwitterException {				
		return tc.followUser(u.getUsername());
		
	}
	
	
	
}
