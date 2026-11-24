package com.fileIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteInAFile {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("testfile.txt");
			String toWrite = "Hellooo...";
			fos.write(toWrite.getBytes());
			System.out.println("Content written");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fos.close();	
			System.out.println("Closed");
		}

	}

}
