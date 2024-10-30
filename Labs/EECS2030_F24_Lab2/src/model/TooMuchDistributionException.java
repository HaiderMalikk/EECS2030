package model;

public class TooMuchDistributionException extends Exception {
	public TooMuchDistributionException(String message) {
		super(message); // super is used to call the constructor of the parent class
	}
}
