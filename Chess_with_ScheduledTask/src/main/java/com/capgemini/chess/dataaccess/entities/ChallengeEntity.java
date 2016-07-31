package com.capgemini.chess.dataaccess.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.capgemini.chess.enums.ChallengeStatus;

/**
 * Entity with challenge information.
 */
@Entity
public class ChallengeEntity {

	@Id
	@GeneratedValue
	private Long challengeId;
	@ManyToOne
	private PlayerEntity firstPlayer;
	@ManyToOne
	private PlayerEntity secondPlayer;
	@Column(nullable = false)
	private Date challengeDate;
	@Column(nullable = false)
	private ChallengeStatus status;

	/**
	 * @return challenge id
	 */
	public final Long getChallengeId() {
		return challengeId;
	}

	/**
	 * @param challengeId
	 *            id to set
	 */
	public final void setChallengeId(final Long challengeId) {
		this.challengeId = challengeId;
	}

	/**
	 * @return first player
	 */
	public final PlayerEntity getFirstPlayer() {
		return firstPlayer;
	}

	/**
	 * @param firstPlayer
	 *            to set
	 */
	public final void setFirstPlayer(final PlayerEntity firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	/**
	 * @return second player
	 */
	public final PlayerEntity getSecondPlayer() {
		return secondPlayer;
	}

	/**
	 * @param secondPlayer
	 *            to set
	 */
	public final void setSecondPlayer(final PlayerEntity secondPlayer) {
		this.secondPlayer = secondPlayer;
	}

	/**
	 * @return challenge date
	 */
	public final Date getChallengeDate() {
		return challengeDate;
	}

	/**
	 * @param challengeDate
	 *            to set
	 */
	public final void setChallengeDate(final Date challengeDate) {
		this.challengeDate = challengeDate;
	}

	/**
	 * @return status
	 */
	public final ChallengeStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            to set
	 */
	public final void setStatus(final ChallengeStatus status) {
		this.status = status;
	}
}
