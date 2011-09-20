package com.hogemann.stamp.web.action.album;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.hogemann.stamp.model.Album;
import com.hogemann.stamp.model.User;
import com.hogemann.stamp.services.AlbumService;
import com.hogemann.stamp.web.interceptor.UserAware;

/**
 * @author victor
 *
 */
public class AlbumAction implements UserAware, SessionAware{

	private static final String ALBUM = "album";

	@Autowired
	private AlbumService service;
	
	private User user;
	
	private Album album;
	
	private Map<String, Object> session;

	private long albumId;
	
	
	public String edit(){
		return "success";
	}
	
	public String save(){
		
		if (album != null && user != null){
			service.save(album, user);
		}
		
		return "success";
	}
	
	public Album getAlbum(){
		
		if(albumId != 0 && album == null){
			album = service.load(albumId);
			if(album != null)
				setAlbum(album);
		}
		
		if(album == null){
			Object obj = session.get(ALBUM);
			if(obj instanceof Album){
				album = (Album) obj;
			}
		}
		
		return album;
	}

	public void setAlbum(Album album){
		this.album = album;
		session.put(ALBUM, album);
	}
	
	public void setAlbumId(long id){
		this.albumId = id;
	}
	
	public long getAlbumId(){
		return albumId;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser(){
		return user;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
