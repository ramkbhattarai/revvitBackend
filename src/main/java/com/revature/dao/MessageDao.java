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

import com.revature.models.Message;
@Repository
public class MessageDao implements IMessage{
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sf;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Message> findAll() {
		Session s = sf.getCurrentSession();
		CriteriaQuery<Message> query = s.getCriteriaBuilder().createQuery(Message.class);
		Root<Message> root = query.from(Message.class);
		query.select(root);
		Query<Message> q = s.createQuery(query);
		
		return q.getResultList();
		
	}

	@Override
	@Transactional
	public Message findById(int id) {
		Session session = sf.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Message> query = builder.createQuery(Message.class);
        Root<Message> root = query.from(Message.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query<Message> q=session.createQuery(query);
        return q.getSingleResult();
        
	}

	@Override
	@Transactional
	public Message save(Message m) {
		Session s = sf.getCurrentSession();
		Integer i = (Integer) s.save(m);
		return findById(i); 
	}

	@Override
	@Transactional
	public boolean update(Message m) {
		Session s = sf.getCurrentSession();
		s.merge(m);
		return true;
	}

}
