package com.revature.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.HashTag;
@Repository
public class HashTagDao implements IHashTag{
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sf;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<HashTag> findAll() {
		Session s = sf.getCurrentSession();
		CriteriaQuery<HashTag> query = s.getCriteriaBuilder().createQuery(HashTag.class);
		Root<HashTag> root = query.from(HashTag.class);
		query.select(root);
		Query<HashTag> q = s.createQuery(query);
		
		return q.getResultList();
		
	}

	@Override
	@Transactional
	public HashTag findById(int id) {
		Session session = sf.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HashTag> query = builder.createQuery(HashTag.class);
        Root<HashTag> root = query.from(HashTag.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query<HashTag> q=session.createQuery(query);
        return q.getSingleResult();
        
	}

	@Override
	@Transactional
	public HashTag save(HashTag h) {
		Session s = sf.getCurrentSession();
		Integer i =  (Integer) s.save(h);
		 return findById(i);
	}

	@Override
	@Transactional
	public boolean update(HashTag h) {
		Session s = sf.getCurrentSession();
		s.merge(h);
		return true;
	}

}
