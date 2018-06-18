package com.fnr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.fnr.connection.ConnectionFactory;
import com.fnr.interfaces.IDAO;
import com.fnr.model.User;

public class DAO<T> implements IDAO<T> {

//	@Override
//	public User authUser(User user) {
//		EntityManager em = new ConnectionFactory().getConnection();
//		try {
//			return em.find(User.class, user.getId());
//		}catch(PersistenceException e) {
//			e.printStackTrace();
//			return null;
//		}finally {
//			em.close();
//		}
//	}
	
	@Override
	public boolean post(ConnectionFactory conn, T entity) {
		EntityManager em = conn.getConnection(); 
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		}catch(PersistenceException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(ConnectionFactory conn, T entity) {
		EntityManager em = conn.getConnection();
		try {
			return em.createQuery("from "+ entity.getClass().getSimpleName()).getResultList();
		}catch(PersistenceException e) {
			System.out.println("Desfazendo transações... \nMotivo: " + e.getMessage());
			return null;
		}finally {
			em.close();
		}
	}

}
