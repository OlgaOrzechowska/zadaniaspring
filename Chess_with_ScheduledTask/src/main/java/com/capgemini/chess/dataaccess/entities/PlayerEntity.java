package com.capgemini.chess.dataaccess.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.capgemini.chess.enums.Level;

/**
 * Information on player's stats.
 */
@Entity
public class PlayerEntity {

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private Level level;
	@Column(nullable = false)
	private int points;
	@Column(nullable = false)
	private int gamesPlayed;
	@Column(nullable = false)
	private int gamesWon;
	@Column(nullable = false)
	private int gamesDrawn;
	@Column(nullable = false)
	private int gamesLost;
	@OneToOne
	private UserProfileEntity userProfile;

	public final Long getId() {
		return id;
	}

	public final void setId(final Long id) {
		this.id = id;
	}

	public final Level getLevel() {
		return level;
	}

	public final void setLevel(final Level level) {
		this.level = level;
	}

	public final int getPoints() {
		return points;
	}

	public final void setPoints(final int points) {
		this.points = points;
	}

	public final int getGamesPlayed() {
		return gamesPlayed;
	}

	public final void setGamesPlayed(final int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public final int getGamesWon() {
		return gamesWon;
	}

	public final void setGamesWon(final int gamesWon) {
		this.gamesWon = gamesWon;
	}

	public final int getGamesDrawn() {
		return gamesDrawn;
	}

	public final void setGamesDrawn(final int gamesDrawn) {
		this.gamesDrawn = gamesDrawn;
	}

	public final int getGamesLost() {
		return gamesLost;
	}

	public final void setGamesLost(final int gamesLost) {
		this.gamesLost = gamesLost;
	}
}