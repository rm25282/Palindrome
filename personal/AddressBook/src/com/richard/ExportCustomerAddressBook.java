package com.richard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * The class creates a file with each line containing a line of 
 * data about the customer in the format.
 * 
 * Each field is formatted as:
 * 
 * <field index>|<field value>
 * The field indexes range from 1-4, which describes the field value:
 * 1 – First line of customer's address
 * 2 – Customer's town
 * 3 – Customer's post code
 * 4 – Customer's phone number
 * As an example, our customer 'Bob Smith' who can be reached on 
 * '0123456678' and lives at '1, Manor
 * Avenue, London, SE3' would be formatted to the line:
 * Bob Smith#1|1, Manor Avenue#2|London#3|SE3#4|0123456678
 */
public class ExportCustomerAddressBook {

	/** The file name and path of the export file. */
	private String fileNameAndPath = null;

	/**
	 * Instantiates a new export customer address book.
	 *
	 * @param fileNameAndPath the file name and path
	 */
	public ExportCustomerAddressBook(final String fileNameAndPath) {
		this.fileNameAndPath = fileNameAndPath;
	}

	/**
	 * Export file from customer data in the format 
	 * described in the class.
	 *
	 * @param customers the customers list
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public final void exportFileFromCustomerData(
	        final Map<String, Customer> customers)
			throws IOException {
		if (this.fileNameAndPath == null) {
			throw new FileNotFoundException();
		}

		if (customers == null) {
			return;
		}
		
		File outputFile = new File(this.fileNameAndPath);
		outputFile.delete();

		BufferedWriter bufferedWriter = null;

		try {

			bufferedWriter = new BufferedWriter(new FileWriter(
					this.fileNameAndPath));

			for (Map.Entry<String, Customer> customer : customers.entrySet()) {
				bufferedWriter
						.write(customer.getValue().writeOutCustomerLine());
			}

		} finally {
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}
		}
	}

}
