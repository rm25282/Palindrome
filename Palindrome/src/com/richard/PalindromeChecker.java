package com.richard;

/**
 * This provides an interface to a method which checks if a 
 * word or sentence is a palindrome.
 */
public interface PalindromeChecker {

	/**
	 * Checks if a string is a palindrome.
	 *
	 * @param in the string to be checked
	 * @return true, if is palindrome
	 *         false, if it is not a palindrome
	 */
	boolean isPalindrome(String in);
	
}
