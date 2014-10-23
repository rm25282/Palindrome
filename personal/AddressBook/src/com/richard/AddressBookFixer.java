package com.richard;

/**
 * This takes an input file which contains customer names and details.
 * 
 * Each line is formatted as:
 * 
 * <customer name>#<collection of fields separated by '#'...> Each field is
 * formatted as:
 * 
 * <field index>|<field value>
 * 
 * The field indexes range from 1-4, which describes the field value: 1 – First
 * line of customer's address 2 – Customer's town 3 – Customer's post code 4 –
 * Customer's phone number
 * 
 * As an example, our customer 'Bob Smith' who can be reached on '0123456678'
 * and lives at '1, Manor Avenue, London, SE3' would be formatted to the line:
 * Bob Smith#1|1, Manor Avenue#2|London#3|SE3#4|0123456678
 * 
 * If the data for each of the customers is spread across different lines these
 * will be collated into 1 line and saved in the outputfile
 */
public interface AddressBookFixer {

    /**
     * Fix address book as per interface documentation.
     *
     * @param inputFilePathAndName
     *            the input file path and name
     * @param outputFilePathAndName
     *            the output file path and name
     */
    void fixAddressBook(String inputFilePathAndName,
            String outputFilePathAndName);
}
