package com.richard;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class CustomerAddressBookReaderTest {

	private static final String PATH = "/home/richard/address/";

	private CustomerAddressBookReader customerAddressBookReader;
	private Customer customer;

	@Before
	public void setUp() throws Exception {
		customerAddressBookReader = new CustomerAddressBookReader();

		customer = new Customer();
		customer.setName("Bob Smith");
		customer.setFirstLineOfAddress("1, Manor Avenue");
		customer.setTown("London");
		customer.setPostCode("SE3");
		customer.setPhoneNumber("0123456678");
	}

	@Test
	public void read_Address_Book_And_Check_Correct_Customer_Record_Is_Returned() {

		Map<String, Customer> testDataCustomers = new HashMap<String, Customer>();
		testDataCustomers.put(customer.getName(), customer);

		assertTrue(
				"Customers do not match and they are supposed to!",
				compareCustomers(PATH + "addressbooktest1line.txt",
						testDataCustomers, customerAddressBookReader));
	}

	@Test
	public void read_Address_Book_And_Expect_Different_Customer_Record_to_Be_Returned() {
		// Set key to be different
		customer.setName("John Smith");

		HashMap<String, Customer> testDataCustomers = new HashMap<String, Customer>();
		testDataCustomers.put(customer.getName(), customer);

		assertFalse(
				"Customers do not match and they are supposed to!",
				compareCustomers(PATH + "addressbooktest1line.txt",
						testDataCustomers, customerAddressBookReader));
	}

	@Test
	public void read_Address_Book_And_Expect_Same_Record_Name_to_Be_Returned_but_different_Postcode() {
		// Set data to be different
		customer.setPostCode("SE2");

		HashMap<String, Customer> testDataCustomers = new HashMap<String, Customer>();
		testDataCustomers.put(customer.getName(), customer);

		assertFalse(
				"Customers do not match and they are supposed to!",
				compareCustomers(PATH + "addressbooktest1line.txt",
						testDataCustomers, customerAddressBookReader));
	}

	@Test
	public void if_customers_are_defined_on_two_lines_the_last_details_are_returned() {
		Map<String, Customer> testDataCustomers = new HashMap<String, Customer>();
		Customer secondCustomer = new Customer();

		secondCustomer = new Customer();
		secondCustomer.setName("Bob Smith");
		secondCustomer.setFirstLineOfAddress("2, Manor Avenue");
		secondCustomer.setTown("Glasgow");
		secondCustomer.setPostCode("GS2");
		secondCustomer.setPhoneNumber("987654321");

		testDataCustomers.put(customer.getName(), secondCustomer);

		assertTrue(
				"Customers do not match and they are supposed to!",
				compareCustomers(PATH + "addressbooktest2linessamekey.txt",
						testDataCustomers, customerAddressBookReader));
	}

	@Test
	public void if_customers_are_defined_on_two_lines_then_some_of_last_details_are_returned() {
		Map<String, Customer> testDataCustomers = new HashMap<String, Customer>();
		Customer secondCustomer = new Customer();

		secondCustomer = new Customer();
		secondCustomer.setName("Bob Smith");
		secondCustomer.setFirstLineOfAddress("2, Manor Avenue");
		secondCustomer.setPhoneNumber("987654321");

		testDataCustomers.put(customer.getName(), secondCustomer);

		assertTrue(
				"Customers do not match and they are supposed to!",
				compareCustomers(PATH + "addressbooktest2somelinessamekey.txt",
						testDataCustomers, customerAddressBookReader));
	}
	
	@Test
	public void if_customers_are_defined_on_partially_on_two_lines_then_some_of_last_details_are_returned() {
		Map<String, Customer> testDataCustomers = new HashMap<String, Customer>();
		Customer secondCustomer = new Customer();

		secondCustomer = new Customer();
		secondCustomer.setName("Bob Smith");
		secondCustomer.setFirstLineOfAddress("2, Manor Avenue");
		secondCustomer.setPhoneNumber("987654321");

		testDataCustomers.put(customer.getName(), secondCustomer);

		assertTrue(
				"Customers do not match and they are supposed to!",
				compareCustomers(PATH + "addressbooktestpartiallinessamekey.txt",
						testDataCustomers, customerAddressBookReader));
	}
	
	@Test
	public void if_customers_are_defined_on_partially_on_mulitple_lines_then_some_of_last_details_are_returned() {
		Map<String, Customer> testDataCustomers = new HashMap<String, Customer>();
		Customer secondCustomer = new Customer();

		secondCustomer = new Customer();
		secondCustomer.setName("Bob Smith");
		secondCustomer.setFirstLineOfAddress("2, Manor Avenue");
		secondCustomer.setTown("Glasgow");
		secondCustomer.setPostCode("GS2");
		secondCustomer.setPhoneNumber("0123456678");

		testDataCustomers.put(customer.getName(), secondCustomer);

		assertTrue(
				"Customers do not match and they are supposed to!",
				compareCustomers(PATH + "addressbooktestpartialmultiplelinessamekey.txt",
						testDataCustomers, customerAddressBookReader));
	}
	
	@Test
	public void if_multiple_customers_are_defined_on_partially_on_mulitple_lines_then_some_of_last_details_are_returned() {
		Map<String, Customer> testDataCustomers = new HashMap<String, Customer>();
		Customer secondCustomer = new Customer();

		secondCustomer = new Customer();
		secondCustomer.setName("Charlie Williams");
		secondCustomer.setFirstLineOfAddress("123 Nowhere Avenue");
		secondCustomer.setTown("Salcombe");
		secondCustomer.setPostCode("WES 5tE");
		secondCustomer.setPhoneNumber("12341234");
		
		Customer thirdCustomer = new Customer();
		thirdCustomer.setName("Joanna James");
		thirdCustomer.setFirstLineOfAddress("156, Sampson's Gardens");
		thirdCustomer.setTown("Belfast");
		thirdCustomer.setPostCode("BT7 4FS");
		thirdCustomer.setPhoneNumber("22334455");
		
		Customer fourthCustomer = new Customer();
		fourthCustomer.setName("Carl Thomas");
		fourthCustomer.setFirstLineOfAddress("15, North Passage");
		fourthCustomer.setTown("Northhampton");
		fourthCustomer.setPostCode("REW 6HY");
		fourthCustomer.setPhoneNumber("04375432786");

		testDataCustomers.put(secondCustomer.getName(), secondCustomer);
		testDataCustomers.put(thirdCustomer.getName(), thirdCustomer);
		testDataCustomers.put(fourthCustomer.getName(), fourthCustomer);

		assertTrue(
				"Customers do not match and they are supposed to!",
				compareCustomers(PATH + "addressbooktestmultiplelines.txt",
						testDataCustomers, customerAddressBookReader));
	}


	private boolean compareCustomers(String fileAndPathName,
			Map<String, Customer> testDataCustomers,
			CustomerAddressBookReader customerAddressBookReader) {
		Map<String, Customer> fileCustomers = null;

		try {
			fileCustomers = customerAddressBookReader
					.readAddressBook(fileAndPathName);
		} catch (FileNotFoundException e) {
			fail("Test file " + fileAndPathName + " not found");
		}

		if (fileCustomers.isEmpty()) {
			return false;
		}

		for (Map.Entry<String, Customer> entry : fileCustomers.entrySet()) {
			// Check to see if its in our Map
			if (testDataCustomers.get(entry.getKey()) == null) {
				System.out.println("Customers do not match each other\n\t"
						+ entry.getKey() + " is not in expected test data");

				return false;
			}

			// Compare details of two customers
			if (!compareDetailsOfTwoCustomers(
					testDataCustomers.get(entry.getKey()), entry.getValue())) {
				return false;
			}
		}

		return true;
	}

	private boolean compareDetailsOfTwoCustomers(Customer testCustomer,
			Customer fileCustomer) {
		if ((testCustomer.getFirstLineOfAddress() != null && !testCustomer
				.getFirstLineOfAddress().equals(
						fileCustomer.getFirstLineOfAddress()))
				|| (testCustomer.getTown() != null && !testCustomer.getTown()
						.equals(fileCustomer.getTown()))
				|| (testCustomer.getPostCode() != null && !testCustomer
						.getPostCode().equals(fileCustomer.getPostCode()))
				|| (testCustomer.getPhoneNumber() != null && !testCustomer
						.getPhoneNumber().equals(fileCustomer.getPhoneNumber()))) {

			System.out.println("File customer: \n" + fileCustomer.toString()
					+ "does not match \ntestDataCustomer: \n"
					+ testCustomer.toString());

			return false;
		}

		return true;
	}
}
