package com.capgemini.chess.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.chess.dataaccess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;

/**
 * Aspect to set id of a challenge before save.
 */
@Aspect
public class ChallengeDaoAspect {

	@Autowired
	private ChallengeDao challengeDao;

	/**
	 * Function that sets id of a challenge before save.
	 * 
	 * @param challenge
	 *            to save
	 */
	@Before("execution(* com.capgemini.chess.dataaccess.dao.ChallengeDao.save(..)) && args(challenge)")
	public final void setChallengeIdBeforeSave(final ChallengeEntity challenge) {
		if (challenge.getChallengeId() == null) {
			challenge.setChallengeId(challengeDao.generateChallengeId());
		}
	}

}
