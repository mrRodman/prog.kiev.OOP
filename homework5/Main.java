import java.io.*;

public class Main {

	public static void main(String[] args) {
//		File in = new File("E:/Download/Iron Maiden - The Book of Souls (2015)/Disc 1/");
//		File out = new File("E:/Java/");
//		try {
//			FileOperations.copyWithSomeExtension(in, out, "mp3");
//		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}

		File in1 = new File("E:/1.txt");
		File in2 = new File("E:/2.txt");
		File out1= new File("E:/3.txt");

		try {
			Dublicates.getDublicates(in1, in2, out1);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
