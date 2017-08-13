
public class Student extends Human {

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, \n age()=%s] \n", getName(), getAge());
	}

	
}
