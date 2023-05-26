package com.dao;

import java.util.List;


import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entities.Credentials;

@Repository
public class SignUpDao {

	@Autowired
    private HibernateTemplate hibernateTemplate;
	
	//To save the user into the database during registration phase
	
	@Transactional
	public int saveUser(Credentials user) {
		int id = (Integer)this.hibernateTemplate.save(user);
		System.out.println(id);
		return id;
	}
	
	
	//To check whether the user is already present in the database or not
	@Transactional
	public Boolean getUser(String uname,String pass) {
		Session s = this.hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
	 Query q = s.createQuery("from Credentials where username = :u and password = :p");
	  q.setParameter("u", uname);
	  q.setParameter("p",pass);
	 tx.commit();
	 return q.uniqueResult() != null;
	}
}
