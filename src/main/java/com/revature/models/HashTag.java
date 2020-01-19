package com.revature.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="hashTags")
@Component
public class HashTag implements Serializable{
	
	private static final long serialVersionUID = 4952373884905455106L;

	@Id
	@Column(name="hashtag_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="text")
	private String text;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	        name ="hashtags_revvit", 
	        joinColumns = { @JoinColumn(name ="hashtag_id", referencedColumnName ="hashtag_id") }, 
	        inverseJoinColumns = { @JoinColumn(name ="revvit_id", referencedColumnName ="revvit_id") }
	    )
	private List<Revvit> revvits;

	public HashTag() {
		super();
	}

	public HashTag(String text) {
		super();
		this.text = text;
	}

	public HashTag(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	
	

	public HashTag(int id, String text, List<Revvit> revvits) {
		super();
		this.id = id;
		this.text = text;
		this.revvits = revvits;
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

	@Override
	public int hashCode() {
		return Objects.hash(id, revvits, text);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof HashTag)) {
			return false;
		}
		HashTag other = (HashTag) obj;
		return id == other.id && Objects.equals(revvits, other.revvits) && Objects.equals(text, other.text);
	}

	@Override
	public String toString() {
		return "HashTag [id=" + id + ", text=" + text + ", revvits=" + revvits + "]";
	}

	

}
