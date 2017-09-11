package FileCopy;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		File file = new File("d:/Εκηΰμεν+ηΰλ³κ.rar");
		FileCopy fc = new FileCopy();
		
		InputRun ip = new InputRun(file, fc);
		OutputRun op = new OutputRun(new File("d:/jaa/Εκηΰμεν+ηΰλ³κ.rar"), fc);
		
		Thread tIn = new Thread(ip);
		Thread tOut = new Thread(op);
		
		tIn.start();
		tOut.start();
	}

}
