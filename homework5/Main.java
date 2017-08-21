import java.io.*;

public class Main {

	public static void main(String[] args) {
		File in = new File("E:/Download/Iron Maiden - The Book of Souls (2015)/Disc 1/");
		File out = new File("E:/Java/");
		try {
			FileOperations.copyWithSomeExtension(in, out, "mp3");
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		File in1 = new File("E:/1.txt");
		File in2 = new File("E:/2.txt");
		File out1= new File("E:/3.txt");

		try {
			Dublicates.getDublicates(in1, in2, out1);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		Group group = new Group();
		group.addStudent(new Student("asd", 20, 4.0));
		group.addStudent(new Student("qwe", 24, 5.0));
		group.addStudent(new Student("fgh", 36, 3.0));
		
		File outStudent = new File("e:/1.xls");
		try {
			group.saveGroupToFile(outStudent);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		group.groupFlush();
		File inStudent = new File("e:/1.xls");
		try {
			group.receiveGroupFromFile(inStudent);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(group.toString());
	}
}
