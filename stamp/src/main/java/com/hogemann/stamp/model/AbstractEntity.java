package com.hogemann.stamp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;

public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="uuid")
	private String objectId = UUID.randomUUID().toString();
	
	public String getObjectId(){
		return objectId;
	}
	
	public void setObjectId(String objectId){
		this.objectId = objectId;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof AbstractEntity){
			AbstractEntity entity = (AbstractEntity)obj;
			String uuid = entity.getObjectId();
			return this.getObjectId().equals(uuid);
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return getObjectId().hashCode();
	}

}