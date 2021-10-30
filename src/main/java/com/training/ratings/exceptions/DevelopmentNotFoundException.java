package com.training.ratings.exceptions;

public class DevelopmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DevelopmentNotFoundException() {
		super();
	}

	public DevelopmentNotFoundException(String message) {
		super(message);
	}

}
