package com.capgemini.chess.dataaccess.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.enums.ChallengeStatus;

@Repository
public class ChallengeDaoImpl implements ChallengeDao {

	private Set<ChallengeEntity> challenges = new HashSet<>();
	private static long idGenerator = 1;

	@Override
	public List<ChallengeEntity> findAll() {
		return new ArrayList<>(challenges);
	}

	@Override
	public ChallengeEntity findChallengeById(Long challengeId) {
		ChallengeEntity foundChallenge = null;
		for (ChallengeEntity challenge : challenges) {
			if (challenge.getChallengeId() == challengeId) {
				foundChallenge = challenge;
			}
		}
		return foundChallenge;
	}

	@Override
	public long generateChallengeId() {
		return idGenerator++;
	}

	@Override
	public ChallengeEntity save(ChallengeEntity challenge) {
		challenges.add(challenge);
		return challenge;
	}

	@Override
	public void delete(Long challengeId) {
		Iterator<ChallengeEntity> iterator = challenges.iterator();
		while (iterator.hasNext()) {
			ChallengeEntity challenge = iterator.next();
			if (challenge.getChallengeId() == challengeId) {
				iterator.remove();
			}
		}
	}

	@Override
	public ChallengeEntity updateStatus(Long challengeId, ChallengeStatus status) {
		ChallengeEntity updatedChallenge = null;
		for (ChallengeEntity challenge : challenges) {
			if (challenge.getChallengeId() == challengeId) {
				challenge.setStatus(status);
				updatedChallenge = challenge;
			}
		}
		return updatedChallenge;
	}

}
