package com.revature.twiter;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

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
	
	private static Logger logger = Logger.getLogger(TwitConfig.class);
	public  Twitter getTwitterInstance() {
	    ConfigurationBuilder cb = new ConfigurationBuilder();   
	    cb.setDebugEnabled(true)
	    .setOAuthConsumerKey("57pJGQ4qGSPMnwlvmlqrPuU6K")
	    .setOAuthConsumerSecret("4ytI7e70OKc02KtIioag2eHEvetEZFgX0K6iqvnsjrrgjcT16D")
	    .setOAuthAccessToken("1217245211094634496-9RTtsR17U0PxgwvjiTwilLZsCAMYh1")
	    .setOAuthAccessTokenSecret("3FnwcJmN8KggoLFL5u8Rr8ciJjWOyTRIrItZzC5rl05EB");
	    TwitterFactory tf = new TwitterFactory(cb.build());
	    logger.info("In TweetConfig - new TwitterFactory built");
	    return tf.getInstance();
	    
	}
	
	
	public  boolean followUser(String username) throws TwitterException {

		 Twitter twitter= getTwitterInstance();

         twitter.createFriendship(username); 
         logger.info(username + " followed");
         return true;
		
	}
	
	public boolean postTweet(String tweet) throws TwitterException {
		Twitter twitter = getTwitterInstance();
	     twitter.updateStatus(tweet);
	     logger.info(tweet + " posted to Twitter.com");
	    return true;
	}
	
	
	
	public User turnUsertoUser(twitter4j.User user){
		
		String username = user.getName();
		String userphoto = user.getMiniProfileImageURL();
		logger.info(user + " turned to user");
		return  new User(username, userphoto);		
	}
	
	
	
	public Revvit turnStatusToRev(Status status) {
	
		String text = status.getText();
		
		twitter4j.User user = status.getUser();
		
		User user1 = turnUsertoUser(user);
		
	    int likecount = status.getFavoriteCount();
	    
	    int retweetcount = status.getRetweetCount();
	    logger.info(status + " status turned to Rev");
		return  new Revvit(0, text, user1, null, null, null, likecount,retweetcount);
			
	}
	
	
	public List<Revvit> getTimeline() throws TwitterException {
		List<Revvit> revlist = new ArrayList<>();
	    Twitter twitter = getTwitterInstance();
	    List<Status> statuses = twitter.getHomeTimeline();	   

	    for (Status status : statuses) {  	 	     
	      Revvit rev = turnStatusToRev(status);
	      revlist.add(rev);
	      
	    }
	    logger.info("timeline retrieved");
		return revlist;
		
	}
	
	
}
