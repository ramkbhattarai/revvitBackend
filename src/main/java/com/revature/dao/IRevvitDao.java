package com.revature.dao;

import java.util.List;

import com.revature.models.Revvit;

public interface IRevvitDao {
	
	public List<Revvit> findAll();
	public Revvit findById(int id);
	public Revvit save(Revvit r);
	public boolean update(Revvit r);

}
