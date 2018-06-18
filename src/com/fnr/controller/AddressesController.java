package com.fnr.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.fnr.connection.ConnectionFactory;
import com.fnr.dao.DAO;
import com.fnr.enums.Response;
import com.fnr.interfaces.IController;
import com.fnr.interfaces.IDAO;
import com.fnr.model.Addresses;

public class AddressesController implements IController<Addresses> {
	private IDAO<Addresses> dao;

	public AddressesController() {
		this.dao = new DAO<Addresses>();
	}

	private boolean verifyData(Addresses addr) {
		if (addr.getCustomer() != null && addr.getStreet() != null && addr.getNumber() != null
				&& addr.getComplement() != null && addr.getCity() != null && addr.getState() != null && addr.getZipcode() != null)
			return true;
		return false;
	}

	@Override
	public Response post(ConnectionFactory conn, Addresses addr) {
		if (verifyData(addr) && this.dao.post(conn, addr))
			return Response.POST_SUCCESS;
		return Response.POST_FAILED;
	}

	@Override
	public Response put(ConnectionFactory conn, Addresses addr) {
		if (verifyData(addr) && this.dao.put(conn, addr))
			return Response.UPDATE_SUCCESS;
		return Response.UPDATE_FAILED;
	}

	@Override
	public Response delete(ConnectionFactory conn, Integer id) {
		if (id != null && this.dao.delete(conn, id))
			return Response.DELETE_SUCCESS;
		return Response.DELETE_FAILED;
	}

	@Override
	public Addresses getById(ConnectionFactory conn, Integer id) {
		if (id != null) {
			EntityManager em = conn.getConnection();
			try {
				return em.find(Addresses.class, id);
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
	public List<Addresses> getAll(ConnectionFactory conn, Addresses addrInstance) {
		return this.dao.getAll(conn, addrInstance);
	}
}