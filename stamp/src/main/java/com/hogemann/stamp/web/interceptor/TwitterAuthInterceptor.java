package com.hogemann.stamp.web.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.hogemann.stamp.model.TwitterAccount;
import com.hogemann.stamp.services.TwitterService;
import com.hogemann.stamp.util.Base32;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Injeta um usuário autenticado na sessão
 * 
 * @author victor
 * 
 */
public class TwitterAuthInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(TwitterAuthInterceptor.class);

	@Autowired
	private TwitterService service;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		Object obj = invocation.getAction();
		Map<String, Object> session = invocation.getInvocationContext().getSession();

		TwitterAccount account = service.getFromSession(session);
		String userId = getTwitterCookie(ServletActionContext.getRequest());
			
		if (account == null && StringUtils.isNotBlank(userId)) {
			try {
				long id = Long.valueOf(userId);
				account = service.loadUser(id);
				if(account != null)
					session.put(TwitterService.TWITTER_USER, account);
			} catch (NumberFormatException e) {
				log.warn("Bogus value set as " + TwitterService.TWITTER_COOKIE + " value: " + userId);
			}
		}

		if (obj instanceof UserAware) {
			UserAware action = (UserAware) obj;
			action.setUser(account.getUser());
		}

		return invocation.invoke();
	}

	private String getTwitterCookie(HttpServletRequest request){
		
		String userId = null;
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for (Cookie cookie : cookies){
				if(cookie.getName().equals(TwitterService.TWITTER_COOKIE)){
					String base32 = cookie.getValue();
					byte[] bytes = Base32.decode(base32);
					userId = new String(bytes);
				}
			}
		}
		
		return userId;
	}

}
