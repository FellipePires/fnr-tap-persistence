package com.fnr.interfaces;

import java.util.List;

public interface IController<T> {
	public boolean verifyData(T entity);
	public boolean post(T entity);
	public boolean put(T entity, Integer id);
	public boolean delete(Integer id);
	public T getById(Integer id);
	List<T> getAll(T entity);
}
