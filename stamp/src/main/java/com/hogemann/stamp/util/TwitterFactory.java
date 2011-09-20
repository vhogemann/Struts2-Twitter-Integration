package com.hogemann.stamp.util;

import twitter4j.Twitter;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterFactory {

	private String consumerKey;
	private String consumerSecret;
	
	private twitter4j.TwitterFactory instance;
	
	public twitter4j.TwitterFactory getFactory(){
		if(instance == null){
			ConfigurationBuilder config = new ConfigurationBuilder();
			config.setOAuthConsumerKey(consumerKey).
					setOAuthConsumerSecret(consumerSecret);
			instance = new twitter4j.TwitterFactory(config.build());
		}
		return instance;
	}
	
	public Twitter getTwitter() {
		Twitter twitter = getFactory().getInstance();
		return twitter;
	}
	
	public Twitter getTwitter(String token, String secret){
		AccessToken accessToken = new AccessToken(token, secret);
		Twitter twitter = getFactory().getInstance(accessToken);
		return twitter;
	}
	
	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

}
