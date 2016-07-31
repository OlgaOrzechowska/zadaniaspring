package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.PlayerEntity;
import com.capgemini.chess.service.to.PlayerTO;

/**
 * Mapper from player entity to TO.
 */
public final class PlayerMapper {

	// Instantiating not allowed
	private PlayerMapper() {
	}

	/**
	 * Maps player entity to TO.
	 * 
	 * @param playerEntity
	 *            is an entity
	 * @return player TO
	 */
	public static PlayerTO map(final PlayerEntity playerEntity) {
		if (playerEntity != null) {
			PlayerTO playerTO = new PlayerTO();
			playerTO.setGamesPlayed(playerEntity.getGamesPlayed());
			playerTO.setGamesDrawn(playerEntity.getGamesDrawn());
			playerTO.setGamesLost(playerEntity.getGamesLost());
			playerTO.setGamesWon(playerEntity.getGamesWon());
			playerTO.setId(playerEntity.getId());
			playerTO.setLevel(playerEntity.getLevel());
			playerTO.setPoints(playerEntity.getPoints());
			return playerTO;
		}
		return null;
	}

	/**
	 * Maps player TO to entity.
	 * 
	 * @param playerTO
	 *            is a to
	 * @return player entity
	 */
	public static PlayerEntity map(final PlayerTO playerTO) {
		if (playerTO != null) {
			PlayerEntity playerEntity = new PlayerEntity();
			playerEntity.setGamesPlayed(playerTO.getGamesPlayed());
			playerEntity.setGamesDrawn(playerTO.getGamesDrawn());
			playerEntity.setGamesLost(playerTO.getGamesLost());
			playerEntity.setGamesWon(playerTO.getGamesWon());
			playerEntity.setId(playerTO.getId());
			playerEntity.setLevel(playerTO.getLevel());
			playerEntity.setPoints(playerTO.getPoints());
			return playerEntity;
		}
		return null;
	}

	public static PlayerEntity update(final PlayerEntity playerEntity, final PlayerTO playerTO) {
		if (playerTO != null && playerEntity != null) {
			playerEntity.setGamesPlayed(playerTO.getGamesPlayed());
			playerEntity.setGamesDrawn(playerTO.getGamesDrawn());
			playerEntity.setGamesLost(playerTO.getGamesLost());
			playerEntity.setGamesWon(playerTO.getGamesWon());
			playerEntity.setId(playerTO.getId());
			playerEntity.setLevel(playerTO.getLevel());
			playerEntity.setPoints(playerTO.getPoints());
		}
		return playerEntity;
	}

	/**
	 * Maps list of player entities to TOs.
	 * 
	 * @param userEntities
	 *            list of entities
	 * @return list of player TOs
	 */
	public static List<PlayerTO> map2TOs(final List<PlayerEntity> userEntities) {
		return userEntities.stream().map(PlayerMapper::map).collect(Collectors.toList());
	}

	/**
	 * Maps list of player TOs to entities.
	 * 
	 * @param playerTOs
	 *            list of TOs
	 * @return list of player entities
	 */
	public static List<PlayerEntity> map2Entities(final List<PlayerTO> playerTOs) {
		return playerTOs.stream().map(PlayerMapper::map).collect(Collectors.toList());
	}
}
