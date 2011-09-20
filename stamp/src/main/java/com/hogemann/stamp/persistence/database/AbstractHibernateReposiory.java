package com.hogemann.stamp.persistence.database;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hogemann.stamp.model.AbstractEntity;
import com.hogemann.stamp.persistence.EntityRepository;

public abstract class AbstractHibernateReposiory<E extends AbstractEntity> extends HibernateDaoSupport implements EntityRepository<E> {

	/* (non-Javadoc)
	 * @see com.hogemann.stamp.persistence.Repository#get(long)
	 */
	public E get(long id) {
		E entity = getHibernateTemplate().get(getEntityClass(), id);
		return entity;
	}

	/* (non-Javadoc)
	 * @see com.hogemann.stamp.persistence.Repository#save(E)
	 */
	public long save(E entity) {
		return (Long) getHibernateTemplate().save(entity);
	}
	
	/* (non-Javadoc)
	 * @see com.hogemann.stamp.persistence.Repository#update(E)
	 */
	public void update(E entity){
		getHibernateTemplate().update(entity);
	}

	/* (non-Javadoc)
	 * @see com.hogemann.stamp.persistence.Repository#delete(E)
	 */
	public void delete(E entity) {
		getHibernateTemplate().delete(entity);
	}
	
	public void delete(long id){
		E entity = getHibernateTemplate().load(getEntityClass(), id);
		getHibernateTemplate().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<E> find(E example) {
		return getHibernateTemplate().findByExample(example);
	}
	
	public abstract Class<E> getEntityClass();

}
