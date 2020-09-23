package com.bsu;

import org.junit.Test;

import static com.bsu.Main.getMaxPalindrome;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void noPalindromeInTheTextTest() {
        assertEquals(getMaxPalindrome(""), "");
        assertEquals(getMaxPalindrome(".. .."), "");
        assertEquals(getMaxPalindrome("..ab nok llm"), "");
    }
    @Test
    public void textWithDelimitersTest(){
        assertEquals(getMaxPalindrome(".aaa cbabc aac"), "cbabc");
        assertEquals(getMaxPalindrome("aa, abba, a."), "abba");
        assertEquals(getMaxPalindrome("aa.aa..aa...a"), "aa");
    }
    @Test
    public void textWithoutDelimitersTest(){
        assertEquals(getMaxPalindrome("a"), "a");
        assertEquals(getMaxPalindrome("aaaa"), "aaaa");
        assertEquals(getMaxPalindrome("ab"), "");
    }
}