package com.fnr.interfaces;

import java.util.List;

public interface IDAO<T> {
	public boolean post(T object);
	public boolean put(Object object, Integer id);
	public boolean delete(Integer id);
	public T getById();
	public List<T> getAll();
}
