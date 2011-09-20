package com.hogemann.stamp.persistence.database;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hogemann.stamp.model.TwitterUser;
import com.hogemann.stamp.persistence.TwitterUserRepository;

@Repository
public class UserHibernateRepository extends AbstractHibernateReposiory<TwitterUser> implements TwitterUserRepository {

	@Override
	public Class<TwitterUser> getEntityClass() {
		return TwitterUser.class;
	}

	@SuppressWarnings("unchecked")
	public TwitterUser findFirst(TwitterUser user) {
		
		List<TwitterUser> users = super.find(user);
		
		if(users != null && !users.isEmpty())
			return users.iterator().next();
		
		return null;
	}

}
