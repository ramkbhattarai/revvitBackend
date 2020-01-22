package com.revature.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@Repository
public class UserDao implements IUserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<User> findAll() {
		Session s = sessionFactory.getCurrentSession();
		CriteriaQuery<User> query = s.getCriteriaBuilder().createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root);
		Query<User> q = s.createQuery(query);
		
		return q.getResultList();
		
	}

	@Override
	@Transactional
	public User findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(builder.equal(root.get("id"), id));
        Query<User> q=session.createQuery(query);
        return q.getSingleResult();
        
	}

	@Override
	@Transactional
	public User save(User u) {
		Session s = sessionFactory.getCurrentSession();
		Integer i = (Integer) s.save(u);
		return findById(i); 
	}

	@Override
	@Transactional
	public boolean update(User u) {
		Session s = sessionFactory.getCurrentSession();
		s.merge(u);
		return true;
	}
	
	@Transactional
	public User login(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(
        		builder.equal(root.get("username"), username),
        		builder.equal(root.get("password"), password)
        		);
        Query<User> q = session.createQuery(query);
        return q.getSingleResult();
	}
	
	@Transactional
	public List<User> getAllFollowers(User u){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from user_followers where guru_id='"
				+u.getId()+"'", User.class).list();
		
	}
	

	@Transactional
	public List<User> getAllGuruUserIsFollowing(User u){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from user_following where followers_id='"
				+u.getId()+"'", User.class).list();
		
	}
	

}
