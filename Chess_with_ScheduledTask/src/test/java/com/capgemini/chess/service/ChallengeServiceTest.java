package com.capgemini.chess.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.aop.ChallengeDaoAspect;
import com.capgemini.chess.dataaccess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.dao.PlayerDao;
import com.capgemini.chess.dataaccess.dao.impl.ChallengeDaoImpl;
import com.capgemini.chess.dataaccess.dao.impl.PlayerDaoImpl;
import com.capgemini.chess.enums.ChallengeStatus;
import com.capgemini.chess.service.impl.ChallengeServiceImpl;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.PlayerTO;

/**
 * Tests of challenge service functions.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ChallengeServiceTest {

	@Autowired
	private ChallengeService challengeService;

	@Configuration
	@EnableAspectJAutoProxy
	static class ChallengeServiceTestContextConfiguration {

		@Bean
		public ChallengeService challengeService() {
			return new ChallengeServiceImpl();
		}

		@Bean
		public ChallengeDao challengeDao() {
			return new ChallengeDaoImpl();
		}

		@Bean
		public PlayerDao playerDao() {
			return new PlayerDaoImpl();
		}

		@Bean
		public ChallengeDaoAspect challengeDaoAspect() {
			return new ChallengeDaoAspect();
		}
	}

	@Test
	public void shouldMakeChallenge() {
		// given
		PlayerTO firstPlayer = new PlayerTO();
		firstPlayer.setId(1L);
		PlayerTO secondPlayer = new PlayerTO();
		secondPlayer.setId(2L);
		// when
		ChallengeTO challengeTO = challengeService.makeChallenge(firstPlayer, secondPlayer);
		// then
		assertNotNull(challengeTO);
		assertEquals(ChallengeStatus.SENT, challengeTO.getStatus());
		assertEquals(1, challengeTO.getFirstPlayerId().longValue());
		assertEquals(2, challengeTO.getSecondPlayerId().longValue());
		assertNotNull(challengeTO.getChallengeId());
	}

	@Test
	public void shouldAcceptChallenge() {
		// given
		PlayerTO firstPlayer = new PlayerTO();
		firstPlayer.setId(1L);
		PlayerTO secondPlayer = new PlayerTO();
		secondPlayer.setId(2L);
		ChallengeTO challengeTO = challengeService.makeChallenge(firstPlayer, secondPlayer);
		// when
		challengeTO = challengeService.acceptChallenge(challengeTO.getChallengeId());
		// then
		assertNotNull(challengeTO);
		assertEquals(ChallengeStatus.ACCEPTED, challengeTO.getStatus());
		assertEquals(1, challengeTO.getFirstPlayerId().longValue());
		assertEquals(2, challengeTO.getSecondPlayerId().longValue());
	}

	@Test
	public void shouldRejectChallenge() {
		// given
		PlayerTO firstPlayer = new PlayerTO();
		firstPlayer.setId(1L);
		PlayerTO secondPlayer = new PlayerTO();
		secondPlayer.setId(2L);
		ChallengeTO challengeTO = challengeService.makeChallenge(firstPlayer, secondPlayer);
		// when
		challengeTO = challengeService.rejectChallenge(challengeTO.getChallengeId());
		// then
		assertEquals(ChallengeStatus.REJECTED, challengeTO.getStatus());
	}

}
