package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.model.Author;

@Component
public class AuthorDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;



	// get all products
	public List<Author> getAuthors() {
		List<Author> authors = this.hibernateTemplate.loadAll(Author.class);
		return authors;
	}


}