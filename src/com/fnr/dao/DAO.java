package com.fnr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.fnr.connection.ConnectionFactory;
import com.fnr.interfaces.IDAO;
import com.fnr.model.Bicycle;

public class DAO<T> implements IDAO<T> {

	@Override
	public boolean post(ConnectionFactory conn, T entity) {
		EntityManager em = conn.getConnection();
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(ConnectionFactory conn, T entity) {
		EntityManager em = conn.getConnection();
		try {
			return em.createQuery("from " + entity.getClass().getSimpleName()).getResultList();
		} catch (PersistenceException e) {
			System.out.println("Desfazendo transaÃ§Ãµes... \nMotivo: " + e.getMessage());
			return null;
		} finally {
			em.close();
		}
	}

	public boolean put(ConnectionFactory conn, T entity) {
		EntityManager em = conn.getConnection();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return true;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println("Desfazendo transações... \nMotivo: " + e.getMessage());
			return false;
		} finally {
			em.close();
		}	
	}

	@Override
	public boolean delete(ConnectionFactory conn, Integer id) {
		EntityManager em = conn.getConnection();
		try {
			em.getTransaction().begin();
			Bicycle bike = em.find(Bicycle.class, id);
			em.remove(bike);
			em.getTransaction().commit();
			return true;
		} catch (PersistenceException e) {
			em.getTransaction().rollback();
			System.out.println("Desfazendo transações... \nMotivo: " + e.getMessage());
			return false;
		} finally {
			em.close();
		}
	}
}