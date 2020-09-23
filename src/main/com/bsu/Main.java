package com.bsu;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String inputText = scanner.nextLine();
            String maxPalindrome = getMaxPalindrome(inputText);
            if (maxPalindrome.length() == 0) {
                System.out.println("No palindrome word in the text");
            } else {
                System.out.println("Palindrome found: " + maxPalindrome);
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }

    public static boolean isPalindrome(String input) {
        String reversedHalf = reverseString(input.substring(0, input.length() / 2));
        if (input.length() % 2 == 0)
            return reversedHalf.equalsIgnoreCase(input.substring(input.length() / 2));
        else
            return reversedHalf.equalsIgnoreCase(input.substring(input.length() / 2 + 1));
    }

    public static String getMaxPalindrome(String input) {
        String maxPalindrome = "";
        for (String tempWord : input.split("\\.|,| ")) {
            if (isPalindrome(tempWord) && tempWord.length() > maxPalindrome.length()) maxPalindrome = tempWord;
        }
        return maxPalindrome;
    }

    static int findIndexOf(String string, int startIndex, char... args) {
        int index = string.length(), tempIndex;
        for (char symbol : args) {
            tempIndex = string.indexOf(symbol, startIndex + 1);
            if (tempIndex != -1 && tempIndex < index) index = tempIndex;
        }
        return index;
    }

    static String reverseString(String string) {
        char[] convertedString = string.toCharArray();
        char buffer;
        for (int ind = 0; ind < convertedString.length / 2; ++ind) {
            buffer = convertedString[ind];
            convertedString[ind] = convertedString[convertedString.length - 1 - ind];
            convertedString[convertedString.length - 1 - ind] = buffer;
        }
        String result = String.valueOf(convertedString);
        return result;
    }

}
