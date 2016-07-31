package com.capgemini.chess.batch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.capgemini.chess.dataaccess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.service.CleanUpService;

/**
 * Unit tests of module to delete outdated challenges.
 */
@RunWith(MockitoJUnitRunner.class)
public class CleanUpServiceTest {

	@InjectMocks
	private CleanUpService cleanUpService;

	@Mock
	private ChallengeDao challengeDao;

	@Test
	public void shouldDoNothingWhenEmptyList() {
		// given
		when(challengeDao.findAll()).thenReturn(new ArrayList<>());
		// when
		cleanUpService.deleteOutdatedChallenges();
		// then
		verify(challengeDao, never()).delete(anyLong());
	}

	@Test
	public void shouldDoNothingWhenOnlyNewChallenges() {
		// given
		ArrayList<ChallengeEntity> challenges = new ArrayList<>();
		ChallengeEntity challenge1 = new ChallengeEntity();
		ChallengeEntity challenge2 = new ChallengeEntity();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		Date yesterday = calendar.getTime();
		// challenge from yesterday
		challenge1.setChallengeDate(yesterday);
		// challenge from today
		challenge2.setChallengeDate(new Date());
		challenge1.setChallengeId(1L);
		challenge2.setChallengeId(2L);
		challenges.add(challenge1);
		challenges.add(challenge2);
		when(challengeDao.findAll()).thenReturn(challenges);
		// when
		cleanUpService.deleteOutdatedChallenges();
		// then
		verify(challengeDao, never()).delete(anyLong());
	}

	@Test
	public void shouldDeleteWhenOneOutdatedChallenge() {
		// given
		List<ChallengeEntity> challenges = new ArrayList<>();
		ChallengeEntity challenge1 = new ChallengeEntity();
		ChallengeEntity challenge2 = new ChallengeEntity();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -8);
		Date oldDate = calendar.getTime();
		// challenge from eight days ago
		challenge1.setChallengeDate(oldDate);
		// challenge from today
		challenge2.setChallengeDate(new Date());
		challenge1.setChallengeId(11L);
		challenge2.setChallengeId(21L);
		challenges.add(challenge1);
		challenges.add(challenge2);
		when(challengeDao.findAll()).thenReturn(challenges);
		// when
		cleanUpService.deleteOutdatedChallenges();
		// then
		verify(challengeDao).delete(eq(11L));
	}

	@Test
	public void shouldDeleteWhenAllOutdatedChallenges() {
		// given
		List<ChallengeEntity> challenges = new ArrayList<>();
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
		challenges.add(challenge1);
		challenges.add(challenge2);
		when(challengeDao.findAll()).thenReturn(challenges);
		// when
		cleanUpService.deleteOutdatedChallenges();
		// then
		verify(challengeDao, times(2)).delete(anyLong());
		verify(challengeDao).delete(eq(53L));
		verify(challengeDao).delete(eq(62L));
	}

}