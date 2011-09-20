package com.hogemann.stamp.persistence;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.hogemann.stamp.model.AbstractEntity;

public abstract class AbstractHibernateRepositoryTest<E extends AbstractEntity> extends AbstractTransactionalJUnit4SpringContextTests {

	protected abstract EntityRepository<E> getRepository();
	
	protected abstract E getEntity();
	
	protected abstract void modifyEntity(E entity);
	protected abstract boolean confirmModification(E entity);
	
	@Test
	public void testSave(){
		E expected = getEntity();
		Long id = getRepository().save(expected);
		E actual = getRepository().get(id);
		Assert.assertEquals(expected, actual);
		
		modifyEntity(expected);
		getRepository().update(expected);
		actual = getRepository().get(id);
		Assert.assertEquals(expected, actual);
		Assert.assertTrue(confirmModification(actual));
	}
	
	@Test
	public void testUpdate(){
		
		E expected = getEntity();
		Long id = getRepository().save(expected);
		E actual = getRepository().get(id);
		Assert.assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGet(){
		E expected = getEntity();
		Long id = getRepository().save(expected);
		
		getRepository().save(getEntity());
		getRepository().save(getEntity());
		
		E actual = getRepository().get(id);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testFind(){
		
		E entity = getEntity();
		getRepository().save(entity);
		
		List<E> result = getRepository().find(entity);
		
		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());
	}
	
	@Test
	public void testDelete(){
		Assert.fail("not implemented");
	}
	
}
