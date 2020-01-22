package com.revature.models;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="revvits")
@Component
public class Revvit implements Serializable{
	
	
	private static final long serialVersionUID = 1571629160754820791L;

	@Id
	@Column(name="revvit_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="text")
	private String text;
	
	@Column(name="imageUrl")
	private byte[] imageUrl;
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id")
	@JsonIgnoreProperties("revvits")
	private User author;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	        name = "revvit_likes", 
	        joinColumns = { @JoinColumn(name = "revvit_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "user_id") }
	    )
	private List<User> likedBy;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	        name = "revvit_reRevvited", 
	        joinColumns = { @JoinColumn(name = "revvit_id", referencedColumnName = "revvit_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "user_id") }
	    )
	private List<User> reRevvitedBy;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	        name = "revvit_hashtags", 
	        joinColumns = { @JoinColumn(name = "revvit_id", referencedColumnName = "revvit_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "hashtag_id", referencedColumnName = "hashtag_id") }
	    )
	private List<HashTag> hashtags;

	
	

	public Revvit() {
		super();
	}




	public Revvit(String text, User author) {
		super();
		this.text = text;
		this.author = author;
	}




	public Revvit(int id, String text, byte[] imageUrl, User author) {
		super();
		this.id = id;
		this.text = text;
		this.imageUrl = imageUrl;
		this.author = author;
	}




	public Revvit(String text, byte[] imageUrl, User author) {
		super();
		this.text = text;
		this.imageUrl = imageUrl;
		this.author = author;
	}




	public Revvit(int id, String text, byte[] imageUrl, User author, List<User> likedBy) {
		super();
		this.id = id;
		this.text = text;
		this.imageUrl = imageUrl;
		this.author = author;
		this.likedBy = likedBy;
	}




	public Revvit(int id, String text, byte[] imageUrl, User author, List<User> likedBy, List<User> reRevvitedBy) {
		super();
		this.id = id;
		this.text = text;
		this.imageUrl = imageUrl;
		this.author = author;
		this.likedBy = likedBy;
		this.reRevvitedBy = reRevvitedBy;
	}




	public Revvit(int id, String text, byte[] imageUrl, User author, List<User> likedBy, List<User> reRevvitedBy,
			List<HashTag> hashtags) {
		super();
		this.id = id;
		this.text = text;
		this.imageUrl = imageUrl;
		this.author = author;
		this.likedBy = likedBy;
		this.reRevvitedBy = reRevvitedBy;
		this.hashtags = hashtags;
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
	 * @return the text
	 */
	public String getText() {
		return text;
	}




	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}




	/**
	 * @return the imageUrl
	 */
	public byte[] getImageUrl() {
		return imageUrl;
	}




	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(byte[] imageUrl) {
		this.imageUrl = imageUrl;
	}




	/**
	 * @return the author
	 */
	public User getAuthor() {
		return author;
	}




	/**
	 * @param author the author to set
	 */
	public void setAuthor(User author) {
		this.author = author;
	}




	/**
	 * @return the likedBy
	 */
	public List<User> getLikedBy() {
		return likedBy;
	}




	/**
	 * @param likedBy the likedBy to set
	 */
	public void setLikedBy(List<User> likedBy) {
		this.likedBy = likedBy;
	}




	/**
	 * @return the reRevvitedBy
	 */
	public List<User> getReRevvitedBy() {
		return reRevvitedBy;
	}




	/**
	 * @param reRevvitedBy the reRevvitedBy to set
	 */
	public void setReRevvitedBy(List<User> reRevvitedBy) {
		this.reRevvitedBy = reRevvitedBy;
	}




	/**
	 * @return the hashtags
	 */
	public List<HashTag> getHashtags() {
		return hashtags;
	}




	/**
	 * @param hashtags the hashtags to set
	 */
	public void setHashtags(List<HashTag> hashtags) {
		this.hashtags = hashtags;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(imageUrl);
		result = prime * result + Objects.hash(author, hashtags, id, likedBy, reRevvitedBy, text);
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Revvit)) {
			return false;
		}
		Revvit other = (Revvit) obj;
		return Objects.equals(author, other.author) && Objects.equals(hashtags, other.hashtags) && id == other.id
				&& Arrays.equals(imageUrl, other.imageUrl) && Objects.equals(likedBy, other.likedBy)
				&& Objects.equals(reRevvitedBy, other.reRevvitedBy) && Objects.equals(text, other.text);
	}




	@Override
	public String toString() {
		return "Revvit [id=" + id + ", text=" + text + ", imageUrl=" + Arrays.toString(imageUrl) + ", author=" + author.getUsername()
				+ ", likedBy=" + likedBy + ", reRevvitedBy=" + reRevvitedBy + ", hashtags=" + hashtags + "]";
	}
	
	

	
}
