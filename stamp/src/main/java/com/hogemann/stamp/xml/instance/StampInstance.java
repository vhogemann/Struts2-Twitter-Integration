package com.hogemann.stamp.xml.instance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.hogemann.stamp.model.Stamp;

@XmlType
public class StampInstance {
	
	@XmlElement
	private long id;
	
	@XmlElement
	private boolean open;
	
	public StampInstance() {}
	
	public StampInstance(Stamp stamp){
		this.id = stamp.getId();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

}
