package com.fnr.interfaces;

import java.util.List;

public interface IDAO<T> {
	public boolean post(T entity);
	public List<T> getAll(T entity);
}
