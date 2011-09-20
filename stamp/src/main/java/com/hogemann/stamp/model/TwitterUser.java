package com.hogemann.stamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.apache.commons.lang.xwork.StringUtils;

import com.hogemann.stamp.util.TwitterFactory;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

@Entity
public class TwitterUser extends User {

	private static final long serialVersionUID = 1L;
	
	@Column
	private Long twitterId;

	@Column
	private String token;
	
	@Column 
	private String secret;
	
	@Transient
	private Twitter twitter;
	
	@Transient
	private AccessToken accessToken;

	@Transient
	private RequestToken requestToken;
	
	public TwitterUser() {}
	
	public TwitterUser(twitter4j.User user){
		twitterId = user.getId();
		super.setNick(user.getScreenName());
		super.setName(user.getName());
		super.setImage(user.getProfileImageURL().toString());
	}

	public TwitterUser(Twitter twitter, RequestToken requestToken){
		this.twitter = twitter;
		this.requestToken = requestToken;
	}
	
	public void recycle(TwitterUser user){
		twitter = user.getTwitter();
		accessToken = user.getAccessToken();
		secret = user.getSecret();
	}
	
	public void authenticate(TwitterFactory factory){
		twitter = factory.getTwitter(token, secret);
	}
	
	public void authenticate(String oauthVerifier) throws TwitterException{
		accessToken = twitter.getOAuthAccessToken(requestToken, oauthVerifier);
		token = accessToken.getToken();
		secret = accessToken.getTokenSecret();
		
		twitter4j.User user = twitter.showUser(twitter.getScreenName());
		
		twitterId = twitter.getId();
		
		super.setNick(user.getScreenName());
		super.setName(user.getName());
		super.setImage(user.getProfileImageURL().toString());
	}
	
	public String getAuthenticationURL(){
		if(this.requestToken == null)
			return null;
		return requestToken.getAuthenticationURL();
	}
	
	/**
	 * Gera o {@link AccessToken} para esste usuário
	 * se autenticar no twitter, caso ainda não tenha
	 * sido autenticado retorna null
	 * 
	 * @return
	 */
	public AccessToken getAccessToken(){
		if(accessToken == null){
			if(StringUtils.isBlank(token) || StringUtils.isBlank(secret))
				return null;
			accessToken = new AccessToken(token, secret);
		}
		
		return accessToken;
	}
	
	public boolean isAuthenticated(){
		return getAccessToken() != null;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	public Twitter getTwitter() {
		return twitter;
	}

	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}

	public long getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(long twitterId) {
		this.twitterId = twitterId;
	}
	
}
