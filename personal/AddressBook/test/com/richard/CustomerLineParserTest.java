package com.richard;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerLineParserTest {

	private static final String line = "Bob Smith#1|1, Manor Avenue#2|London#3|SE3#4|0123456678";
	private static final String emptyLine = "";
	private static final String addressMissingLine = "Bob Smith#2|London#3|SE3#4|0123456678";
	private static final String townMissingLine = "Bob Smith#1|1, Manor Avenue#3|SE3#4|0123456678";
	private static final String postCodeMissing = "Bob Smith#1|1, Manor Avenue#2|London#4|0123456678";
	private static final String phoneNumberMissing = "Bob Smith#1|1, Manor Avenue#2|London#3|SE3";
	
	private CustomerLineParser clp;
	private CustomerLineParser emptyClp;

	@Before
	public void setUp() throws Exception {
		clp = new CustomerLineParser();
		clp.parseLine(line);
		emptyClp = new CustomerLineParser();
		emptyClp.parseLine(emptyLine);
	}

	@Test
	public void parseLineForCustomerName() {
		assertEquals("Bob Smith", clp.getCustomerName());
	}

	@Test
	public void checkForNullWhenCustomerNameMissing() {
		assertEquals(null, emptyClp.getCustomerName());
	}

	@Test
	public void parseLineForCustomerDetails() {
		assertEquals("1|1, Manor Avenue#2|London#3|SE3#4|0123456678",
				clp.parseLineForCustomerDetails());
	}

	@Test
	public void checkForNullWhenCustomerDetailsMissing() {
		assertEquals(null, emptyClp.parseLineForCustomerDetails());
	}

	@Test
	public void getFirstLineOfAddressFromLine() {
		assertEquals("1, Manor Avenue", clp.getFirstLineOfAddress());
	}

	@Test
	public void checkForNullWhenAddressMissing() {
		CustomerLineParser addressMissingClp = new CustomerLineParser();
		addressMissingClp.parseLine(addressMissingLine);
		assertEquals(null, addressMissingClp.getFirstLineOfAddress());
	}

	@Test
	public void getTownFromLine() {
		assertEquals("London", clp.getTownFromLine());
	}
	
	@Test
	public void checkForNullWhenTownMissing() {
		CustomerLineParser townMissingClp = new CustomerLineParser();
		townMissingClp.parseLine(townMissingLine);
		assertEquals(null, townMissingClp.getTownFromLine());
	}

	@Test
	public void getPostCodeLine() {
		assertEquals("SE3", clp.getPostCodeFromLine());
	}
	
	@Test
	public void checkForNullWhenPostCodeMissing() {
		CustomerLineParser postCodeMissingClp = new CustomerLineParser();
		postCodeMissingClp.parseLine(postCodeMissing);
		assertEquals(null, postCodeMissingClp.getPostCodeFromLine());
	}

	@Test
	public void getPhoneNumberFromLine() {
		assertEquals("0123456678", clp.getPhoneNumberFromLine());
	}
	
	@Test
	public void checkForNullWhenPhoneNumberMissing() {
		CustomerLineParser phoneNumberMissingClp = new CustomerLineParser();
		phoneNumberMissingClp.parseLine(phoneNumberMissing);
		assertEquals(null, phoneNumberMissingClp.getPhoneNumberFromLine());
	}
	
	@Test (expected = NotParsedException.class)
	public void ifPostCodeLineNotParsedThrowNotParsedException() {
		CustomerLineParser haventParsed = new CustomerLineParser();
		haventParsed.getPostCodeFromLine();
	}
	
	@Test (expected = NotParsedException.class)
    public void ifAddressLineNotParsedThrowNotParsedException() {
        CustomerLineParser haventParsed = new CustomerLineParser();
        haventParsed.getFirstLineOfAddress();
    }
	
	@Test (expected = NotParsedException.class)
    public void ifPhoneLineNotParsedThrowNotParsedException() {
        CustomerLineParser haventParsed = new CustomerLineParser();
        haventParsed.getPhoneNumberFromLine();
    }
	
	@Test (expected = NotParsedException.class)
    public void ifTownLineNotParsedThrowNotParsedException() {
        CustomerLineParser haventParsed = new CustomerLineParser();
        haventParsed.getTownFromLine();
    }
}
