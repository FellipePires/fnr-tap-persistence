package com.fnr.interfaces;

import java.util.List;

import com.fnr.connection.ConnectionFactory;

public interface IDAO<T> {
	public boolean post(ConnectionFactory conn, T entity);
	public List<T> getAll(ConnectionFactory conn, T entity);
}
