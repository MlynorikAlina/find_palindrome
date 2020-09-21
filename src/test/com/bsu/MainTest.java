package com.bsu;

import org.junit.Test;

import static com.bsu.Main.getMaxPalindrome;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void getMaxPalindromeTest() {
        assertEquals(getMaxPalindrome("aaa"), "aaa");
        assertEquals(getMaxPalindrome("aaaa"), "aaaa");
        assertEquals(getMaxPalindrome("aaababaac"), "aababaa");
        assertEquals(getMaxPalindrome("aaababba"), "abba");
        assertEquals(getMaxPalindrome("aa.aa..aa...a"), ".aa..aa.");
        assertEquals(getMaxPalindrome(""), "");
    }
}