package com.capgemini.chess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Chess application launcher.
 */
@EnableScheduling
@SpringBootApplication
public class ChessApplication {

	/**
	 * Main function of the application.
	 * 
	 * @param arg
	 *            arguments
	 */
	public static void main(final String[] args) {
		SpringApplication.run(ChessApplication.class, args);
	}
}
