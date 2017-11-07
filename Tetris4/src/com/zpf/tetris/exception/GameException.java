package com.zpf.tetris.exception;

/* RuntimeException to deal with exception occur in running */
public class GameException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1942980183235776889L;

	public GameException(String mess) {
		super(mess);
	}
}
