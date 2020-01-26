package com.heroku.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileAction {

	File fileObj = null;

	public File CreateNewFile(String location, String nameWithExtention) {

		try {

			location = location.replace("\\", File.separator);
			location = location.replace("/", File.separator);
			location += File.separator + nameWithExtention;
			// Creating an object of a file

			fileObj = new File(location);
			if (this.fileObj.createNewFile()) {
				System.out.println("File created: " + fileObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return fileObj;
	}

	public File OpenExistingFile(String filePath) {
		this.fileObj = new File(filePath);
		if (this.fileObj.exists()) {
			System.out.println("File Opened Successfully!!");
		} else {
			System.out.println("Unable to find the existance of file");
		}

		return this.fileObj;
	}

	public void writeToFile(String data) {

		try {

			if (this.fileObj == null) {
				System.out.println("Please Open Or Create New File");
				return;
			} else if (this.fileObj.canWrite() == false) {
				System.out.println("File is Read-only Unable to write data");
			}

			FileWriter myWriter = new FileWriter(this.fileObj);
			myWriter.write(data);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred. ");
			e.printStackTrace();
		}

	}

	public String ReadFile() {
		String data = "";
		try {
			if (this.fileObj.canRead() == false) {
				System.out.println("Unable to read.");
				return null;
			}
			Scanner myReader = new Scanner(this.fileObj);
			while (myReader.hasNextLine()) {
				data += myReader.nextLine();
			}
			myReader.close();
//			System.out.println(data);
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return data;
	}

	public void appendDataToFile(String dataToBeAppend) {

		dataToBeAppend = ReadFile() + dataToBeAppend;
		writeToFile(dataToBeAppend);
	}

}
