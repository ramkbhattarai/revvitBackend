package com.revature.controllers;

import org.apache.log4j.Logger;
import java.util.List;

import org.apache.log4j.Logger;
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

	private static Logger logger = Logger.getLogger(TwitterController.class);
<<<<<<< HEAD
=======
	
>>>>>>> b9a6fd1501be77e732d6b67d026830cb33ba79e1
	@Autowired
	private TwitConfig tc;
	
	@GetMapping(value = "/tweets")
	@ResponseBody 
	public List<Revvit> findAll() throws TwitterException {
		logger.info("In Twitter Controller - Tweets returned as timeline");
		return tc.getTimeline();
		
	}
	
	
	@PostMapping(value = "/tweet")
	@ResponseBody 
<<<<<<< HEAD
	public boolean postTweet(@RequestBody Revvit r) throws TwitterException {	
		logger.info("In Twitter Controller - Tweets posted");
=======
	public boolean postTweet(@RequestBody Revvit r) throws TwitterException {
		logger.info("In Twitter Controller - tweet posted");
>>>>>>> b9a6fd1501be77e732d6b67d026830cb33ba79e1
		return tc.postTweet(r.getText());
		
	}
	
	@PostMapping(value = "/followUser")
	@ResponseBody 
<<<<<<< HEAD
	public boolean followUser(@RequestBody User u) throws TwitterException {	
		logger.info("In Twitter Controller - Tweets is followed by" + u);
=======
	public boolean followUser(@RequestBody User u) throws TwitterException {
		logger.info("In Twitter Controller - User: " + u + " followed");
>>>>>>> b9a6fd1501be77e732d6b67d026830cb33ba79e1
		return tc.followUser(u.getUsername());
		
	}
	
	
	
}
