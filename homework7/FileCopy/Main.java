package FileCopy;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		File file = new File("d:/�������+����.rar");
		FileCopy fc = new FileCopy();
		
		InputRun ip = new InputRun(file, fc);
		OutputRun op = new OutputRun(new File("d:/jaa/�������+����.rar"), fc);
		
		Thread tIn = new Thread(ip);
		Thread tOut = new Thread(op);
		
		tIn.start();
		tOut.start();
	}

}
