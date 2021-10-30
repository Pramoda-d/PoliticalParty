package com.training.ratings.exceptions;

public class PoliticalLeaderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PoliticalLeaderNotFoundException() {
		super();
	}

	public PoliticalLeaderNotFoundException(String message) {
		super(message);
	}

}
