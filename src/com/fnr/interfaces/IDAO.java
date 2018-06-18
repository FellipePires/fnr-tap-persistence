package com.fnr.interfaces;

import java.util.List;

import com.fnr.connection.ConnectionFactory;

public interface IDAO<T> {
	public boolean post(ConnectionFactory conn, T entity);
	public boolean put(ConnectionFactory conn, T entity);
	public boolean delete(ConnectionFactory conn, T entity, Integer id);
	public List<T> getAll(ConnectionFactory conn, T entity);
}
