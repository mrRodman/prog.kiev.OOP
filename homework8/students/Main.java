package students;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		Group group = new Group();
		group.addStudent(new Student("asd", 20, 4.0));
		group.addStudent(new Student("qwe", 24, 5.0));
		group.addStudent(new Student("fgh", 36, 3.0));
		
		File outStudent = new File("d:/1.xls");
		try {
			FileOperationWithStudents.wirteGroupToFile(outStudent, group);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		group.groupFlush();
		File inStudent = new File("d:/1.xls");
		try {
			group = FileOperationWithStudents.readGroupFromFile(inStudent, group);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(group.toString());

	}

}
