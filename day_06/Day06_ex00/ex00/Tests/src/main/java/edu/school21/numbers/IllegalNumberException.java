package edu.school21.numbers;

public class IllegalNumberException extends RuntimeException {
	public IllegalNumberException(String illegalNumberException){
		super("Number has to be >= 2");
	}
}
