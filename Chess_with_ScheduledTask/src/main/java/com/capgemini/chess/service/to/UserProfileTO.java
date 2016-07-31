package com.capgemini.chess.service.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Information of user profile.
 */
public class UserProfileTO {

	private long id;
	private String login;
	private String password;
	private String name;
	private String surname;
	private String email;
	private String aboutMe;
	private String lifeMotto;

	public final long getId() {
		return id;
	}

	public final void setId(final long id) {
		this.id = id;
	}

	public final String getLogin() {
		return login;
	}

	public final void setLogin(final String login) {
		this.login = login;
	}

	@JsonIgnore
	public final String getPassword() {
		return password;
	}

	@JsonProperty
	public final void setPassword(final String password) {
		this.password = password;
	}

	public final String getName() {
		return name;
	}

	public final void setName(final String name) {
		this.name = name;
	}

	public final String getSurname() {
		return surname;
	}

	public final void setSurname(final String surname) {
		this.surname = surname;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(final String email) {
		this.email = email;
	}

	public final String getAboutMe() {
		return aboutMe;
	}

	public final void setAboutMe(final String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public final String getLifeMotto() {
		return lifeMotto;
	}

	public final void setLifeMotto(final String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}
}
