import java.io.File;

public class Main {

	public static void main(String[] args) {
		File file = new File("d:/jaa");
		PackageCheck check = new PackageCheck(file);
		
		Thread thread = new Thread(check);
		
		thread.start();
	}

}
