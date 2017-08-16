
public class Student extends Human {

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
		return "Student{"+  super.getName() + " age " + super.getAge() +
				" rating=" + rating +
				'}';
	}
}
