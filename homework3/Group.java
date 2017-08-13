import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import Exceptions.NameIsNotFound;
import Exceptions.TooManyStudents;

public class Group {
	private Student[] group;

	public Group() {
		super();
		this.group = new Student[10];
		// TODO Auto-generated constructor stub
	}
	
	public void addStudent(Student student) {
		try {
			for (int i = 0; i < group.length; i++) {
				if (group[i] == null) {
					group[i] = student;
					return;
				}
			}
			throw new TooManyStudents();
		} catch (TooManyStudents e) {
			e.printMessage();
		}
	}
	
	public void removeStudentByIndex (int index) {
		if (group[index] == null)
			System.err.println("This place is already empty!");
		else
			group[index] = null;
	}

	/**
	 *
	 * returns place with requested name
	 * if name is not found return -1
	 *
	 */
	
	public int searchStudentByName (String name) {
		try {
			for (int i = 0; i < group.length; i++) {
				if (group[i] == null)
					continue;

				if (group[i].getName() == null) {
					continue;
				}

				if (group[i].getName().equals(name))
					return i;
			}
			throw new NameIsNotFound();
		} catch (NameIsNotFound e) {
			e.printMessage();
			return -1;
		}
	}

	@Override
	public String toString() {
		ArrayList<Student> temp = new ArrayList<>();

		for (int i = 0; i < group.length; i++) {
			if (group[i] != null)
				temp.add(group[i]);
		}
		Student[] groupToPrint = new Student[temp.size()];
		for (int i = 0; i < temp.size(); i++) {
			groupToPrint[i] = temp.get(i);
		}
		Arrays.sort(groupToPrint, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}
		} );
		
		StringBuilder listOfStudents = new StringBuilder();
		
		for (int i = 0; i < groupToPrint.length; i++) {
			listOfStudents.append(groupToPrint[i].getName());
			listOfStudents.append('\n');
		}
		return listOfStudents.toString();
	}
}
