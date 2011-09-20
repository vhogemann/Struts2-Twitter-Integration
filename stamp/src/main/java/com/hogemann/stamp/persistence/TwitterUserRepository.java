package com.hogemann.stamp.persistence;

import com.hogemann.stamp.model.TwitterUser;

public interface TwitterUserRepository extends EntityRepository<TwitterUser> {
	
	public TwitterUser findFirst(TwitterUser user);

}
