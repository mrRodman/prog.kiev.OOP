package FileCopy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputRun implements Runnable{
	private File file;
	private FileCopy fileCopy;
	private double progress;
	private long writedBytes;

	public OutputRun(File file, FileCopy fileCopy) {
		super();
		this.file = file;
		this.fileCopy = fileCopy;
		this.progress = 0.0;
		this.writedBytes = 0;
	}

	public OutputRun() {
	}
	
	@Override
	public void run() {
		writeThis(file);
		
	}
	
	private void writeThis (File file) {
		if (file == null) {
			System.err.println("File is nit exist");
			return;
		}
		
		try (FileOutputStream fos = new FileOutputStream(file)){
			for (;!fileCopy.isStop();) {
				fileCopy.checkTurnToWrite();
				byte[] buff = fileCopy.getBuffer();
				int numberOfbytes = fileCopy.getByteRead();
				fos.write(buff, 0, numberOfbytes);
				writedBytes += numberOfbytes;
				progress = (double)writedBytes / fileCopy.getFile().length();
				progress = (int)(progress * 10000);
				System.out.println("Copied " + (progress / 100) + "%");
				fileCopy.switchToRead();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Copy is finished");
		
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
