package com.capgemini.chess.batch;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.dataaccess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.dao.impl.ChallengeDaoImpl;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.service.CleanUpService;

/**
 * Integration tests of module to delete outdated challenges.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CleanUpServiceTestWithDao {

	@Autowired
	private CleanUpService cleanUpService;

	@Autowired
	private ChallengeDao challengeDao;

	@Configuration
	static class CleanUpTestContextConfiguration {

		@Bean
		public CleanUpService cleanUpService() {
			return new CleanUpService();
		}

		@Bean
		public ChallengeDao challengeDao() {
			return new ChallengeDaoImpl();
		}
	}

	@Test
	public void shouldDoNothingWhenOnlyNewChallenges() {
		// given
		ChallengeEntity challenge1 = new ChallengeEntity();
		ChallengeEntity challenge2 = new ChallengeEntity();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		Date yesterday = calendar.getTime();
		// challenge from yesterday
		challenge1.setChallengeDate(yesterday);
		// challenge from today
		challenge2.setChallengeDate(new Date());
		challengeDao.save(challenge1);
		challengeDao.save(challenge2);
		// when
		cleanUpService.deleteOutdatedChallenges();
		// then
		assertFalse(challengeDao.findAll().isEmpty());
		assertNotNull(challengeDao.findChallengeById(challenge1.getChallengeId()));
		assertNotNull(challengeDao.findChallengeById(challenge2.getChallengeId()));
	}

	@Test
	public void shouldDeleteWhenAllOutdatedChallenges() {
		// given
		ChallengeEntity challenge1 = new ChallengeEntity();
		ChallengeEntity challenge2 = new ChallengeEntity();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -8);
		Date oldDate = calendar.getTime();
		// challenge from eight days ago
		challenge1.setChallengeDate(oldDate);
		calendar.add(Calendar.DATE, -10);
		Date olderDate = calendar.getTime();
		// challenge from ten days ago
		challenge2.setChallengeDate(olderDate);
		challenge1.setChallengeId(53L);
		challenge2.setChallengeId(62L);
		challengeDao.save(challenge1);
		challengeDao.save(challenge2);
		// when
		cleanUpService.deleteOutdatedChallenges();
		// then
		assertNull(challengeDao.findChallengeById(challenge1.getChallengeId()));
		assertNull(challengeDao.findChallengeById(challenge2.getChallengeId()));
	}

}