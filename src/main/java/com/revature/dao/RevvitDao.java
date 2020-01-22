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

import com.revature.models.Revvit;

@Repository
public class RevvitDao implements IRevvitDao{
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sf;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Revvit> findAll() {
		Session s = sf.getCurrentSession();
		CriteriaQuery<Revvit> query = s.getCriteriaBuilder().createQuery(Revvit.class);
		Root<Revvit> root = query.from(Revvit.class);
		query.select(root);
		Query<Revvit> q = s.createQuery(query);
		
		return q.getResultList();
		
	}

	@Override
	@Transactional
	public Revvit findById(int id) {
		Session session = sf.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Revvit> query = builder.createQuery(Revvit.class);
        Root<Revvit> root = query.from(Revvit.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query<Revvit> q=session.createQuery(query);
        return q.getSingleResult();
        
	}

	@Override
	@Transactional
	public Revvit save(Revvit r) {
		Session s = sf.getCurrentSession();
		Integer i = (Integer) s.save(r);
		 return findById(i);
	}

	@Override
	@Transactional
	public boolean update(Revvit r) {
		Session s = sf.getCurrentSession();
		s.merge(r);
		return true;
	}

}
