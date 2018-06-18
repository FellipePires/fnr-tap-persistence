package com.fnr.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.fnr.connection.ConnectionFactory;
import com.fnr.dao.DAO;
import com.fnr.interfaces.IController;
import com.fnr.interfaces.IDAO;
import com.fnr.model.Bicycle;
import com.fnr.utils.Response;

public class BicycleController implements IController<Bicycle>{
	private IDAO<Bicycle> dao;

	public BicycleController() {
		this.dao = new DAO<Bicycle>();
	}

	public boolean verifyData(Bicycle bike) {
		if (bike.getBicycleStatus() != null && bike.getBrand() != null && bike.getColor() != null && bike.getModel() != null)
			return true;

		return false;
	}

	@Override
	public Response post(ConnectionFactory conn, Bicycle bike) {
		if (verifyData(bike) && this.dao.post(conn, bike))
			return new Response(true, "Cadastro realizado com sucesso");

		return new Response(false, "Cadastro não realizado");
	}

	@Override
	public boolean put(ConnectionFactory conn, Bicycle bike, Integer id) {
		if (verifyData(bike)) {
			EntityManager em = conn.getConnection();
			try {
				em.getTransaction().begin();

				bike.setDateTimeUpdate(LocalDateTime.now());
				bike.setDateTimeUpdateUserId(conn.getUser().getUserId());

				em.merge(bike);
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

		return false;
	}

	@Override
	public boolean delete(ConnectionFactory conn, Integer id) {
		if (id != null) {
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

		return false;
	}

	@Override
	public Bicycle getById(ConnectionFactory conn, Integer id) {
		if (id != null) {
			EntityManager em = conn.getConnection();
			try {
				return em.find(Bicycle.class, id);
			} catch (PersistenceException e) {
				System.out.println("Desfazendo transações... \nMotivo: " + e.getMessage());
				return null;
			} finally {
				em.close();
			}
		}

		return null;
	}

	@Override
	public List<Bicycle> getAll(ConnectionFactory conn, Bicycle bike) {
		return this.dao.getAll(conn, bike);
	}

}
