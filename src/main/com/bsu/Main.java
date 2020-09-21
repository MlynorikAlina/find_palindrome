package com.bsu;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner((System.in))) {
            String inputText = scanner.nextLine();

            System.out.println("Palindrome: " + getMaxPalindrome(inputText));
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }

    public static String getMaxPalindrome(String input) {
        return MaxPalindrome(findPalindromeRadius(input.toCharArray()), input);
    }

    static int[][] findPalindromeRadius(char[] input) {
        int leftBorder, rightBorder;
        int[][] palindromeRadius = new int[2][input.length];

        for (int palindromeKind = 0; palindromeKind <= 1; ++palindromeKind) {
            leftBorder = rightBorder = 0;
            for (int counter = 0; counter < input.length; ++counter) {
                if (counter < rightBorder) {
                    palindromeRadius[palindromeKind][counter] =
                            Math.min(1 - palindromeKind + rightBorder - counter,
                                    palindromeRadius[palindromeKind][1 - palindromeKind + rightBorder + leftBorder - counter]);
                }

                int tempLeftBorder = counter - palindromeRadius[palindromeKind][counter];
                int tempRightBorder = counter + palindromeRadius[palindromeKind][counter] - 1 + palindromeKind;
                while (tempLeftBorder - 1 >= 0 && tempRightBorder + 1 < input.length && input[tempLeftBorder - 1] == input[tempRightBorder + 1]) {
                    palindromeRadius[palindromeKind][counter]++;
                    tempLeftBorder--;
                    tempRightBorder++;
                }

                if (tempRightBorder > rightBorder) {
                    leftBorder = tempLeftBorder;
                    rightBorder = tempRightBorder;
                }

            }
        }
        return palindromeRadius;
    }

    static String MaxPalindrome(int[][] radius, String input) {
        int maxIndex = 0, maxRadius = 0, maxIndexKind = 0;
        for (int ind = 0; ind < radius[0].length; ind++) {
            if (maxRadius < radius[0][ind]) {
                maxIndex = ind;
                maxRadius = radius[0][ind];
                maxIndexKind = 0;
            }
            if (maxRadius <= radius[1][ind]) {
                maxIndex = ind;
                maxRadius = radius[1][ind];
                maxIndexKind = 1;
            }
        }
        return input.substring(maxIndex - maxRadius, maxIndex + maxRadius + maxIndexKind);
    }

}
