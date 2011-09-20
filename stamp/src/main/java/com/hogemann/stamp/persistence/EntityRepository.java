package com.hogemann.stamp.persistence;

import com.hogemann.stamp.model.AbstractEntity;

public interface EntityRepository<E extends AbstractEntity> extends ObjectRepository<E> {

	public abstract E get(long id);

}
