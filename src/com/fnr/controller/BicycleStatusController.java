package com.fnr.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.fnr.connection.ConnectionFactory;
import com.fnr.dao.DAO;
import com.fnr.interfaces.IController;
import com.fnr.interfaces.IDAO;
import com.fnr.model.BicycleStatus;

public class BicycleStatusController implements IController<BicycleStatus>{
	private IDAO<BicycleStatus> dao;
	
	public BicycleStatusController() {
		this.dao = new DAO<BicycleStatus>();
	}
	
	@Override
	public boolean verifyData(BicycleStatus bikeStatus) {
		if (bikeStatus.getBicycleStatus() != null && bikeStatus.getDescription() != null)
			return true;

		return false;
	}
	
	@Override
	public boolean post(BicycleStatus bikeStatus) {
		if(verifyData(bikeStatus) && this.dao.post(bikeStatus))
			return true;
		
		return false;
	}
	
	@Override
	public boolean put(BicycleStatus entity, Integer id) {
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BicycleStatus getById(Integer id) {
		EntityManager em = new ConnectionFactory().getConnection();
		try {
			return em.find(BicycleStatus.class, id);
		}catch(PersistenceException e) {
			e.printStackTrace();
			return null;
		}finally {
			em.close();
		}

	}

	@Override
	public List<BicycleStatus> getAll(BicycleStatus bikeStatus) {
		return this.dao.getAll(bikeStatus);
	}

}
