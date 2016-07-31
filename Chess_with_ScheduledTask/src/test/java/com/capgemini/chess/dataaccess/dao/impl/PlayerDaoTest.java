package com.capgemini.chess.dataaccess.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.aop.PlayerDaoAspect;
import com.capgemini.chess.dataaccess.dao.PlayerDao;
import com.capgemini.chess.dataaccess.entities.PlayerEntity;

/**
 * Tests of player functions.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PlayerDaoTest {

	@Autowired
	private PlayerDao playerDao;

	@Configuration
	@EnableAspectJAutoProxy
	static class PlayerDaoTestContextConfiguration {

		@Bean
		public PlayerDao playerDao() {
			return new PlayerDaoImpl();
		}

		@Bean
		public PlayerDaoAspect playerDaoAspect() {
			return new PlayerDaoAspect();
		}
	}

	@Test
	public void shouldFindAllPlayers() {
		// when
		List<PlayerEntity> players = playerDao.findAll();
		// then
		assertNotNull(players);
	}

	@Test
	public void shouldSavePlayers() {
		// given
		PlayerEntity player = new PlayerEntity();
		// when
		playerDao.save(player);
		List<PlayerEntity> players = playerDao.findAll();
		// then
		assertNotNull(players);
		assertNotNull(players.get(0));
		assertNotNull(players.get(0).getId());
	}

	@Test
	public void shouldFindPlayerById() {
		// given
		PlayerEntity player = new PlayerEntity();
		player.setId(23L);
		// when
		playerDao.save(player);
		PlayerEntity foundPlayer = playerDao.findPlayerById(23L);
		// then
		assertNotNull(foundPlayer);
		assertNotNull(foundPlayer.getId());
		assertEquals(23, foundPlayer.getId().longValue());
	}

}
