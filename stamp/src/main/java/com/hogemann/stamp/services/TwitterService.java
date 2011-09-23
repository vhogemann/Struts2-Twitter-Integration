package com.hogemann.stamp.services;

import java.util.List;
import java.util.Map;

import com.googlecode.ehcache.annotations.Cacheable;
import com.hogemann.stamp.model.TwitterAccount;

public interface TwitterService {
	
	public static final String TWITTER_COOKIE = "_stamp_twitter_cookie_";
	public static final String TWITTER_USER = "user";
	
	/**
	 * Creates a {@link TwitterAccount} configured with an authentication request
	 * to be made.
	 * 
	 * @return
	 */
	public TwitterAccount startAuthentication();
	
	public TwitterAccount loadUser(long id);
	
	public long save(TwitterAccount user);
	
	public TwitterAccount getFromSession(Map<String,Object> session);
	
	@Cacheable(cacheName="twitterNickSearch")
	public List<String> searchNicks(String search);

}
