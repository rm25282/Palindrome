package com.richard;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PalindromeCheckerTest {
	
	PalindromeChecker pc = null;
	
	@Before
	public void setup() {
		pc = new PalindromeCheckerImpl();
	}
	
	@Test
	public void checks_whether_non_palidrome_String_is_not_a_palindrome() {
		assertFalse(pc.isPalindrome("Hell"));
	}
	
	@Test
	public void checks_whether_another_non_palidrome_String_is_not_a_palindrome() {
		assertFalse(pc.isPalindrome("Hello"));
	}
	
	@Test
	public void checks_whether_palidrome_String_is_a_palindrome() {
		assertTrue(pc.isPalindrome("abba"));
	}

	@Test
	public void checks_whether_palidrome_String_is_a_palindrome_for_odd() {
		assertTrue(pc.isPalindrome("madam"));
	}
	
	@Test
	public void checks_whether_racecar_returns_true() {
		assertTrue(pc.isPalindrome("racecar"));
	}
	
	@Test
	public void checks_whether_eye_returns_true() {
		assertTrue(pc.isPalindrome("eye"));
	}
	
	@Test
	public void checks_whether_Avid_Diva_returns_true() {
		assertTrue(pc.isPalindrome("Avid Diva"));
	}
	
	@Test
	public void checks_whether_Never_odd_or_even_returns_true() {
		assertTrue(pc.isPalindrome("Never odd or even"));
	}
	
	@Test
	public void checks_whether_emptystring_returns_false() {
		assertFalse(pc.isPalindrome(""));
	}
	
	@Test
	public void checks_whether_null_returns_false() {
		assertFalse(pc.isPalindrome(null));
	}
	
	@Test
	public void checks_whether_long_string_returns_true() {
		assertTrue(pc.isPalindrome("1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZZYXWVUTSRQPONMLKJIHGFEDCBA0987654321"));
	}
}
