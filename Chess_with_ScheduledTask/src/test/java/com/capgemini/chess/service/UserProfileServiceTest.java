package com.capgemini.chess.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.service.impl.UserProfileServiceImpl;
import com.capgemini.chess.service.to.UserProfileTO;

/**
 * Tests of user profile functions.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserProfileServiceTest {

	@Autowired
	private UserProfileService service;

	@Configuration
	static class RankServiceTestContextConfiguration {
		@Bean
		public UserProfileService userService() {
			return new UserProfileServiceImpl();
		}
	}

	@Test
	public void testReadUserSuccessful() throws Exception {

		// when
		UserProfileTO userTO = service.readUserProfile(1L);
		assertNotNull(userTO);
	}

}
