package Exceptions;

public class TooManyStudents extends Exception {
	public void printMessage() {
		System.err.println("Too Many Students!");
	}
}
