package runnableFilesCopy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileCopyCotrol {

	public FileCopyCotrol() {
		// TODO Auto-generated constructor stub
	}

	public static String[] getAbsoluteSources(String source) {
		String[] fileList = Paths.get(source).toFile().list();
		String[] absoluteSources = new String[fileList.length];
		
		for (int i = 0; i < absoluteSources.length; i++) {
			absoluteSources[i] = Paths.get(source).toFile().getAbsolutePath() + "/" + fileList[i];
		}
		
		return absoluteSources;
	}
	
	
	public static String getAbsoluteTarget(String target) {
		return Paths.get(target).toFile().getAbsolutePath();
	}
	
	public static void copyFiles(String source, String target) {
		File src = new File(source);
		try {
			if (source == null || !src.exists()) {
				throw new NullPointerException("no SOURCE");
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		if (!src.isDirectory()) {
			try {
				Files.copy(Paths.get(source), Paths.get(target));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int numberOfParts = 4;
		FilesCopy[] operatins = makeFilesCopyParts(getAbsoluteSources(source),
				getAbsoluteTarget(target), numberOfParts);
		
		generateThreads(operatins);
		
	}
	
	private static FilesCopy[] makeFilesCopyParts(String[] sources, String target, int numberOfParts) {
		FilesCopy[] parts = new FilesCopy[numberOfParts];
		String[][] sourcesParts = dividePathArray(sources, numberOfParts);
		
		for (int i = 0; i < sourcesParts.length; i++) {
			parts[i] = new FilesCopy(sourcesParts[i], target);
		}
		return parts;
	}	
	
	private static String[][] dividePathArray(String[] array, int numberOfParts) {
		String[][] parts = new String[numberOfParts][];
		for (int i = 0; i < parts.length; i++) {
			parts[i] = Arrays.copyOfRange(array, (array.length * i) /numberOfParts, (array.length * (i + 1)) / numberOfParts);
		}
		return parts;
	}
	
	
	
	private static void generateThreads(Runnable[] parts) {
        Thread[] threads = new Thread[parts.length];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(parts[i]);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        try {
            for (int i = 0; i < threads.length; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
