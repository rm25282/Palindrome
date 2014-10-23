package com.richard;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddressBookReaderTest.class,
		CustomerAddressBookReaderTest.class, 
		CustomerLineParserTest.class,
		CustomerTest.class,
		ExportCustomerAddressBookTest.class,
		AddressBookFixerImplTest.class})
public class AllTests {

}
