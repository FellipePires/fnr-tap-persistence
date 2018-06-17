package com.fnr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.fnr.connection.ConnectionFactory;
import com.fnr.interfaces.IDAO;

public class DAO<T> implements IDAO<T> {

	@Override
	public boolean post(T object) {
		EntityManager em = new ConnectionFactory().getConnection();
		try {
			em.getTransaction().begin();
			em.persist(object);
			em.getTransaction().commit();
		}catch(PersistenceException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
		return false;
	}

	@Override
	public boolean put(Object object, Integer id) { // update method
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer id) { 
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T getById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
