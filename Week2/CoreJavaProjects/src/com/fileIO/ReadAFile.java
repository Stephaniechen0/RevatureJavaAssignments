package com.fileIO;

import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadAFile {

	public static void main(String[] args) throws IOException {
		try (FileInputStream fis = new FileInputStream("testfile.txt"); 
				BufferedInputStream bis = new BufferedInputStream(fis)) {
			
			while (bis.available() > 0) {
				System.out.print((char) bis.read());
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
