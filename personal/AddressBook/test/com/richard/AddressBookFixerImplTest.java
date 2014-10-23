package com.richard;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressBookFixerImplTest {
	
	private static final String INPUTFILE = "/home/richard/address/addressbook.txt";
	private static final String OUTPUTFILE = "/home/richard/address/fixedaddressbook.txt";

	@Before
	public void setUp() {
		File outputFile = new File(OUTPUTFILE);
		outputFile.delete();
	}

	@Test
	public void processFileCorrectlyCreateExportFile() {

		
		AddressBookFixer addressBookFixer = new AddressBookFixerImpl();
		addressBookFixer.fixAddressBook(INPUTFILE, OUTPUTFILE);
		
		File f = new File(OUTPUTFILE);
		Assert.assertTrue(f.exists() && !f.isDirectory());
	}
	
	@Test 
	public void incorrectInputFileNamesDoesntCreateOutPutFile() {
		AddressBookFixer addressBookFixer = new AddressBookFixerImpl();
		addressBookFixer.fixAddressBook(null, OUTPUTFILE);
		
		File f = new File(OUTPUTFILE);
		Assert.assertFalse(f.exists() && !f.isDirectory());
	}

	@Test
	public void incorrectOutputFileNamesDoesntCreateOutPutFile() {
		AddressBookFixer addressBookFixer = new AddressBookFixerImpl();
		addressBookFixer.fixAddressBook("dummy.txt", null);
		
		File f = new File(OUTPUTFILE);
		Assert.assertFalse(f.exists() && !f.isDirectory());
	}
}
