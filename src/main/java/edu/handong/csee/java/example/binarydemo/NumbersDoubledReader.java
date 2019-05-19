package edu.handong.csee.java.example.binarydemo;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class NumbersDoubledReader {
	private ObjectInputStream inputStream = null;
	Scanner keyboard = null;
	
	public static void main(String[] args) {
		
		NumbersDoubledReader ndr = new NumbersDoubledReader();
		ndr.run();
		
	}

	public void run() {
		keyboard = new Scanner(System.in);
		connectToInputFile();
		keyboard.close();
		readfile();
		closeFiles();
		System.out.println("Numbers from input file");
		
	}
	public void closeFiles() {
		try {
			inputStream.close();
		} catch (IOException e) {
			System.out.println("Error closing files " + e.getMessage());
			System.exit(0);
		}		
	}

	public void readfile() {
		try {
			while(true) {
				int next = inputStream.readInt();
				System.out.println(next);
			}
		} catch(EOFException e) {
			
		} catch(IOException e) {
			System.out.println("Error: reading or writing files.");
			System.exit(0);
		}
	}

	public void connectToInputFile() {
		String inputFileName = getFileName("Enter name of input file:");
		try {
			inputStream = new ObjectInputStream(
					new FileInputStream(inputFileName));
		} catch(FileNotFoundException e) {
			System.out.println("File " + inputFileName + " not found.");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("Error opening input file: " + inputFileName);
		}
	}

	private String getFileName(String prompt) {
		String fileName = null;
		System.out.println(prompt);
		fileName = keyboard.nextLine();
		
		return fileName;
	}
}
