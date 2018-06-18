package com.fnr.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fnr.model.User;

public class ConnectionFactory {
	private String userPU;
	private User user;
	private EntityManagerFactory emf;
	
	public ConnectionFactory() {
		this.emf = Persistence.createEntityManagerFactory("root");
	}
	public ConnectionFactory(User user) {
		this.user = user;
		definePuUnit(user);
	}
	
	public void definePuUnit(User user) {
		if(user.getIsAdmin()) {
			this.userPU = "Administrador";
			this.emf = Persistence.createEntityManagerFactory("administratorPU");
		}else {
			this.userPU = "Empregado";
			this.emf = Persistence.createEntityManagerFactory("employeePU");
		}
	}
	
	public EntityManager getConnection() {
		return this.emf.createEntityManager();
	}
	
	public EntityManagerFactory getEMFactory() {
		return this.emf;
	}
	
	public String getUserPu() {
		return userPU;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
