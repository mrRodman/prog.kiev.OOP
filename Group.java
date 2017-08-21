package students;

import students.Exceptions.NameIsNotFound;
import students.Exceptions.TooManyStudents;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Group implements Sorting, Voenkom{
	private Student[] group;

	public Group() {
		super();
		this.group = new Student[10];
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

	public void addStudent() {
		System.out.println("Enter student's name, age and rating");
		Scanner sn = new Scanner(System.in);
		while (true) {
			try {
				String line = sn.nextLine();

				String[] temp = line.split(" ");
				String name = temp[0];
				int age = Integer.parseInt(temp[1]);
				double rating = Double.parseDouble(temp[2]);
				this.addStudent(new Student(name, age, rating));
				break;
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
				System.out.println("Wrong number. Try again");
			}
		}
	}
	
	public void removeStudentByIndex (int index) {
		try {
			if (group[index] == null)
				System.err.println("This place is already empty!");
			else
				group[index] = null;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Not valid index");
		}
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
	public void sortBy(int i) {
		GroupSort groupSort = new GroupSort();
		System.out.println("1 - sort by name, 2 - sort by age, 3 - sort by rating");
		switch(i) {
			case 1:
				groupSort.sortByName();
				break;
			case 2:
				groupSort.sortByAge();
				break;
			case 3:
				groupSort.sortByRating();
				break;
			default :
				System.out.println("Not valid number!");
		}
	}

	private class GroupSort {
		private void sortByName() {
			Arrays.sort(group, (Student o1, Student o2) ->
					 Sorting.nullCheck(o1, o2) != Sorting.NOT_NULL ?
							Sorting.nullCheck(o1, o2) : o1.getName().compareTo(o2.getName())

			);
		}

		private void sortByAge() {
			Arrays.sort(group, (Student o1, Student o2) ->
					Sorting.nullCheck(o1, o2) != Sorting.NOT_NULL ?
							Sorting.nullCheck(o1, o2) : o1.getAge() - o2.getAge()
			);
		}

		private void sortByRating() {
			Arrays.sort(group, new Comparator<Student>() {

				@Override
				public int compare(Student o1, Student o2) {
					// TODO Auto-generated method stub
					return Sorting.nullCheck(o1, o2) != Sorting.NOT_NULL ?
							Sorting.nullCheck(o1, o2) : doubleCheck(o1.getRating(), o2.getRating());
				}

				private int doubleCheck(double d1, double d2){
					if (d1 > d2) {
						return 1;
					}
					if (d1 < d2) {
						return -1;
					}
					return 0;
				}
			});
		}
	}

	@Override
	public Student[] potentialPrivates() {
		Group privates = new Group();
		for (Student student : group) {
			if (student == null)
				continue;

			if (student.getAge() > 18)
				privates.addStudent(student);
		}
		return privates.getGroup();
	}

	public void saveGroupToFile(File out) throws IOException {
		FileOperationWithStudents.wirteGroupToFile(out, this);
	}

	public void receiveGroupFromFile(File in) throws IOException {
		FileOperationWithStudents.readGroupFromFile(in, this);
	}

	public void groupFlush() {
		for(int i = 0; i < this.group.length; i++) {
			if(this.group[i] != null) {
				this.group[i] = null;
			}
		}

	}

	@Override
	public String toString() {
		return "students.Group{" +
				"group\n" + Arrays.toString(group) +
				'}';
	}

	public Student[] getGroup() {
		return group;
	}
}
