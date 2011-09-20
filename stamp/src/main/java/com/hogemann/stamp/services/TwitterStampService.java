package com.hogemann.stamp.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

import com.hogemann.stamp.model.Stamp;
import com.hogemann.stamp.model.TwitterUser;

public class TwitterStampService implements StampService<TwitterUser> {

	public List<Stamp> search(String nick, TwitterUser user) {
		Twitter twitter = user.getTwitter();
		
		try {
			
			List<User> users = twitter.searchUsers(nick, 0);
			
			if(users != null && !users.isEmpty()){
				List<Stamp> stamps = new ArrayList<Stamp>(users.size());
				for(User twitteruser : users){
					
				}
				
			}
			
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();
	}

}
