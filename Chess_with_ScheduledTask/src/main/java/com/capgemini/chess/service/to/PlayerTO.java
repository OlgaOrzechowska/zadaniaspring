package com.capgemini.chess.service.to;

import com.capgemini.chess.enums.Level;

/**
 * Information on player's stats.
 */
public class PlayerTO {

	private Long id;
	private Level level;
	private int points;
	private int gamesPlayed;
	private int gamesWon;
	private int gamesDrawn;
	private int gamesLost;
	private Long userProfileId;

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

	public final Long getUserProfileId() {
		return userProfileId;
	}

	public final void setUserProfileId(final Long userProfileId) {
		this.userProfileId = userProfileId;
	}
}