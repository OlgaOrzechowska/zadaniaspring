package com.capgemini.chess.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.chess.dataaccess.dao.PlayerDao;
import com.capgemini.chess.dataaccess.entities.PlayerEntity;

/**
 * Aspect to set id of a challenge before save.
 */
@Aspect
public class PlayerDaoAspect {

	@Autowired
	private PlayerDao playerDao;

	/**
	 * Function that sets id of a player before save.
	 * 
	 * @param player
	 *            to save
	 */
	@Before("execution(* com.capgemini.chess.dataaccess.dao.PlayerDao.save(..)) && args(player)")
	public final void setPlayerIdBeforeSave(final PlayerEntity player) {
		if (player.getId() == null) {
			player.setId(playerDao.generatePlayerId());
		}
	}

}
