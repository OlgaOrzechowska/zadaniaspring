package com.capgemini.chess.dataaccess.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Entity with user profile information.
 */
@Entity
public class UserProfileEntity {

	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String password;
	private String name;
	private String surname;
	private String email;
	@Lob
	private String aboutMe;
	@Lob
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

	public final String getPassword() {
		return password;
	}

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
