import java.io.File;

public class PackageCheck implements Runnable{
	File file;	

	public PackageCheck(File file) {
		super();
		this.file = file;
	}

	public PackageCheck(){
		
	}
	
	private void packageCheck(File file) {
		try {
			if (file == null) {
				throw new NullPointerException();
			} 
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		String[] oldList = file.list();
		
		try {
			Thread.currentThread().sleep(1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String[] newList = file.list();
		listCompare(oldList, newList);
		
		for (int i = 0; i < oldList.length; i++) {
			if (oldList[i] != "") {
				System.out.println(oldList[i] + " has been deleted");
			}
		}
		for (int i = 0; i < newList.length; i++) {
			if (newList[i] != "") {
				System.out.println(newList[i] + " has been added");
			}
		}
	}
	
	private void listCompare (String[] oldList, String[] newList) {
		for (int i = 0; i < oldList.length; i++) {
			for (int j = 0; j < newList.length; j++) {
				if (oldList[i].equals(newList[j])) {
					oldList[i] = "";
					newList[j] = "";
				}
			}
		}
	}

	@Override
	public void run() {
		for(;true;) {
			packageCheck(this.file);
		}
	}
	
	

}
