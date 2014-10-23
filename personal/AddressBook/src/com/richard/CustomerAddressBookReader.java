package com.richard;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class constructs an AddressBookeReader class which reads in the address
 * book.
 * 
 * The class then parses each of the lines in the file for the customer data.
 * 
 * It either - creates new customer record or - updates existing customer data
 * with the new data found
 * 
 * The class returns a Map of the customer data.
 */
public class CustomerAddressBookReader {

    /**
     * Read address book.
     *
     * @param filePathAndName
     *            the file path and name of the input file
     * @return Map of Customers
     * @throws FileNotFoundException
     *             input file not found
     */
    public final Map<String, Customer> readAddressBook(
            final String filePathAndName) throws FileNotFoundException {
        AddressBookReader addressBookReader = new AddressBookReader();
        ArrayList<String> lines = addressBookReader.readFile(filePathAndName);

        Map<String, Customer> customers = new HashMap<String, Customer>();
        CustomerLineParser customerLineParser = new CustomerLineParser();
        for (String line : lines) {
            addOrUpdateCustomer(customers, customerLineParser, line);
        }

        return customers;
    }

    /**
     * Adds a new customer or updates existing customer.
     *
     * @param customers
     *            Map of customers
     * @param customerLineParser
     *            instance of a customer line parser
     * @param line
     *            the line to be parsed
     */
    private void addOrUpdateCustomer(
            final Map<String, Customer> customers,
            final CustomerLineParser customerLineParser, final String line) {
        customerLineParser.parseLine(line);
        Customer customer = new Customer();

        // Check to see if record is already there
        if (customers.get(customerLineParser.getCustomerName()) != null) {
            // Update existing customer record
            updateExistingRecord(customers, customerLineParser);
        } else {
            customer.setName(customerLineParser.getCustomerName());
            customer.setFirstLineOfAddress(customerLineParser
                    .getFirstLineOfAddress());
            customer.setTown(customerLineParser.getTownFromLine());
            customer.setPostCode(customerLineParser.getPostCodeFromLine());
            customer.setPhoneNumber(
                     customerLineParser.getPhoneNumberFromLine());
            customers.put(customer.getName(), customer);
        }
    }

    /**
     * Update existing record customer record if the data is not null.
     *
     * @param customers
     *            Map of the customers
     * @param customerLineParser
     *            instance of the customer line parser
     */
    private void updateExistingRecord(
            final Map<String, Customer> customers,
            final CustomerLineParser customerLineParser) {
        String name = customerLineParser.getCustomerName();
        Customer existing = customers.get(name);

        if (customerLineParser.getFirstLineOfAddress() != null) {
            existing.setFirstLineOfAddress(customerLineParser
                    .getFirstLineOfAddress());
        }

        if (customerLineParser.getTownFromLine() != null) {
            existing.setTown(customerLineParser.getTownFromLine());
        }

        if (customerLineParser.getPostCodeFromLine() != null) {
            existing.setPostCode(customerLineParser.getPostCodeFromLine());
        }

        if (customerLineParser.getPhoneNumberFromLine() != null) {
            existing.setPhoneNumber(
                    customerLineParser.getPhoneNumberFromLine());
        }
    }

}
