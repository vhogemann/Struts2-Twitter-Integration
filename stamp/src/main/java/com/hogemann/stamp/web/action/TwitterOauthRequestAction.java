package com.hogemann.stamp.web.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.hogemann.stamp.model.TwitterAccount;
import com.hogemann.stamp.services.TwitterService;

@Controller("twitterAuth")
public class TwitterOauthRequestAction implements SessionAware {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TwitterService service;

	private Map<String, Object> session;

	private String redirect;

	public String execute() {

		TwitterAccount account = service.startAuthentication();
		redirect = account.getAuthenticationURL();
		session.put(TwitterService.TWITTER_USER, account);

		return "success";
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getRedirect() {
		return redirect;
	}

}
