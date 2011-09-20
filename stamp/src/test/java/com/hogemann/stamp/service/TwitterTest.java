package com.hogemann.stamp.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

import com.hogemann.stamp.util.TwitterFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-applicationContext.xml","classpath:dataContext.xml","classpath:serviceContext.xml"})
public class TwitterTest {
	
	//vhogemann
	private static final String TWITTER_SECRET = "ZcZaxctoMFIcanMPy5iLC26EFWDwxqjiLymRHiI";
	private static final String TWITTER_TOKEN = "15378234-kG6UOeg4GoK8IEjUOmbyOTovFjVa9724dbIBoSc0A";

	@Autowired
	private TwitterFactory twitterFactory;
	
	@Test
	public void testConfiguration(){
		//Just verifies if the context goes up
	}
	
	@Test
	public void testSearch(){
		Query query = new Query();
		query.setQuery("@vhogemann");

		Twitter twitter = twitterFactory.getTwitter();
		
		try {
			QueryResult result = twitter.search(query);
			for(Tweet tweet : result.getTweets() ){
				System.out.println(tweet.getFromUser() + " : " + tweet.getText());
			}
			
		} catch (TwitterException e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void testSearchUser(){
		try {
			Twitter twitter = twitterFactory.getTwitter(TWITTER_TOKEN, TWITTER_SECRET);
			ResponseList<User> response = twitter.searchUsers("hogemann", 0);
			for(User user : response){
				System.out.println(user.getName() + " - " + user.getScreenName() + " (" + user.getId() + ")");
			}
		} catch (TwitterException e) {
			Assert.fail(e.getMessage());
		}
	}
	
}
