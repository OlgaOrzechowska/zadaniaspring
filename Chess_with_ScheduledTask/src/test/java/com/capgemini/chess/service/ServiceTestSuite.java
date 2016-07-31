package com.capgemini.chess.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.capgemini.chess.batch.CleanUpServiceTest;
import com.capgemini.chess.batch.CleanUpServiceTestWithDao;
import com.capgemini.chess.service.mapper.ChallengeMapperTest;
import com.capgemini.chess.service.mapper.PlayerMapperTest;
import com.capgemini.chess.service.mapper.UserProfileMapperTest;

/**
 * Class with all tests connected to services.
 */
@RunWith(Suite.class)
@SuiteClasses({ UserProfileServiceTest.class, ChallengeServiceTest.class, CleanUpServiceTestWithDao.class,
		CleanUpServiceTest.class, UserProfileMapperTest.class, PlayerMapperTest.class, ChallengeMapperTest.class })
public class ServiceTestSuite {

}
