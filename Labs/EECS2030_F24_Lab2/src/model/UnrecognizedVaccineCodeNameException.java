package model;

public class UnrecognizedVaccineCodeNameException extends Exception {
	public UnrecognizedVaccineCodeNameException(String message) {
		super(message); // super is used to call the constructor of the parent class
	}
}
