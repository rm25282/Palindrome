A palindrome is a word or phrase that reads the same way in each direction. For e.g. “madam” is spelt
the same way backwards. Other examples are “racecar”, “eye”, “Never odd or even”, “Avid Diva”.
Write a method that checks whether a given String is a palindrome. You should cater for case
sensitivity as well. The ideal solution should be O(n) (or better) in terms of time and space efficiency.
An example Java interface would be:
public interface PalindromeChecker {
boolean isPalindrome(String in);
}