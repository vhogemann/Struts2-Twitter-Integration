package com.hogemann.stamp.services;

import java.util.List;
import java.util.Map;

import com.googlecode.ehcache.annotations.Cacheable;
import com.hogemann.stamp.model.Stamp;
import com.hogemann.stamp.model.TwitterUser;

public interface TwitterService {
	
	public static final String TWITTER_COOKIE = "_stamp_twitter_cookie_";
	public static final String TWITTER_USER = "user";
	
	/**
	 * Creates a {@link TwitterUser} configured with an authentication request
	 * to be made.
	 * 
	 * @return
	 */
	public TwitterUser startAuthentication();
	
	public TwitterUser loadUser(long id);
	
	public long save(TwitterUser user);
	
	public TwitterUser getFromSession(Map<String,Object> session);
	
	public Stamp getStampForUserId(long userId, TwitterUser user);
	
	@Cacheable(cacheName="twitterNickSearch")
	public List<String> searchNicks(String search);

}
