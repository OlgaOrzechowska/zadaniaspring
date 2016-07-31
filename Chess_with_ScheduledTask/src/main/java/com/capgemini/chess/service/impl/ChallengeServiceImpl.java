package com.capgemini.chess.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.entities.PlayerEntity;
import com.capgemini.chess.enums.ChallengeStatus;
import com.capgemini.chess.service.ChallengeService;
import com.capgemini.chess.service.mapper.ChallengeMapper;
import com.capgemini.chess.service.mapper.PlayerMapper;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.PlayerTO;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Autowired
	private ChallengeDao challengeDao;

	@Override
	public final ChallengeTO makeChallenge(final PlayerTO firstPlayer, final PlayerTO secondPlayer) {
		ChallengeEntity challenge = new ChallengeEntity();
		PlayerEntity firstPlayerEntity = PlayerMapper.map(firstPlayer);
		PlayerEntity secondPlayerEntity = PlayerMapper.map(secondPlayer);
		challenge.setFirstPlayer(firstPlayerEntity);
		challenge.setSecondPlayer(secondPlayerEntity);
		challenge.setStatus(ChallengeStatus.SENT);
		challenge.setChallengeDate(new Date());
		challengeDao.save(challenge);
		return ChallengeMapper.map(challenge);
	}

	@Override
	public final ChallengeTO acceptChallenge(final Long challengeId) {
		ChallengeEntity challengeEntity = challengeDao.updateStatus(challengeId, ChallengeStatus.ACCEPTED);
		return ChallengeMapper.map(challengeEntity);
	}

	@Override
	public final ChallengeTO rejectChallenge(final Long challengeId) {
		ChallengeEntity challengeEntity = challengeDao.updateStatus(challengeId, ChallengeStatus.REJECTED);
		return ChallengeMapper.map(challengeEntity);
	}
}
