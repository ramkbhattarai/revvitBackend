package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinColumn;



@Entity
@Table(name="users")
@Component
public class User implements Serializable{
	
	private static final long serialVersionUID = 7123964064940313614L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="lname")
	private String lname;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="profilePicture")
	private byte[] profilePicture;
	
	@OneToMany(mappedBy="author", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("author")
	private List<Revvit> revvits = new ArrayList<>();
	
	
	
	@OneToMany(mappedBy="sender", fetch = FetchType.EAGER)
	private List<Message> send_messages = new ArrayList<>();
	
	@OneToMany(mappedBy="receiver", fetch = FetchType.EAGER)
	private List<Message> received_messages = new ArrayList<>();
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	        name = "user_liked_revvit", 
	        joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "user_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "revvit_id", referencedColumnName = "revvit_id") }
	    )
	private List<Revvit> liked;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	        name = "user_reRevvited", 
	        joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "user_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "revvit_id", referencedColumnName = "revvit_id") }
	    )
	private List<Revvit> reRevvited;
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	        name = "user_followers", 
	        joinColumns = { @JoinColumn(name = "guru_id", referencedColumnName = "user_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "followers_id", referencedColumnName = "user_id") }
	    )
	private List<User> followers = new ArrayList<>();
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	        name = "user_following", 
	        joinColumns = { @JoinColumn(name = "followers_id", referencedColumnName = "user_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "guru_id", referencedColumnName = "user_id") }
	    )
	private List<User> following = new ArrayList<>();


	public User() {
		super();
	
	}


	public User(int id, String fname, String lname, String userName, String email, String password,
			byte[] profilePicture, List<Revvit> revvits, List<Message> send_messages, List<Message> received_messages,
			List<Revvit> liked, List<Revvit> reRevvited, List<User> followers, List<User> following) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.username = userName;
		this.email = email;
		this.password = password;
		this.profilePicture = profilePicture;
		this.revvits = revvits;
		this.send_messages = send_messages;
		this.received_messages = received_messages;
		this.liked = liked;
		this.reRevvited = reRevvited;
		this.followers = followers;
		this.following = following;
	}


	public User(String fname, String lname, String userName, String email, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.username = userName;
		this.email = email;
		this.password = password;
	}


	public User(int id, String fname, String lname, String userName, String email, String password,
			byte[] profilePicture) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.username = userName;
		this.email = email;
		this.password = password;
		this.profilePicture = profilePicture;
	}


	public User(int id, String fname, String lname, String userName, String email, String password,
			byte[] profilePicture, List<Revvit> revvits) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.username = userName;
		this.email = email;
		this.password = password;
		this.profilePicture = profilePicture;
		this.revvits = revvits;
	}


	public User(int id, String fname, String lname, String userName, String email, String password,
			byte[] profilePicture, List<Revvit> revvits, List<Message> send_messages) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.username = userName;
		this.email = email;
		this.password = password;
		this.profilePicture = profilePicture;
		this.revvits = revvits;
		this.send_messages = send_messages;
	}


	public User(int id, String fname, String lname, String userName, String email, String password,
			byte[] profilePicture, List<Revvit> revvits, List<Message> send_messages, List<Message> received_messages) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.username = userName;
		this.email = email;
		this.password = password;
		this.profilePicture = profilePicture;
		this.revvits = revvits;
		this.send_messages = send_messages;
		this.received_messages = received_messages;
	}


	public User(int id, String fname, String lname, String userName, String email, String password,
			byte[] profilePicture, List<Revvit> revvits, List<Message> send_messages, List<Message> received_messages,
			List<Revvit> liked) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.username = userName;
		this.email = email;
		this.password = password;
		this.profilePicture = profilePicture;
		this.revvits = revvits;
		this.send_messages = send_messages;
		this.received_messages = received_messages;
		this.liked = liked;
	}


	public User(int id, String fname, String lname, String userName, String email, String password,
			byte[] profilePicture, List<Revvit> revvits, List<Message> send_messages, List<Message> received_messages,
			List<Revvit> liked, List<Revvit> reRevvited) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.username = userName;
		this.email = email;
		this.password = password;
		this.profilePicture = profilePicture;
		this.revvits = revvits;
		this.send_messages = send_messages;
		this.received_messages = received_messages;
		this.liked = liked;
		this.reRevvited = reRevvited;
	}


	public User(int id, String fname, String lname, String userName, String email, String password,
			byte[] profilePicture, List<Revvit> revvits, List<Message> send_messages, List<Message> received_messages,
			List<Revvit> liked, List<Revvit> reRevvited, List<User> followers) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.username = userName;
		this.email = email;
		this.password = password;
		this.profilePicture = profilePicture;
		this.revvits = revvits;
		this.send_messages = send_messages;
		this.received_messages = received_messages;
		this.liked = liked;
		this.reRevvited = reRevvited;
		this.followers = followers;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}


	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}


	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}


	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}


	/**
	 * @return the userName
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * @param userName the userName to set
	 */
	public void setUsername(String userName) {
		this.username = userName;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the profilePicture
	 */
	public byte[] getProfilePicture() {
		return profilePicture;
	}


	/**
	 * @param profilePicture the profilePicture to set
	 */
	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}


	/**
	 * @return the revvits
	 */
	public List<Revvit> getRevvits() {
		return revvits;
	}


	/**
	 * @param revvits the revvits to set
	 */
	public void setRevvits(List<Revvit> revvits) {
		this.revvits = revvits;
	}


	/**
	 * @return the send_messages
	 */
	public List<Message> getSend_messages() {
		return send_messages;
	}


	/**
	 * @param send_messages the send_messages to set
	 */
	public void setSend_messages(List<Message> send_messages) {
		this.send_messages = send_messages;
	}


	/**
	 * @return the received_messages
	 */
	public List<Message> getReceived_messages() {
		return received_messages;
	}


	/**
	 * @param received_messages the received_messages to set
	 */
	public void setReceived_messages(List<Message> received_messages) {
		this.received_messages = received_messages;
	}


	/**
	 * @return the liked
	 */
	public List<Revvit> getLiked() {
		return liked;
	}


	/**
	 * @param liked the liked to set
	 */
	public void setLiked(List<Revvit> liked) {
		this.liked = liked;
	}


	/**
	 * @return the reRevvited
	 */
	public List<Revvit> getReRevvited() {
		return reRevvited;
	}


	/**
	 * @param reRevvited the reRevvited to set
	 */
	public void setReRevvited(List<Revvit> reRevvited) {
		this.reRevvited = reRevvited;
	}


	/**
	 * @return the followers
	 */
	public List<User> getFollowers() {
		return followers;
	}


	/**
	 * @param followers the followers to set
	 */
	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}


	/**
	 * @return the following
	 */
	public List<User> getFollowing() {
		return following;
	}


	/**
	 * @param following the following to set
	 */
	public void setFollowing(List<User> following) {
		this.following = following;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(profilePicture);
		result = prime * result + Objects.hash(email, fname, followers, following, id, liked, lname, password,
				reRevvited, received_messages, revvits, send_messages, username);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(fname, other.fname)
				&& Objects.equals(followers, other.followers) && Objects.equals(following, other.following)
				&& id == other.id && Objects.equals(liked, other.liked) && Objects.equals(lname, other.lname)
				&& Objects.equals(password, other.password) && Arrays.equals(profilePicture, other.profilePicture)
				&& Objects.equals(reRevvited, other.reRevvited)
				&& Objects.equals(received_messages, other.received_messages) && Objects.equals(revvits, other.revvits)
				&& Objects.equals(send_messages, other.send_messages) && Objects.equals(username, other.username);
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", username=" + username + ", email="
				+ email + ", password=" + password + ", profilePicture=" + Arrays.toString(profilePicture)
				+ ", revvits=" + revvits + ", send_messages=" + send_messages + ", received_messages="
				+ received_messages + ", liked=" + liked + ", reRevvited=" + reRevvited + ", followers=" + followers
				+ ", following=" + following + "]";
	}
	
	

}
