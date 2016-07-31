package com.capgemini.chess.service.to;

import java.util.Date;

import com.capgemini.chess.enums.ChallengeStatus;

/**
 * Information on a challenge.
 */
public class ChallengeTO {

	private Long challengeId;
	private Long firstPlayerId;
	private Long secondPlayerId;
	private Date challengeDate;
	private ChallengeStatus status;

	public final Long getChallengeId() {
		return challengeId;
	}

	public final void setChallengeId(final Long challengeId) {
		this.challengeId = challengeId;
	}

	public final Long getFirstPlayerId() {
		return firstPlayerId;
	}

	public final void setFirstPlayerId(final Long firstPlayerId) {
		this.firstPlayerId = firstPlayerId;
	}

	public final Long getSecondPlayerId() {
		return secondPlayerId;
	}

	public final void setSecondPlayerId(final Long secondPlayerId) {
		this.secondPlayerId = secondPlayerId;
	}

	public final Date getChallengeDate() {
		return challengeDate;
	}

	public final void setChallengeDate(final Date challengeDate) {
		this.challengeDate = challengeDate;
	}

	public final ChallengeStatus getStatus() {
		return status;
	}

	public final void setStatus(final ChallengeStatus status) {
		this.status = status;
	}
}
