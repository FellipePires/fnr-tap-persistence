package com.fnr.interfaces;

import java.util.List;

import com.fnr.connection.ConnectionFactory;
import com.fnr.utils.Response;

public interface IController<T> {
	public boolean verifyData(T entity);
	
	public Response post(ConnectionFactory conn, T entity);
	public boolean put(ConnectionFactory conn, T entity, Integer id);
	public boolean delete(ConnectionFactory conn, Integer id);
	public T getById(ConnectionFactory conn, Integer id);
	List<T> getAll(ConnectionFactory conn, T entity);
}
