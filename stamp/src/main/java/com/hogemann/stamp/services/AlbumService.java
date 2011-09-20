package com.hogemann.stamp.services;

import com.hogemann.stamp.model.Album;
import com.hogemann.stamp.model.User;
import com.hogemann.stamp.xml.instance.AlbumInstance;

public interface AlbumService {

	public AlbumInstance createInstance(Album album, User user);
	
	public AlbumInstance loadInstance(long id);
	
	public boolean saveInstance(AlbumInstance instance);
	
	public long save(Album album, User user);
	
	public Album load(long id);
	
	public void update(Album album);
	
	public void delete(long id);
	
}
