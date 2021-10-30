package com.training.ratings.exceptions;

public class PoliticalPartyNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PoliticalPartyNotFoundException() {
		super();
	}

	public PoliticalPartyNotFoundException(String message) {
		super(message);
	}

}
