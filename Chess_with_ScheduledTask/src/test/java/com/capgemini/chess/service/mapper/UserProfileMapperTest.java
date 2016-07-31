package com.capgemini.chess.service.mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.capgemini.chess.dataaccess.entities.UserProfileEntity;
import com.capgemini.chess.service.to.UserProfileTO;

/**
 * Tests of user mapper functions.
 */
public class UserProfileMapperTest {

	@Test
	public void shouldMapFromEntityToTO() {
		// given
		UserProfileEntity userEntity = new UserProfileEntity();
		userEntity.setName("Sample Name");
		userEntity.setLifeMotto("Sample Motto");
		// when
		UserProfileTO userTO = UserProfileMapper.map(userEntity);
		// then
		assertNotNull(userTO);
		assertEquals("Sample Name", userTO.getName());
		assertEquals("Sample Motto", userTO.getLifeMotto());
	}

	@Test
	public void shouldMapFromTOToEntity() {
		// given
		UserProfileTO userTO = new UserProfileTO();
		userTO.setAboutMe("Sample About Me");
		userTO.setEmail("sample@mail.com");
		// when
		UserProfileEntity userEntity = UserProfileMapper.map(userTO);
		// then
		assertNotNull(userEntity);
		assertEquals("Sample About Me", userEntity.getAboutMe());
		assertEquals("sample@mail.com", userEntity.getEmail());
	}

	@Test
	public void shouldMapNullFromEntityToTO() {
		// given
		UserProfileEntity userEntity = null;
		// when
		UserProfileTO userTO = UserProfileMapper.map(userEntity);
		// then
		assertNull(userTO);
	}

	@Test
	public void shouldMapNullFromTOToEntity() {
		// given
		UserProfileTO userTO = null;
		// when
		UserProfileEntity userEntity = UserProfileMapper.map(userTO);
		// then
		assertNull(userEntity);
	}

	@Test
	public void shouldMapListFromEntityToTO() {
		// given
		UserProfileEntity userEntity = new UserProfileEntity();
		UserProfileEntity userEntity2 = new UserProfileEntity();
		userEntity.setName("Sample Name");
		userEntity2.setLifeMotto("Sample Motto");
		List<UserProfileEntity> users = new ArrayList<>();
		users.add(userEntity);
		users.add(userEntity2);
		// when
		List<UserProfileTO> userTOs = UserProfileMapper.map2TOs(users);
		// then
		assertNotNull(userTOs);
		assertNotNull(userTOs.get(0));
		assertNotNull(userTOs.get(1));
		assertEquals("Sample Name", userTOs.get(0).getName());
		assertEquals("Sample Motto", userTOs.get(1).getLifeMotto());
	}

	@Test
	public void shouldMapListFromTOToEntity() {
		// given
		UserProfileTO userTO = new UserProfileTO();
		UserProfileTO userTO2 = new UserProfileTO();
		userTO.setName("Sample Name");
		userTO2.setLifeMotto("Sample Motto");
		List<UserProfileTO> users = new ArrayList<>();
		users.add(userTO);
		users.add(userTO2);
		// when
		List<UserProfileEntity> userEntities = UserProfileMapper.map2Entities(users);
		// then
		assertNotNull(userEntities);
		assertNotNull(userEntities.get(0));
		assertNotNull(userEntities.get(1));
		assertEquals("Sample Name", userEntities.get(0).getName());
		assertEquals("Sample Motto", userEntities.get(1).getLifeMotto());
	}

	@Test
	public void shouldUpdateEntity() {
		// given
		UserProfileEntity userProfileEntity = new UserProfileEntity();
		userProfileEntity.setName("Name");
		userProfileEntity.setLogin("Login");
		UserProfileTO userTO = new UserProfileTO();
		userTO.setName("New Name");
		userTO.setLogin("Login");
		// when
		UserProfileEntity result = UserProfileMapper.update(userProfileEntity, userTO);
		// then
		assertTrue(result == userProfileEntity);
		assertEquals(userTO.getName(), result.getName());
		assertEquals(userTO.getLogin(), result.getLogin());
	}

}
