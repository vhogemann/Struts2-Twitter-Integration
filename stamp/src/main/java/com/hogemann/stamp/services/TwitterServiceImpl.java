package com.hogemann.stamp.services;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

import com.hogemann.stamp.model.TwitterAccount;
import com.hogemann.stamp.persistence.TwitterAccountRepository;
import com.hogemann.stamp.util.TwitterFactory;

@Service
public class TwitterServiceImpl implements TwitterService {

	private static final Log log = LogFactory.getLog(TwitterService.class);
	
	@Autowired
	private TwitterAccountRepository repository;
	
	@Autowired
	private TwitterFactory factory;
	
	@Autowired
	private String twitterCallbackUrl = "http://localhost:8080/stamp/twittercallback";
	
	public TwitterAccount startAuthentication() {
		
		try {
			Twitter twitter = factory.getTwitter();
			RequestToken requestToken = twitter.getOAuthRequestToken(twitterCallbackUrl);
			TwitterAccount account = new TwitterAccount(twitter, requestToken);
			return account;
		} catch (TwitterException e) {
			log.error(e);
		}
		
		return null;
	}

	public List<String> searchNicks(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	public TwitterAccount getFromSession(Map<String, Object> session) {
		Object obj = session.get(TWITTER_USER);
		if(obj != null && obj instanceof TwitterAccount)
			return (TwitterAccount)obj;
		
		return null;
	}

	public long save(TwitterAccount user) {
		long id = repository.save(user);
		return id;
	}

	public TwitterAccount loadUser(long id) {
		TwitterAccount user = repository.get(id);
		if(user != null){
			user.authenticate(factory);
			return user;
		}
		return null;
	}

}
