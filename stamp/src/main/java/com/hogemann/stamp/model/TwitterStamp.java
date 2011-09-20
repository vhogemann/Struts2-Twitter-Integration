package com.hogemann.stamp.model;

import javax.persistence.Entity;

import twitter4j.User;

@Entity
public class TwitterStamp extends Stamp {

	public TwitterStamp(User user) {
		
		this.setDescription(user.getDescription());
		
	}
	
	
}
