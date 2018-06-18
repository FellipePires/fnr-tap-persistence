package com.fnr.interfaces;

import java.util.List;

import com.fnr.connection.ConnectionFactory;
import com.fnr.enums.Response;

public interface IController<T> {
	public Response post(ConnectionFactory conn, T entity);
	public Response put(ConnectionFactory conn, T entity);
	public Response delete(ConnectionFactory conn, T entity, Integer id);
	List<T> getAll(ConnectionFactory conn, T entity);
	public T getById(ConnectionFactory conn, Integer id);
}
