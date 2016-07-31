package com.capgemini.chess.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;

/**
 * Service to delete outdated challenges.
 */
@Service
public class CleanUpService {

	private static final int WEEK = 7;

	@Autowired
	private ChallengeDao challengeDao;

	/**
	 * Deletes outdated challenges.
	 */
	public final void deleteOutdatedChallenges() {
		List<ChallengeEntity> challenges = challengeDao.findAll();
		for (ChallengeEntity challenge : challenges) {
			if (isOutdated(challenge)) {
				challengeDao.delete(challenge.getChallengeId());
			}
		}
	}

	/**
	 * Function to check if a challenge is outdated.
	 * 
	 * @param challenge
	 *            to check
	 */
	private boolean isOutdated(final ChallengeEntity challenge) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -WEEK);
		Date oneWeekAgo = calendar.getTime();
		Date challengeDate = challenge.getChallengeDate();
		if (challengeDate.before(oneWeekAgo)) {
			return true;
		}
		return false;
	}
}
