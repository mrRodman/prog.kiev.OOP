
public class Main {

	public static void main(String[] args) {
		Group group = new Group();
		group.addStudent();
		group.addStudent();
		group.addStudent();

		group.sortBy(1);
		System.out.println(group);
		group.sortBy(2);
		System.out.println(group);
		group.sortBy(3);
		System.out.println(group);
		System.out.println();

		VoenkomMan voenkomMan = new VoenkomMan();
		voenkomMan.getPrivates(group);
	}
}
