package com.fnr.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("administratorPU"); //String que depende do login: Administrador | Empregado
	
	public static EntityManagerFactory getEMFactory() {
		return emf;
	}
	
	public  EntityManager getConnection() {
		return emf.createEntityManager();
	}
}
