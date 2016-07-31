package com.capgemini.chess.service.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.entities.PlayerEntity;
import com.capgemini.chess.enums.ChallengeStatus;
import com.capgemini.chess.service.to.ChallengeTO;

/**
 * Tests of challenge mapper functions.
 */
public class ChallengeMapperTest {

	@Test
	public void shouldMapFromEntityToTO() {
		// given
		ChallengeEntity challengeEntity = new ChallengeEntity();
		PlayerEntity player1 = new PlayerEntity();
		PlayerEntity player2 = new PlayerEntity();
		challengeEntity.setStatus(ChallengeStatus.ACCEPTED);
		challengeEntity.setFirstPlayer(player1);
		challengeEntity.setSecondPlayer(player2);
		// when
		ChallengeTO challengeTO = ChallengeMapper.map(challengeEntity);
		// then
		assertNotNull(challengeTO);
		assertEquals(ChallengeStatus.ACCEPTED, challengeTO.getStatus());
	}

	@Test
	public void shouldMapNullFromEntityToTO() {
		// given
		ChallengeEntity challengeEntity = null;
		// when
		ChallengeTO challengeTO = ChallengeMapper.map(challengeEntity);
		// then
		assertNull(challengeTO);
	}

	@Test
	public void shouldMapListFromEntityToTO() {
		// given
		ChallengeEntity challengeEntity = new ChallengeEntity();
		ChallengeEntity challengeEntity2 = new ChallengeEntity();
		PlayerEntity player1 = new PlayerEntity();
		PlayerEntity player2 = new PlayerEntity();
		challengeEntity.setStatus(ChallengeStatus.ACCEPTED);
		challengeEntity.setFirstPlayer(player1);
		challengeEntity.setSecondPlayer(player2);
		challengeEntity2.setStatus(ChallengeStatus.REJECTED);
		challengeEntity2.setFirstPlayer(player1);
		challengeEntity2.setSecondPlayer(player2);
		List<ChallengeEntity> challenges = new ArrayList<>();
		challenges.add(challengeEntity);
		challenges.add(challengeEntity2);
		// when
		List<ChallengeTO> challengeTOs = ChallengeMapper.map2TOs(challenges);
		// then
		assertNotNull(challengeTOs);
		assertNotNull(challengeTOs.get(0));
		assertNotNull(challengeTOs.get(1));
		assertEquals(ChallengeStatus.ACCEPTED, challengeTOs.get(0).getStatus());
		assertEquals(ChallengeStatus.REJECTED, challengeTOs.get(1).getStatus());
	}

}
