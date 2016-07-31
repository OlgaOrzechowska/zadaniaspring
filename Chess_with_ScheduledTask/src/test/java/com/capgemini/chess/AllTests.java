package com.capgemini.chess;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.capgemini.chess.dataaccess.dao.impl.PlayerDaoTest;
import com.capgemini.chess.service.ServiceTestSuite;

/**
 * Class with all tests to the project.
 */
@RunWith(Suite.class)
@SuiteClasses({ ServiceTestSuite.class, PlayerDaoTest.class })
public class AllTests {

}
