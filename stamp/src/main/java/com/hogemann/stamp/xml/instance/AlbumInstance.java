package com.hogemann.stamp.xml.instance;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import com.hogemann.stamp.model.Album;
import com.hogemann.stamp.model.Stamp;
import com.hogemann.stamp.model.User;

@XmlRootElement
public class AlbumInstance {
	
	@XmlElement
	private long userId;
	
	@XmlElement
	private long id;
	
	@XmlElements({
		@XmlElement(type=StampInstance.class)
	})
	private List<StampInstance> stamps;
	
	public AlbumInstance(){}
	
	public AlbumInstance(User user, Album album){
		this.id = album.getId();
		this.userId = user.getId();
		
		stamps = new ArrayList<StampInstance>();
		for(Stamp stamp : album.getStamps()){
			stamps.add(new StampInstance( stamp ));
		}
		
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<StampInstance> getStamps() {
		return stamps;
	}

	public void setStamps(List<StampInstance> stamps) {
		this.stamps = stamps;
	}

}
