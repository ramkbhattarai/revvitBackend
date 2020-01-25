package com.revature.twiter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revature.models.Revvit;
import com.revature.models.User;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Service
public class TwitConfig {
	
	public  Twitter getTwitterInstance() {
	    ConfigurationBuilder cb = new ConfigurationBuilder();   
	    cb.setDebugEnabled(true)
	    .setOAuthConsumerKey("57pJGQ4qGSPMnwlvmlqrPuU6K")
	    .setOAuthConsumerSecret("4ytI7e70OKc02KtIioag2eHEvetEZFgX0K6iqvnsjrrgjcT16D")
	    .setOAuthAccessToken("1217245211094634496-9RTtsR17U0PxgwvjiTwilLZsCAMYh1")
	    .setOAuthAccessTokenSecret("3FnwcJmN8KggoLFL5u8Rr8ciJjWOyTRIrItZzC5rl05EB");
	    TwitterFactory tf = new TwitterFactory(cb.build());
	    Twitter twitter = tf.getInstance();
	    return twitter;
	}
	
	
	public  boolean followUser(String username) throws TwitterException {
		System.out.println(username);
		 Twitter twitter= getTwitterInstance();
		 System.out.println(twitter);
         twitter.createFriendship(username); 
         System.out.println("after create friendship");
         return true;
		
	}
	
	public boolean postTweet(String tweet) throws TwitterException {
		Twitter twitter = getTwitterInstance();
	    Status status = twitter.updateStatus(tweet);
	    System.out.println("Successfully updated the status to " + status.getText() + ".");
	    return true;
	}
	
	
	
	public User turnUsertoUser(twitter4j.User user){
		
		String username = user.getName();
		String userphoto = user.getMiniProfileImageURL();
		
		User user1 = new User(username, userphoto);
	
		return user1;		
	}
	
	
	
	public Revvit turnStatusToRev(Status status) {
	
		String text = status.getText();
		
		twitter4j.User user = status.getUser();
		
		User user1 = turnUsertoUser(user);
		
	    int likecount = status.getFavoriteCount();
	    
	    int retweetcount = status.getRetweetCount();
	    
		Revvit rev = new Revvit(0, text, user1, null, null, null, likecount,retweetcount);
		
		return rev;				
	}
	
	
	public List<Revvit> getTimeline() throws TwitterException {
		List<Revvit> revlist = new ArrayList<Revvit>();
	    Twitter twitter = getTwitterInstance();
	    List<Status> statuses = twitter.getHomeTimeline();	   
	    // System.out.println("Showing home timeline.");	   
	    for (Status status : statuses) {
	       // System.out.println(status.getUser().getName() + ":" +
	                         //  status.getText());   	 	     
	      Revvit rev = turnStatusToRev(status);
	      revlist.add(rev);
	      
	    }
		return revlist;
		
	}
	
	
}
