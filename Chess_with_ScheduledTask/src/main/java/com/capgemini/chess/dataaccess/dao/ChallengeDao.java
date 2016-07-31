package com.capgemini.chess.dataaccess.dao;

import java.util.List;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.enums.ChallengeStatus;

public interface ChallengeDao {

	/**
	 * Allows to find all challenges in database.
	 * 
	 * @return list of all challenges
	 */
	List<ChallengeEntity> findAll();

	/**
	 * Allows to find a challenge with specific id.
	 * 
	 * @param challengeId
	 *            Id of a challenge
	 * @return challenge entity
	 */
	ChallengeEntity findChallengeById(Long challengeId);

	/**
	 * Generates id numbers for challenges.
	 * 
	 * @return next id number
	 */
	long generateChallengeId();

	/**
	 * Saves challenge entity in database.
	 * 
	 * @param challenge
	 *            to save
	 * @return saved challenge
	 */
	ChallengeEntity save(ChallengeEntity challenge);

	/**
	 * Deletes challenge from the database.
	 * 
	 * @param challengeId
	 *            to delete
	 */
	void delete(Long challengeId);

	/**
	 * Updates status of a challenge
	 * 
	 * @param challengeId
	 *            to update
	 * @param status
	 *            new status
	 * @return updated challenge entity
	 */
	ChallengeEntity updateStatus(Long challengeId, ChallengeStatus status);

}
