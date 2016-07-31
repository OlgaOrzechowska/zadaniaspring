package com.capgemini.chess.service.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.capgemini.chess.dataaccess.entities.PlayerEntity;
import com.capgemini.chess.enums.Level;
import com.capgemini.chess.service.to.PlayerTO;

/**
 * Tests of player mapper functions.
 */
public class PlayerMapperTest {

	@Test
	public void shouldMapFromEntityToTO() {
		// given
		PlayerEntity entity = new PlayerEntity();
		entity.setGamesWon(10);
		entity.setGamesLost(15);
		entity.setGamesDrawn(20);
		entity.setGamesPlayed(45);
		entity.setLevel(Level.BEGINNER);
		// when
		PlayerTO to = PlayerMapper.map(entity);
		// then
		assertNotNull(to);
		assertEquals(entity.getGamesWon(), to.getGamesWon());
		assertEquals(entity.getGamesLost(), to.getGamesLost());
		assertEquals(entity.getGamesDrawn(), to.getGamesDrawn());
		assertEquals(entity.getGamesPlayed(), to.getGamesPlayed());
		assertEquals(entity.getLevel(), to.getLevel());
	}

	@Test
	public void shouldMapFromTOToEntity() {
		// given
		PlayerTO to = new PlayerTO();
		to.setGamesWon(1);
		to.setGamesLost(2);
		to.setGamesDrawn(3);
		to.setGamesPlayed(6);
		to.setLevel(Level.CHUCK_NORRIS_OF_CHESS);
		// when
		PlayerEntity entity = PlayerMapper.map(to);
		// then
		assertNotNull(entity);
		assertEquals(to.getGamesWon(), entity.getGamesWon());
		assertEquals(to.getGamesLost(), entity.getGamesLost());
		assertEquals(to.getGamesDrawn(), entity.getGamesDrawn());
		assertEquals(to.getGamesPlayed(), entity.getGamesPlayed());
		assertEquals(to.getLevel(), entity.getLevel());
	}

	@Test
	public void shouldMapNullFromEntityToTO() {
		// given
		PlayerEntity entity = null;
		// when
		PlayerTO userTO = PlayerMapper.map(entity);
		// then
		assertNull(userTO);
	}

	@Test
	public void shouldMapNullFromTOToEntity() {
		// given
		PlayerEntity userTO = null;
		// when
		PlayerTO userEntity = PlayerMapper.map(userTO);
		// then
		assertNull(userEntity);
	}

	@Test
	public void shouldMapListFromEntityToTO() {
		// given
		PlayerEntity entity = new PlayerEntity();
		PlayerEntity entity2 = new PlayerEntity();
		entity.setGamesPlayed(10);
		entity2.setGamesPlayed(20);
		List<PlayerEntity> players = new ArrayList<>();
		players.add(entity);
		players.add(entity2);
		// when
		List<PlayerTO> userTOs = PlayerMapper.map2TOs(players);
		// then
		assertNotNull(userTOs);
		assertNotNull(userTOs.get(0));
		assertNotNull(userTOs.get(1));
		assertEquals(entity.getGamesPlayed(), userTOs.get(0).getGamesPlayed());
		assertEquals(entity2.getGamesPlayed(), userTOs.get(1).getGamesPlayed());
	}

	@Test
	public void shouldMapListFromTOToEntity() {
		// given
		PlayerTO to1 = new PlayerTO();
		PlayerTO to2 = new PlayerTO();
		to1.setGamesPlayed(10);
		to2.setGamesPlayed(20);
		List<PlayerTO> players = new ArrayList<>();
		players.add(to1);
		players.add(to2);
		// when
		List<PlayerEntity> playerTOs = PlayerMapper.map2Entities(players);
		// then
		assertNotNull(playerTOs);
		assertNotNull(playerTOs.get(0));
		assertNotNull(playerTOs.get(1));
		assertEquals(to1.getGamesPlayed(), playerTOs.get(0).getGamesPlayed());
		assertEquals(to2.getGamesPlayed(), playerTOs.get(1).getGamesPlayed());
	}

	@Test
	public void shouldUpdateEntity() {
		// given
		PlayerEntity entity = new PlayerEntity();
		entity.setGamesLost(10);
		entity.setGamesPlayed(100);
		PlayerTO to = new PlayerTO();
		to.setGamesLost(10);
		to.setGamesPlayed(111);
		// when
		PlayerEntity result = PlayerMapper.update(entity, to);
		// then
		assertTrue(result == entity);
		assertEquals(to.getGamesLost(), result.getGamesLost());
		assertEquals(to.getGamesPlayed(), result.getGamesPlayed());
	}

}
