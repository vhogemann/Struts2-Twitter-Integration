package com.hogemann.stamp.persistence.database;

import org.springframework.stereotype.Repository;

import com.hogemann.stamp.model.Album;
import com.hogemann.stamp.persistence.AlbumRepository;

@Repository
public class AlbumHibernateRepository extends AbstractHibernateReposiory<Album> implements AlbumRepository{

	@Override
	public Class<Album> getEntityClass() {
		return Album.class;
	}

}
