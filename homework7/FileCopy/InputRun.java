package FileCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InputRun implements Runnable{
	private File file;
	FileCopy fileCopy;

	public InputRun(File file, FileCopy fIleCopy) {
		super();
		this.file = file;
		this.fileCopy = fIleCopy;
	}

	public InputRun() {
	}
	
	
	
	@Override
	public void run() {
		fileCopy.setFile(file);
		readThis(file);
		
		fileCopy.checkTurnToRead();
		fileCopy.setStop(true);
		
	}

	private void readThis(File file) {
		if (file == null) {
			System.err.println("File is nit exist");
			return;
		}
		
		byte[] buffer = new byte[1024 * 1024 * 10];
		
		try (FileInputStream fis = new FileInputStream(file)){
			int byteRead = 0;
			for(;(byteRead = fis.read(buffer)) > 0;) {
				fileCopy.checkTurnToRead();
				fileCopy.fileRead(buffer, byteRead);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public FileCopy getfIleCopy() {
		return fileCopy;
	}

	public void setfIleCopy(FileCopy fIleCopy) {
		this.fileCopy = fIleCopy;
	}

}
