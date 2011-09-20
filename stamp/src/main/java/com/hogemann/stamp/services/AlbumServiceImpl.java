package com.hogemann.stamp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hogemann.stamp.model.Album;
import com.hogemann.stamp.model.User;
import com.hogemann.stamp.persistence.AlbumRepository;
import com.hogemann.stamp.xml.instance.AlbumInstance;

@Service
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumRepository albumRepository;

	public AlbumInstance createInstance(Album album, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public AlbumInstance loadInstance(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean saveInstance(AlbumInstance instance) {
		// TODO Auto-generated method stub
		return false;
	}
	

	public long save(Album album, User user) {
		album.setUser(user);
		long id = albumRepository.save(album);
		return id;
	}

	public Album load(long id) {
		Album album = albumRepository.get(id);
		return album;
	}

	public void update(Album album) {
		albumRepository.update(album);
	}

	public void delete(long id) {
		albumRepository.delete(id);
	}

}
