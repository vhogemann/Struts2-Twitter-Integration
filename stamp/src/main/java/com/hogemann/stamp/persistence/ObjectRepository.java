package com.hogemann.stamp.persistence;

import java.util.List;

public interface ObjectRepository<E> {

	public long save(E entity);

	public void update(E entity);

	public void delete(E entity);
	
	public void delete(long id);
	
	public List<E> find(E entity);

}