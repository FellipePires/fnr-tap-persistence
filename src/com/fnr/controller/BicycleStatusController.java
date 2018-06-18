package com.fnr.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.fnr.connection.ConnectionFactory;
import com.fnr.dao.DAO;
import com.fnr.enums.Response;
import com.fnr.interfaces.IController;
import com.fnr.interfaces.IDAO;
import com.fnr.model.BicycleStatus;

public class BicycleStatusController implements IController<BicycleStatus> {
	private IDAO<BicycleStatus> dao;

	public BicycleStatusController() {
		this.dao = new DAO<BicycleStatus>();
	}

	public boolean verifyData(BicycleStatus bikeStatus) {
		if (bikeStatus.getBicycleStatus() != null && bikeStatus.getDescription() != null)
			return true;

		return false;
	}

	@Override
	public Response post(ConnectionFactory conn, BicycleStatus bikeStatus) {
		if (verifyData(bikeStatus) && this.dao.post(conn, bikeStatus))
			return Response.POST_SUCCESS;

		return  Response.POST_FAILED;
	}

	@Override
	public Response put(ConnectionFactory conn, BicycleStatus entity) {

		return null;
	}

	@Override
	public Response delete(ConnectionFactory conn, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BicycleStatus getById(ConnectionFactory conn, Integer id) {
		EntityManager em = conn.getConnection();
		try {
			return em.find(BicycleStatus.class, id);
		} catch (PersistenceException e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}

	}

	@Override
	public List<BicycleStatus> getAll(ConnectionFactory conn, BicycleStatus bikeStatus) {
		return this.dao.getAll(conn, bikeStatus);
	}

}
