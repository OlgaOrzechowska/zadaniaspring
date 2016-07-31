package com.capgemini.chess.service;

import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.PlayerTO;

public interface ChallengeService {

	/**
	 * Changes challenge status to accepted.
	 * 
	 * @param challengeId
	 *            id of a challenge to accept
	 * @return challenge
	 */
	ChallengeTO acceptChallenge(Long challengeId);

	/**
	 * Changes challenge status to rejected.
	 * 
	 * @param challengeId
	 *            id of a challenge to reject
	 * @return challenge
	 */
	ChallengeTO rejectChallenge(Long challengeId);

	/**
	 * Creates a new challenge.
	 * 
	 * @param firstPlayer
	 *            first player
	 * @param secondPlayer
	 *            second player
	 * @return challenge
	 */
	ChallengeTO makeChallenge(PlayerTO firstPlayer, PlayerTO secondPlayer);
}
