package com.richard;

/**
 * This class parses the line for the customer details in the format.
 * 
 * Each line is formatted as:
 * <customer name>#<collection of fields separated by '#'...>
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
 * 
 * Once the class has been instantiated the method
 * 
 * parseLine(final String line)
 * 
 * must be called before any other method otherwise a 
 * NotParsedExcetion will be thrown
 */
public class CustomerLineParser {

	/** LINE_HAS_NOT_BEEN_PARSED. */
	private static final String LINE_HAS_NOT_BEEN_PARSED = 
	        "Line has not been parsed";

    /** The input line. */
	private String line;

	/** parsed line. */
	private String[] parsedLine;

	/** indicates whether the line has been parsed. */
	private boolean isLineParsed = false;

	/** The Constant HASH. */
	protected static final String HASH = "#";

	/** The Constant ADDRESS_INDEX. */
	protected static final String ADDRESS_INDEX = "1|";
	
	/** The Constant TOWN_INDEX. */
	protected static final String TOWN_INDEX = "2|";
	
	/** The Constant POSTCODE_INDEX. */
	protected static final String POSTCODE_INDEX = "3|";
	
	/** The Constant PHONENUMBER_INDEX. */
	protected static final String PHONENUMBER_INDEX = "4|";

	/**
	 * Parses the line.
	 *
	 * @param line the line
	 */
	public final void parseLine(final String line) {
		this.line = line;
		this.parsedLine = line.split(HASH);
		this.isLineParsed = true;
	}

	/**
	 * Gets the customer name from the line.
	 *
	 * @return the customer name
	 */
	public final String getCustomerName() {
		if (line == null || line.isEmpty()) {
			return null;
		}

		return line.substring(0, line.indexOf(HASH));
	}

	/**
	 * Parses the line for customer details.
	 *
	 * @return the string
	 */
	public final String parseLineForCustomerDetails() {
		if (line == null || line.isEmpty()) {
			return null;
		}

		String customerDetails = line.substring(line.indexOf(HASH) + 1,
				line.length());

		return customerDetails;
	}

	/**
	 * Gets the first line of address from the parsed line.
	 *
	 * @return the first line of address
	 */
	public final String getFirstLineOfAddress() {
		if (!isLineParsed) {
			throw new NotParsedException(LINE_HAS_NOT_BEEN_PARSED);
		}
		return getValueFromLine(ADDRESS_INDEX);
	}

	/**
	 * Gets the town from line  from the parsed line.
	 *
	 * @return the town from line
	 */
	public final String getTownFromLine() {
		if (!isLineParsed) { 
			throw new NotParsedException(LINE_HAS_NOT_BEEN_PARSED);
		}
		return getValueFromLine(TOWN_INDEX);
	}

	/**
	 * Gets the post code from the parsed line.
	 *
	 * @return the post code from line
	 * 
	 */
	public final String getPostCodeFromLine() {
		if (!isLineParsed) {
			throw new NotParsedException(LINE_HAS_NOT_BEEN_PARSED);
		}
		return getValueFromLine(POSTCODE_INDEX);
	}

	/**
	 * Gets the phone number from the parsed line.
	 *
	 * @return the phone number from line
	 * 
	 */
	public final String getPhoneNumberFromLine() {
		if (!isLineParsed) {
			throw new NotParsedException(LINE_HAS_NOT_BEEN_PARSED);
		}
		return getValueFromLine(PHONENUMBER_INDEX);
	}

	/**
	 * Gets the value  from the parsed line.
	 *
	 * @param index the index
	 * @return the value from line
	 */
	private String getValueFromLine(final String index) {
		for (String token : parsedLine) {
			if (token.startsWith(index)) {
				return token.substring(2, token.length());
			}
		}

		return null;
	}

}
