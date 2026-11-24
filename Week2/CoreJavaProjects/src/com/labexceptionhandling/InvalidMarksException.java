package com.labexceptionhandling;

public class InvalidMarksException extends RuntimeException {
	public InvalidMarksException(String message) {
		super(message);
	}
}
