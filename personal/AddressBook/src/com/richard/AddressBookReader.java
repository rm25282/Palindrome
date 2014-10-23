package com.richard;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class reads an address book and returns an 
 * ArrayList of Strings to be parsed.
 */
public class AddressBookReader {

	/**
	 * Read the input file of customer data.
	 *
	 * @param filePathAndName the file path and name
	 * @return ArrayList of Strings which can then be parsed
	 * @throws FileNotFoundException the file not found exception
	 */
	public final ArrayList<String> readFile(final String filePathAndName)
			throws FileNotFoundException {
		if (filePathAndName == null) {
			throw new FileNotFoundException(filePathAndName);
		}

		ArrayList<String> lines = new ArrayList<String>();

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePathAndName));
		} catch (FileNotFoundException e1) {
			System.out.println("File: " + filePathAndName
					+ " has not been found");
			e1.printStackTrace();
			throw new FileNotFoundException("File: " + filePathAndName
					+ " has not been found");
		}

		try {
			while (reader.ready()) {
				lines.add(reader.readLine());
			}
		} catch (IOException e) {
			System.out.println("IOException reading file: " + filePathAndName);
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("Error closing file " + filePathAndName);
					e.printStackTrace();
				}
			}
		}

		return lines;
	}
}
