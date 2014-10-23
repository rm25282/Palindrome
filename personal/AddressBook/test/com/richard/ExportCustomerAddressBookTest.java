package com.richard;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ExportCustomerAddressBookTest {

	private static final String BOB_SMITH_DATA = "Bob Smith#1|1, Manor Avenue#2|London#3|SE3#4|0123456678";
	private static final String CARL_THOMAS_DATA = "Carl Thomas#1|15, North Passage#2|Northhampton#3|REW 6HY#4|04375432786";
	private static final String JOANNA_JAMES_DATA = "Joanna James#1|156, Sampson's Gardens#2|Belfast#3|BT7 4FS#4|22334455";
	private static final String CHARLIE_WILLIAMS_DATA = "Charlie Williams#1|123 Nowhere Avenue#2|Salcombe#3|WES 5tE#4|12341234";
	private static final String PATH = "/home/richard/address/";

	@Test
	public void createFileFromFileWithOneLineData() {
		String exportedFilePathAndName = PATH + "ExportedCustomerAddress.txt";
		ExportCustomerAddressBook exportCustomerAddressBook = new ExportCustomerAddressBook(
				exportedFilePathAndName);

		CustomerAddressBookReader customerAddressBookReader = new CustomerAddressBookReader();

		String importedFilePathAndName = PATH + "addressbooktest1line.txt";
		Map<String, Customer> customers = null;
		try {
			customers = customerAddressBookReader
					.readAddressBook(importedFilePathAndName);
		} catch (FileNotFoundException e1) {
			fail("Exception reading import file: " + importedFilePathAndName);
		}

		try {
			exportCustomerAddressBook.exportFileFromCustomerData(customers);
		} catch (IOException e) {
			fail("Exception creating export file");
		}

		List<String> list = new ArrayList<String>();
		list.add(BOB_SMITH_DATA);

		checkFile(exportedFilePathAndName, list);
	}

	@Test
	public void createFileFromFileWithManyLinesOfData() {
		String exportedFilePathAndName = PATH + "ExportedCustomerAddress.txt";
		ExportCustomerAddressBook exportCustomerAddressBook = new ExportCustomerAddressBook(
				exportedFilePathAndName);

		CustomerAddressBookReader customerAddressBookReader = new CustomerAddressBookReader();

		String importedFilePathAndName = PATH
				+ "addressbooktestmultiplelines.txt";
		Map<String, Customer> customers = null;
		try {
			customers = customerAddressBookReader
					.readAddressBook(importedFilePathAndName);
		} catch (FileNotFoundException e1) {
			fail("Exception reading import file: " + importedFilePathAndName);
		}

		try {
			exportCustomerAddressBook.exportFileFromCustomerData(customers);
		} catch (IOException e) {
			fail("Exception creating export file");
		}

		List<String> list = new ArrayList<String>();
		list.add(CHARLIE_WILLIAMS_DATA);
		list.add(JOANNA_JAMES_DATA);
		list.add(CARL_THOMAS_DATA);

		checkFile(exportedFilePathAndName, list);
	}

	@Test(expected = FileNotFoundException.class)
	public void fileNameAndPathNullthrowsFileNotFoundException()
			throws IOException {
		ExportCustomerAddressBook exportCustomerAddressBook = new ExportCustomerAddressBook(
				null);
		exportCustomerAddressBook.exportFileFromCustomerData(null);
	}
	
	@Test
	public void customerNullGivesNoExportFile()
			throws IOException {
		
		File f = new File(PATH + "nothere.txt");
		f.delete();
		
		ExportCustomerAddressBook exportCustomerAddressBook = new ExportCustomerAddressBook(
				PATH + "addressbooktest1line.txt");
		exportCustomerAddressBook.exportFileFromCustomerData(null);
		
		assertTrue(!f.exists());
	}

	private void checkFile(String filePathAndName, List<String> contents) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePathAndName));
			readFileLineByLineAndCheckContents(filePathAndName, reader,
					contents);
		} catch (FileNotFoundException e1) {
			System.out.println("File: " + filePathAndName
					+ " has not been found");
			e1.printStackTrace();
			fail("File: " + filePathAndName + " cannot be read or is not found");
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
	}

	private void readFileLineByLineAndCheckContents(String filePathAndName,
			BufferedReader reader, List<String> contents) {
		try {

			int numberOfLinesInFile = 0;
			int numberOfLinePassedIn = contents.size();

			while (reader.ready()) {
				String line = reader.readLine();
				numberOfLinesInFile++;
				if (!contents.remove(line)) {
					System.out.print("Expected data: \n" + contents
							+ "\nActual Contents: \n" + line);
					fail("Contents of File are not what is expected!");
				}
			}

			if (numberOfLinesInFile != numberOfLinePassedIn) {

				fail("Contents of File are not what is expected!\n Number of lines in file "
						+ numberOfLinesInFile
						+ "Number of line passed in:"
						+ numberOfLinePassedIn);
			}
		} catch (IOException e) {
			System.out.println("IOException reading file: " + filePathAndName);
			e.printStackTrace();
		}
	}

}
