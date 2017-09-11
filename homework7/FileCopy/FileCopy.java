package FileCopy;

import java.io.File;

public class FileCopy {
	private File file;
	private boolean turn = false;
	private byte[] buffer;
	private boolean stop = false;;
	private int byteRead;
	
	public FileCopy() {
		// TODO Auto-generated constructor stub
	}
	
	public synchronized void checkTurnToRead() {
		for(;turn == true;) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void fileRead(byte[] buf, int byteRead) {
		
		this.buffer = buf;
		this.byteRead = byteRead;
		turn = true;
		notifyAll();
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	public synchronized void checkTurnToWrite() {
		for (;turn == false;) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int getByteRead() {
		
		return byteRead;
	}
	
	public synchronized void switchToRead() {
		turn = false;
		notifyAll();
	}

	public byte[] getBuffer() {
		
		return buffer;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}
	
	
}
