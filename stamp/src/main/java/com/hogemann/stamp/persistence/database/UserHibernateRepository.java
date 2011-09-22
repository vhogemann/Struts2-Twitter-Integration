package com.hogemann.stamp.persistence.database;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hogemann.stamp.model.TwitterAccount;
import com.hogemann.stamp.persistence.TwitterAccountRepository;

@Repository
public class UserHibernateRepository extends AbstractHibernateReposiory<TwitterAccount> implements TwitterAccountRepository {

	@Override
	public Class<TwitterAccount> getEntityClass() {
		return TwitterAccount.class;
	}

	@SuppressWarnings("unchecked")
	public TwitterAccount findFirst(TwitterAccount user) {
		
		List<TwitterAccount> users = super.find(user);
		
		if(users != null && !users.isEmpty())
			return users.iterator().next();
		
		return null;
	}

}
