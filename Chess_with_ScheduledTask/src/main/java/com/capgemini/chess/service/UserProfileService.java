package com.capgemini.chess.service;

import com.capgemini.chess.service.to.UserProfileTO;

/**
 * Service connected to user profile.
 */
public interface UserProfileService {

	/**
	 * @param id
	 *            of a user
	 * @return user profile
	 */
	UserProfileTO readUserProfile(Long id);

}
