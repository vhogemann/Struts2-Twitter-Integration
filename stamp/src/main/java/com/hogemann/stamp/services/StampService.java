package com.hogemann.stamp.services;

import java.util.List;

import com.hogemann.stamp.model.Stamp;
import com.hogemann.stamp.model.User;

public interface StampService<U extends User> {

	public List<Stamp> search(String nick, U user);
	
}
