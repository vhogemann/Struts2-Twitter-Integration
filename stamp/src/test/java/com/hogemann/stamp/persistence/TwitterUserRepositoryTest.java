package com.hogemann.stamp.persistence;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hogemann.stamp.model.TwitterUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-applicationContext.xml","classpath:dataContext.xml"})
public class TwitterUserRepositoryTest extends AbstractHibernateRepositoryTest<TwitterUser> {

	private static final String ANOTHER_NAME = "another name";
	@Autowired
	private TwitterUserRepository repository;
	
	@Override
	protected EntityRepository<TwitterUser> getRepository() {
		return repository;
	}

	@Override
	protected TwitterUser getEntity() {
		TwitterUser user = new TwitterUser();
		user.setName("test");
		user.setNick("nickname");
		user.setImage("http://host.com/image.png");
		return user;
	}

	@Override
	protected void modifyEntity(TwitterUser entity) {
		entity.setName(ANOTHER_NAME);
	}

	@Override
	protected boolean confirmModification(TwitterUser entity) {
		return ANOTHER_NAME.equals(entity.getName());
	}

}
