package students;

import java.io.Serializable;

public class Student extends Human implements Serializable {

	private double rating;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(String name, int age, double rating) {
		super(name, age);
		this.rating = rating;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\n", this.getName(), this.getAge(), this.getRating());
	}
}