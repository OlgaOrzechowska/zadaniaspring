package com.capgemini.chess.service.impl;

import org.springframework.stereotype.Service;

import com.capgemini.chess.service.UserProfileService;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Override
	public final UserProfileTO readUserProfile(final Long id) {

		return new UserProfileTO();
	}
}
