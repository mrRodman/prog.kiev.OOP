package runnableFilesCopy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesCopy implements Runnable {
	private String[] sources;
	private String target;
	
	public FilesCopy(String[] sources, String target) {
		super();
		this.sources = sources;
		this.target = target;
	}

	public FilesCopy() {
		super();
		}
	
	private void copy (String[] source, String target) {
		try {
			for (int i = 0; i < source.length; i++) {
				Path src = Paths.get(source[i]);
				
				if (!src.toFile().isDirectory()) {
					Path trgt = Paths.get(target + "/" + src.getFileName());
					Files.createDirectories(trgt);
					Files.copy(src, trgt, 
							StandardCopyOption.REPLACE_EXISTING);
				} else {
					Files.createDirectories(Paths.get(target +  "/" + source[i].substring(source[i].lastIndexOf('/'))));
					FileCopyCotrol.copyFiles(source[i], target +  "/" + source[i].substring(source[i].lastIndexOf('/')));
				} 
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		copy(sources, target);		
	}
}
