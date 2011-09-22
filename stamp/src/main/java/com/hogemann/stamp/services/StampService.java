package com.hogemann.stamp.services;

import java.util.List;

import com.hogemann.stamp.model.Account;
import com.hogemann.stamp.model.Stamp;

public interface StampService<A extends Account> {

	public List<Stamp> search(String nick, A account);
	
}
