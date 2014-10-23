package com.richard;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	private Customer customer = null;
	
	@Before
	public void setUp() throws Exception {
		customer = new Customer();
	}

	@Test
	public void setGetNameOfCustomer() {
		customer.setName("Bob");
		assertEquals("Bob", customer.getName());
	}

	@Test
	public void setGetFirstLineOfAddress() {
		customer.setFirstLineOfAddress("86 Belfast Road");
		assertEquals("86 Belfast Road", customer.getFirstLineOfAddress());
	}

	@Test
	public void setGetTown() {
		customer.setTown("Belfast");
		assertEquals("Belfast", customer.getTown());
	}
	
	@Test
	public void setGetPostCode() {
		customer.setPostCode("BT4 6FG");
		assertEquals("BT4 6FG", customer.getPostCode());
	}
	
	@Test
	public void setGetPhoneNumber() {
		customer.setPhoneNumber("+44345234567");
		assertEquals("+44345234567", customer.getPhoneNumber());
	}
}
