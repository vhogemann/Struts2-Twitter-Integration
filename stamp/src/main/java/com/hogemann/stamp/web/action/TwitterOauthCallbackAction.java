package com.hogemann.stamp.web.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;

import twitter4j.TwitterException;

import com.hogemann.stamp.model.TwitterUser;
import com.hogemann.stamp.persistence.TwitterUserRepository;
import com.hogemann.stamp.services.TwitterService;
import com.hogemann.stamp.util.Base32;
import com.opensymphony.xwork2.ActionContext;

public class TwitterOauthCallbackAction implements ServletResponseAware {

	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(TwitterOauthCallbackAction.class);

	private String oauth_verifier;
	
	@Autowired
	private TwitterService service;
	
	@Autowired
	private TwitterUserRepository userRepository;

	private HttpServletResponse response;
	
	public String execute(){
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		TwitterUser user = service.getFromSession(session);
		
		if(user != null && !user.isAuthenticated()) try {
			user.authenticate(oauth_verifier);
			
			TwitterUser recycled = recycle(user);
			long id = 0;
			if(recycled != null){
				user = recycled;
				id = user.getId();
			} else {
				id = service.save(user);
			}
			String base32 = Base32.encode(String.valueOf(id).getBytes());
			Cookie cookie = new Cookie(TwitterService.TWITTER_COOKIE,base32);
			cookie.setMaxAge(60*60*24*15);
			response.addCookie(cookie);
		
		} catch (TwitterException e) {
			log.warn("Erro ao processar callback do Twitter",e);
			return "error";
		}
		
		return "success";
	}
	
	/**
	 * Tenta encontrar um usuário na persistencia
	 * que já tenha sido utilizado, e associa o ID dele
	 * ao usuário com as informações de autenticação
	 * 
	 * @param user
	 */
	private TwitterUser recycle(TwitterUser user){
		TwitterUser recycled = userRepository.findFirst(user);
		if(recycled != null){
			recycled.recycle(user);
		}
		return recycled;
	}
	
	public void setOauth_verifier(String oauth_verifier) {
		this.oauth_verifier = oauth_verifier;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

}
