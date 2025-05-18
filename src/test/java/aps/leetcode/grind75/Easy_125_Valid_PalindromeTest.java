package aps.leetcode.grind75;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Easy_125_Valid_PalindromeTest {

    @Test
    void testPalindromeTrue() {
        String input = "A man, a plan, a canal: Panama";
        assertTrue(Easy_125_Valid_Palindrome.isPalindrome(input));
    }

    @Test
    void testPalindromeFalse() {
        String input = "0P";
        assertFalse(Easy_125_Valid_Palindrome.isPalindrome(input));
    }

    @Test
    void testEmptyString() {
        assertTrue(Easy_125_Valid_Palindrome.isPalindrome(""));
    }

    @Test
    void testSingleCharacter() {
        assertTrue(Easy_125_Valid_Palindrome.isPalindrome("z"));
    }

    @Test
    void testOnlySpecialCharacters() {
        assertTrue(Easy_125_Valid_Palindrome.isPalindrome(".,,;;;"));
    }
}
