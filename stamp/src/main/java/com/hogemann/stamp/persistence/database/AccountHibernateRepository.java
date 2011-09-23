package com.hogemann.stamp.persistence.database;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hogemann.stamp.model.TwitterAccount;
import com.hogemann.stamp.persistence.TwitterAccountRepository;

@Repository
public class AccountHibernateRepository extends AbstractHibernateReposiory<TwitterAccount> implements TwitterAccountRepository {

	@Override
	public Class<TwitterAccount> getEntityClass() {
		return TwitterAccount.class;
	}

	public TwitterAccount findFirst(TwitterAccount account) {
		
		List<TwitterAccount> accounts = super.find(account);
		
		if(accounts != null && !accounts.isEmpty())
			return accounts.iterator().next();
		
		return null;
	}

}
