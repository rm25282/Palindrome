package com.richard;

/**
 * Instantiate this class and call the isPalindrome method to 
 * check whether or not the string passed in is a Palindrome.
 */
public class PalindromeCheckerImpl implements PalindromeChecker {

	/* (non-Javadoc)
	 * @see com.richard.PalindromeChecker#isPalindrome(java.lang.String)
	 */
	@Override
	public final boolean isPalindrome(final String in) {
		// check if empty an not a true palindrome
		if (in == null || in.length() == 0) { 
		    return false;
		}
		
		// Remove spaces from the input
		String spacesRemoved = in.replaceAll(" ", "");
		
		if (spacesRemoved.equalsIgnoreCase(
		        new StringBuilder(spacesRemoved).reverse().toString())) {

			System.out.println("This is a palindrome: \n\t" + in + "\n\t"
					+ new StringBuilder(in).reverse());

			return true;
		}

		System.out.println("This is not a palindrome: \n\t" + in + "\n\t"
				+ new StringBuilder(in).reverse());

		return false;
	}

}
