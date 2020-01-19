package com.revature.dao;

import java.util.List;

import com.revature.models.HashTag;

public interface IHashTag {
	
	public List<HashTag> findAll();
	public HashTag findById(int id);
	public HashTag save(HashTag h);
	public boolean update(HashTag h);

}
