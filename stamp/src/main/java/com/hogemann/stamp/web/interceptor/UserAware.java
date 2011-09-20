package com.hogemann.stamp.web.interceptor;

import com.hogemann.stamp.model.User;

public interface UserAware {
	public void setUser(User user);
}
