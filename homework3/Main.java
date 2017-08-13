
public class Main {

	public static void main(String[] args) {
		Group group = new Group();
		group.addStudent(new Student("qwe", 42));
		group.addStudent(new Student("fsa", 24));
		group.addStudent(new Student("asd", 35));
		group.addStudent(new Student("sdf", 34));
		group.addStudent(new Student("cvb", 42));
		group.addStudent(new Student("jkl", 111));
		group.addStudent(new Student("bn", 35));
		group.addStudent(new Student("iou", 222));
		group.addStudent(new Student("zxc", 42));
		group.addStudent(new Student("iuop", 24));
		group.addStudent(new Student("vb", 35));

		group.removeStudentByIndex(5);

		System.out.println(group.searchStudentByName("iou"));
		System.out.println(group.searchStudentByName("33"));
		System.out.println(group.toString());
	}
}
