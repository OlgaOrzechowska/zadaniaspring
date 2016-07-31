package com.capgemini.chess.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.capgemini.chess.service.CleanUpService;

/**
 * Batch that deletes outdated challenges.
 */
@Component
public class ScheduledChallengeDelete {

	@Autowired
	private CleanUpService cleanUpService;

	private static final int ONE_HOUR = 3600000;

	/**
	 * Function that deletes outdated challenges.
	 */
	@Scheduled(fixedRate = ONE_HOUR)
	public final void deleteOutdatedChallenges() {
		cleanUpService.deleteOutdatedChallenges();
	}

}