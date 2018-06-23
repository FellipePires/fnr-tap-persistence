package com.fnr.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.fnr.connection.ConnectionFactory;
import com.fnr.model.User;
import java.sql.PreparedStatement;

public class Utils {

	public static User authUser(LoginInfo login) {
		ConnectionFactory conn = new ConnectionFactory();
		EntityManager em = conn.getConnection();

		try {
			Query sql = em.createQuery("from User where email = :email and password = :password")
					.setParameter("email", LoginInfo.email).setParameter("password", LoginInfo.password);

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

	public static String encryptPassword(String password)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
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

	public static void setParameters(final PreparedStatement statement, final Object... parameters) throws SQLException {
		for (int i = 0, length = parameters.length; i < length; i++) {
			final Object parameter = parameters[i];
			final int parameterIndex = i + 1;
			if (null == parameter) {
				statement.setObject(parameterIndex, null);
			} else if (parameter instanceof Boolean) {
				statement.setBoolean(parameterIndex, (Boolean) parameter);
			} else if (parameter instanceof Character) {
				statement.setString(parameterIndex, String.valueOf(parameter));
			} else if (parameter instanceof Byte) {
				statement.setByte(parameterIndex, (Byte) parameter);
			} else if (parameter instanceof Short) {
				statement.setShort(parameterIndex, (Short) parameter);
			} else if (parameter instanceof Integer) {
				statement.setInt(parameterIndex, (Integer) parameter);
			} else if (parameter instanceof Long) {
				statement.setLong(parameterIndex, (Long) parameter);
			} else if (parameter instanceof Float) {
				statement.setFloat(parameterIndex, (Float) parameter);
			} else if (parameter instanceof Double) {
				statement.setDouble(parameterIndex, (Double) parameter);
			} else if (parameter instanceof String) {
				statement.setString(parameterIndex, (String) parameter);
			} else {
				throw new IllegalArgumentException(
						String.format("Unknown type of the parameter is found. [param: %s, paramIndex: %s]", parameter,
								parameterIndex));
			}
		}
	}
}
