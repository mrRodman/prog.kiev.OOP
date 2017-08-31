package runnableFilesCopy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println();
		FileCopyCotrol.copyFiles("d:/Новая папка (3)/", "d:/jaa");
	}

}
