package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.service.to.ChallengeTO;

/**
 * Mapper from challenge entity to TO.
 */
public final class ChallengeMapper {

	// Instantiating not allowed
	private ChallengeMapper() {
	}

	/**
	 * Maps challenge entity to challenge TO.
	 * 
	 * @param challengeEntity
	 *            is an entity
	 * @return challenge TO
	 */
	public static ChallengeTO map(final ChallengeEntity challengeEntity) {
		if (challengeEntity != null) {
			ChallengeTO challengeTO = new ChallengeTO();
			challengeTO.setFirstPlayerId(challengeEntity.getFirstPlayer().getId());
			challengeTO.setSecondPlayerId(challengeEntity.getSecondPlayer().getId());
			challengeTO.setChallengeId(challengeEntity.getChallengeId());
			challengeTO.setChallengeDate(challengeEntity.getChallengeDate());
			challengeTO.setStatus(challengeEntity.getStatus());
			return challengeTO;
		}
		return null;
	}

	/**
	 * Maps list of challenge entities to TOs.
	 * 
	 * @param challengeEntities
	 *            list of entities
	 * @return list of challenge TOs
	 */
	public static List<ChallengeTO> map2TOs(final List<ChallengeEntity> challengeEntities) {
		return challengeEntities.stream().map(ChallengeMapper::map).collect(Collectors.toList());
	}

}
