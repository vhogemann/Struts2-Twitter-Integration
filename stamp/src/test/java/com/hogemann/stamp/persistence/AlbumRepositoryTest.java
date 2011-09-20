package com.hogemann.stamp.persistence;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hogemann.stamp.model.Album;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-applicationContext.xml","classpath:dataContext.xml"})
public class AlbumRepositoryTest extends AbstractHibernateRepositoryTest<Album> {

	@Autowired
	private AlbumRepository repository;
	
	@Override
	protected EntityRepository<Album> getRepository() {
		return repository;
	}

	@Override
	protected Album getEntity() {
		Album album = new Album();
		
		album.setName("Album");
		album.setDescription("Description");
		
		return album;
	}

	@Override
	protected void modifyEntity(Album entity) {
		entity.setName("Modified");
	}

	@Override
	protected boolean confirmModification(Album entity) {
		return "Modified".equals(entity.getName());
	}

}
