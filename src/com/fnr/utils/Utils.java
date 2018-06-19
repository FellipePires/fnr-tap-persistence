package com.fnr.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.fnr.connection.ConnectionFactory;
import com.fnr.model.User;

public class Utils {

	public static User authUser(LoginInfo login) {
		ConnectionFactory conn = new ConnectionFactory();
		EntityManager em = conn.getConnection();

		try {
			Query sql = em.createQuery("from User where email = :email and password = :password")
					.setParameter("email", LoginInfo.email)
					.setParameter("password", LoginInfo.password);

			User user = (User) sql.getSingleResult();

			if (user != null && user.getPassword().equals(LoginInfo.password)
					&& user.getEmail().equals(LoginInfo.email)) {
				conn.getEMFactory().close();
				return user;
			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	public static String encryptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String senhaCripto = null;
		if (!(password.trim().equals("") || password.trim().equals(null))) {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigestSenha[] = algorithm.digest(password.getBytes("UTF-8"));
			StringBuilder hexStringPassword = new StringBuilder();
			for (byte b : messageDigestSenha) {
				hexStringPassword.append(String.format("0%2X", 0xFF & b));
			}
			senhaCripto = hexStringPassword.toString();
		}
		return senhaCripto;
	}
}
