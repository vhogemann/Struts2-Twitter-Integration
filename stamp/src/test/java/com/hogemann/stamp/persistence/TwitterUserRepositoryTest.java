package com.hogemann.stamp.persistence;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hogemann.stamp.model.TwitterAccount;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-applicationContext.xml","classpath:dataContext.xml"})
public class TwitterUserRepositoryTest extends AbstractHibernateRepositoryTest<TwitterAccount> {

	@Autowired
	private TwitterAccountRepository repository;
	
	@Override
	protected EntityRepository<TwitterAccount> getRepository() {
		return repository;
	}

	@Override
	protected TwitterAccount getEntity() {
		TwitterAccount user = new TwitterAccount();
		user.getUser().setName("test");
		user.getUser().setNick("nickname");
		user.getUser().setImage("http://host.com/image.png");
		return user;
	}

}
