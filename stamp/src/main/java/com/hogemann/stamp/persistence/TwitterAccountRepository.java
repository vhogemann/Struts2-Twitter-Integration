package com.hogemann.stamp.persistence;

import com.hogemann.stamp.model.TwitterAccount;

public interface TwitterAccountRepository extends EntityRepository<TwitterAccount> {
	
	public TwitterAccount findFirst(TwitterAccount account);

}
