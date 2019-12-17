package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.demo.model.User;

public class UserService {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	EntityTransaction tx;

	public UserService() {
		try {
			emf = Persistence.createEntityManagerFactory("user-persistence-unit");
			em = emf.createEntityManager();
			tx = em.getTransaction();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public User createUser(User user) {
		tx.begin();
		em.persist(user);
		tx.commit();
		
		return user;
	}

	public void removeUser(User user) {
		tx.begin();
		em.remove(em.merge(user));
		tx.commit();
	}

	public User findUser(int id) {
		return em.find(User.class, id);
	}
	
	public List findAll() {
		
		Query query = em.createQuery("select u from User u");
		List<User> list = query.getResultList();
		
		return list;
	}
	
}
