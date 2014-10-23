package com.richard;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * This class contains the main method for the program to run.
 * 
 * It provides an interface implementation of fixAddressBook.
 */
public class AddressBookFixerImpl implements AddressBookFixer {

    /**
     * The main method which is executed when the application is started.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        if (args.length != 2) {
            System.out
                    .println("Number of arguments does not equal 2. "
                            + "Proper use is "
                            + "<program> <input file> <output file>");
        }

        AddressBookFixer addressBookFixer = new AddressBookFixerImpl();
        addressBookFixer.fixAddressBook(args[0], args[1]);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.richard.AddressBookFixer#fixAddressBook(java.lang.String,
     * java.lang.String)
     */
    @Override
    public final void fixAddressBook(final String inputFilename,
            final String outputFilename) {

        long time = System.currentTimeMillis();

        if (inputFilename == null) {
            System.out.println("No input file provided");
            return;
        }

        if (outputFilename == null) {
            System.out.println("No output file provided");
            return;
        }

        ExportCustomerAddressBook exportCustomerAddressBook = 
                new ExportCustomerAddressBook(
                outputFilename);

        CustomerAddressBookReader customerAddressBookReader = 
                new CustomerAddressBookReader();

        Map<String, Customer> customers = null;
        try {
            customers = customerAddressBookReader
                    .readAddressBook(inputFilename);
        } catch (FileNotFoundException e1) {
            System.out.println("Exception thrown on reading input file "
                    + inputFilename);
            e1.printStackTrace();
        }

        try {
            exportCustomerAddressBook.exportFileFromCustomerData(customers);
            System.out.println("Time to parse file and export="
                    + (System.currentTimeMillis() - time) + " milliseconds");
            System.out.println("Memory used: "
                    + (Runtime.getRuntime().totalMemory() - Runtime
                            .getRuntime().freeMemory()) + " bytes");
        } catch (IOException e) {
            System.out.println("Exception thrown on creating output file "
                    + outputFilename);
            e.printStackTrace();
        }

    }

}
