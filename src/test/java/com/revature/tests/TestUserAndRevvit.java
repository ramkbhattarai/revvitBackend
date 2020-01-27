package com.revature.tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.dao.UserDao;
import com.revature.models.HashTag;
import com.revature.models.Revvit;
import com.revature.models.User;
import com.revature.services.UserService;
public class TestUserAndRevvit {
										// Mockito...there was an attempt
	@InjectMocks
	private UserService service;
	@Mock
	private UserDao dao;
//	private RevvitDao rDao;
//	private HashTagDao hDao;
    public void setUp() throws Exception {
         MockitoAnnotations.initMocks(this);
    }
    // PASS
    @Test
    public void getAllFollowersTest(){
 	   List<User> followers = new ArrayList<>();
 	   // 3 followers to test
 	   followers.add(new User("Bob", "Smith", "bsmith", "bs@mail.com", "pass"));
 	   followers.add(new User("Bilbo", "Baggins", "hobbit", "lilguy@lor.com", "shire"));
 	   followers.add(new User("Rick", "Sanchez", "morty", "ricknmorty@as.com", "raygun"));
 	   User u = new User (1, "John", "Doe", "jdoe", "user@email.com", "password", null, null, null, null, null, null, followers);
 	   assertEquals(3, u.getFollowers().size());
 	}
    @Test
    public void hashTagListTest() {
    	HashTag h = new HashTag("baseball");
    	List<HashTag> hl = new ArrayList<>();
    	hl.add(h);
    	User u = new User(2, "Bob", "Smith", "bs", "user@gmail.com", "pass", null, null, null);
    	List<User> likedBy = new ArrayList<>();
    	likedBy.add(u);
    	Revvit r = new Revvit(1, "hello world", null, u, likedBy, null, hl);
    	assertNotNull(r.getHashtags());
    }
    @Test
    public void getUserByIdTest() {
    	User u = new User(1, "John", "Doe", "jdoe", "user@email.com", "password", null, null, null);
    	assertEquals(1, u.getId());
    	assertEquals("John", u.getFname());
        assertEquals("Doe", u.getLname());
        assertEquals("user@email.com", u.getEmail());
    }
    @Test
    public void getRevvitBy_Test() {
    	User u = new User(1, "John", "Doe", "jdoe", "user@email.com", "password", null, null, null);
    	User u2 = new User(2, "Bob", "Smith", "bs", "user@gmail.com", "pass", null, null, null);
    	List<User> likers = new ArrayList<>();
    	likers.add(u);
    	likers.add(u2);
    	Revvit r = new Revvit(1, "hello world", u, likers);
    	assertEquals(1, r.getId());
    	assertEquals(likers, r.getLikedBy());
    	assertEquals(u, r.getAuthor());
    	assertEquals("hello world", r.getText());
    }
    @Test
    public void testLikes() {
    	User u = new User(1, "John", "Doe", "jdoe", "user@email.com", "password", null, null, null);
    	User u2 = new User(2, "Bob", "Smith", "bs", "user@gmail.com", "pass", null, null, null);
    	List<User> likedBy = new ArrayList<>();
    	List<User> noLeGusta = new ArrayList<>();
    	likedBy.add(u2);
    	noLeGusta.add(u);
    	Revvit r = new Revvit(1, "what's up", u2, likedBy);
    	assertFalse(r.getLikedBy() == noLeGusta);
    }
    @Test
    public void testLikedList() {
    	User u = new User(2, "Bob", "Smith", "bs", "user@gmail.com", "pass", null, null, null);
    	Revvit r = new Revvit(1, "hello world", u);
    	Revvit r2 = new Revvit(2, "hello moon", u);
    	List<Revvit> revs = new ArrayList<>();
    	revs.add(r);
    	revs.add(r2);
    	assertNotNull(revs);
    	assertNotNull(r2.getAuthor());
    	assertTrue(r2.getAuthor()==u);
    }
    @Test
    public void revStringTest() {
    	User u = new User(2, "Bob", "Smith", "bs", "user@gmail.com", "pass", null, null, null);
    	Revvit r = new Revvit(1, "hello world", u);
    	Revvit r2 = new Revvit(2, "hello world", u);
    	List<Revvit> revs = new ArrayList<>();
    	revs.add(r);
    	revs.add(r2);
    	assertSame(r.getText(), r2.getText());
    }
    @Test
    public void getHashTagById() {
    	HashTag h = new HashTag(1, "football");
    	assertEquals(1, h.getId());
    }
    @Test
    public void getRevsWithHashTest() {
    	Revvit r = new Revvit(1, "these are my travel plans", null);
    	List<Revvit> revs = new ArrayList<>();
    	revs.add(r);
    	HashTag h = new HashTag(1, "travel", revs);
    	assertEquals(revs, h.getRevvits());
    }
    @Test
    public void saveHashtagTest() {
    	HashTag h = new HashTag("fubar");
    	List<HashTag> hl = new ArrayList<>();
    	hl.add(h);
    	Revvit r = new Revvit(73, "oh, how I love jUnit tests", null, null, null, null, hl);
    	assertNotNull(h);
    	assertEquals(hl, r.getHashtags());
    }

}



