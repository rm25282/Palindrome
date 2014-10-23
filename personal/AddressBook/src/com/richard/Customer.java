package com.richard;

/**
 * This class represents a Customer.
 * 
 * It holds name, first line of address, town, postcode 
 * and phone number
 */
public class Customer {

	/** The customer name. */
	private String name = null;

	/** The first line of address. */
	private String firstLineOfAddress = null;

	/** The town. */
	private String town = null;

	/** The post code. */
	private String postCode = null;

	/** The phone number. */
	private String phoneNumber = null;

	/**
	 * Sets the name of the customer.
	 *
	 * @param name the new name
	 */
	public final void setName(final String name) {
		this.name = name;
	}

	/**
	 * Gets the name of the customer.
	 *
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Sets the first line of address for the customer.
	 *
	 * @param firstLineOfAddress first line of address
	 */
	public final void setFirstLineOfAddress(final String firstLineOfAddress) {
		this.firstLineOfAddress = firstLineOfAddress;
	}

	/**
	 * Gets the first line of address.
	 *
	 * @return the first line of address
	 */
	public final String getFirstLineOfAddress() {
		return firstLineOfAddress;
	}

	/**
	 * Gets the town of the customer.
	 *
	 * @return the town
	 */
	public final String getTown() {
		return town;
	}

	/**
	 * Sets the town for the customer.
	 *
	 * @param town new town
	 */
	public final void setTown(final String town) {
		this.town = town;
	}

	/**
	 * Gets the post code of the customer.
	 *
	 * @return the post code
	 */
	public final String getPostCode() {
		return postCode;
	}

	/**
	 * Sets the post code for the customer.
	 *
	 * @param postCode the post code
	 */
	public final void setPostCode(final String postCode) {
		this.postCode = postCode;
	}

	/**
	 * Gets the phone number of the customer.
	 *
	 * @return the phone number
	 */
	public final String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number of the customer.
	 *
	 * @param phoneNumber the new phone number
	 */
	public final void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public final String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("\tName:\t\t\t" + this.name + "\n");
		stringBuffer.append("\tFirst Line Of Address: \t"
				+ this.firstLineOfAddress + "\n");
		stringBuffer.append("\tTown:\t\t\t" + this.town + "\n");
		stringBuffer.append("\tPostcode:\t\t" + this.postCode + "\n");
		stringBuffer.append("\tPhone Number:\t\t" + this.phoneNumber + "\n");
		return stringBuffer.toString();
	}

	/**
	 * Write out customer line.
	 *
	 * @return the char[]
	 */
	public final char[] writeOutCustomerLine() {
		StringBuffer customerLine = new StringBuffer();
		customerLine.append(this.name);

		customerLine.append(CustomerLineParser.HASH);
		customerLine.append(CustomerLineParser.ADDRESS_INDEX);
		customerLine.append(this.firstLineOfAddress);

		customerLine.append(CustomerLineParser.HASH);
		customerLine.append(CustomerLineParser.TOWN_INDEX);
		customerLine.append(this.town);

		customerLine.append(CustomerLineParser.HASH);
		customerLine.append(CustomerLineParser.POSTCODE_INDEX);
		customerLine.append(this.postCode);

		customerLine.append(CustomerLineParser.HASH);
		customerLine.append(CustomerLineParser.PHONENUMBER_INDEX);
		customerLine.append(this.phoneNumber);

		customerLine.append("\n");

		return customerLine.toString().toCharArray();
	}

}
