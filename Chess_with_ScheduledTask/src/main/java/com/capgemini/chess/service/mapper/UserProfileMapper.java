package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.UserProfileEntity;
import com.capgemini.chess.service.to.UserProfileTO;

/**
 * Mapper from user profile entity to TO.
 */
public final class UserProfileMapper {

	// Instantiating not allowed
	private UserProfileMapper() {
	}

	/**
	 * Maps user entity to TO.
	 * 
	 * @param userEntity
	 *            an entity to map
	 * @return user TO
	 */
	public static UserProfileTO map(final UserProfileEntity userEntity) {
		if (userEntity != null) {
			UserProfileTO userTO = new UserProfileTO();
			userTO.setAboutMe(userEntity.getAboutMe());
			userTO.setEmail(userEntity.getEmail());
			userTO.setId(userEntity.getId());
			userTO.setLifeMotto(userEntity.getLifeMotto());
			userTO.setLogin(userEntity.getLogin());
			userTO.setName(userEntity.getName());
			userTO.setPassword(userEntity.getPassword());
			userTO.setSurname(userEntity.getSurname());
			return userTO;
		}
		return null;
	}

	/**
	 * Maps user TO to entity.
	 * 
	 * @param userTO
	 *            a TO to map
	 * @return user entity
	 */
	public static UserProfileEntity map(final UserProfileTO userTO) {
		if (userTO != null) {
			UserProfileEntity userEntity = new UserProfileEntity();
			userEntity.setAboutMe(userTO.getAboutMe());
			userEntity.setEmail(userTO.getEmail());
			userEntity.setId(userTO.getId());
			userEntity.setLifeMotto(userTO.getLifeMotto());
			userEntity.setLogin(userTO.getLogin());
			userEntity.setName(userTO.getName());
			userEntity.setPassword(userTO.getPassword());
			userEntity.setSurname(userTO.getSurname());
			return userEntity;
		}
		return null;
	}

	public static UserProfileEntity update(final UserProfileEntity userEntity, final UserProfileTO userTO) {
		if (userTO != null && userEntity != null) {
			userEntity.setAboutMe(userTO.getAboutMe());
			userEntity.setEmail(userTO.getEmail());
			userEntity.setId(userTO.getId());
			userEntity.setLifeMotto(userTO.getLifeMotto());
			userEntity.setName(userTO.getName());
			userEntity.setPassword(userTO.getPassword());
			userEntity.setSurname(userTO.getSurname());
		}
		return userEntity;
	}

	/**
	 * Maps user entities to TOs.
	 * 
	 * @param userEntities
	 *            list of entities
	 * @return user TOs
	 */
	public static List<UserProfileTO> map2TOs(final List<UserProfileEntity> userEntities) {
		return userEntities.stream().map(UserProfileMapper::map).collect(Collectors.toList());
	}

	/**
	 * Maps user TOs to entities.
	 * 
	 * @param userTOs
	 *            list of TOs
	 * @return user entities
	 */
	public static List<UserProfileEntity> map2Entities(final List<UserProfileTO> userTOs) {
		return userTOs.stream().map(UserProfileMapper::map).collect(Collectors.toList());
	}
}
