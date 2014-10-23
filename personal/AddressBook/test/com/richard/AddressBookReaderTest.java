package com.richard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class AddressBookReaderTest {
	private static final String PATH = "/home/richard/address/";
	
	private static final String line = "Bob Smith#1|1, Manor Avenue#2|London#3|SE3#4|0123456678";
	
	@SuppressWarnings("serial")
	private static final ArrayList<String> fiveLines = new ArrayList<String>() {{
		add("Bob Smith#1");
		add("1, Manor Avenue#2|London#3|SE3#4|0123456678");
		add("2|London#3|SE3#4|0123456678");
		add("3|SE3#4|0123456678");
		add("4|0123456678");
	}};
	
	private AddressBookReader addressBookReader;

	@Before
	public void setUp() throws Exception {
		addressBookReader = new AddressBookReader();
	}

	@Test
	public void open_File_And_Read_File_With_Only_One_Line() {
		try {
			assertEquals(
					line,
					addressBookReader.readFile(
							PATH + "addressbooktest1line.txt")
							.get(0));
		} catch (FileNotFoundException e) {
			fail("Test file " + PATH + "addressbooktest1line.txt" + " not found");
		}
	}

	@Test
	public void open_Empty_File_And_Attempt_To_Read_All_Lines() {
		try {
			assertTrue(addressBookReader
					.readFile(PATH + "addressbooktestempty.txt").isEmpty());
		} catch (FileNotFoundException e) {
			fail("Test file " + PATH + "addressbooktestempty.txt" + " not found");
		}
	}

	@Test (expected = FileNotFoundException.class)
	public void attempttoOpenFileNotPresent() throws FileNotFoundException {
		addressBookReader
					.readFile(PATH + "addressbooktestXXX.txt");
	}
	
	@Test
	public void open_File_And_Read_File_With_5_Lines() {
		try {
			assertEquals(fiveLines, addressBookReader
					.readFile(PATH + "addressbooktestfivelines.txt"));
		} catch (FileNotFoundException e) {
			fail("Test file " + PATH + "addressbooktestfivelines.txt" + " not found");
		}
	}

	@Test (expected = FileNotFoundException.class)
	public void throwsExceptionWhenPassinginNullForFilePathName() throws FileNotFoundException {
		addressBookReader.readFile(null);
	}
	
}
