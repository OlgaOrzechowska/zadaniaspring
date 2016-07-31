package com.capgemini.chess.dataaccess.dao;

import java.util.List;

import com.capgemini.chess.dataaccess.entities.PlayerEntity;

public interface PlayerDao {

	/**
	 * Allows to find all players in database.
	 * 
	 * @return list of all users
	 */
	List<PlayerEntity> findAll();

	/**
	 * Allows to find a player with specific challenge.
	 * 
	 * @param challengeId
	 *            Id of player's challenge
	 * @return player entity
	 */
	PlayerEntity findPlayerById(Long challengeId);

	/**
	 * Generates id numbers for players.
	 * 
	 * @return next id number
	 */
	long generatePlayerId();

	/**
	 * Saves player entity in database.
	 * 
	 * @param player
	 *            to save
	 * @return saved player
	 */
	PlayerEntity save(PlayerEntity player);
}
