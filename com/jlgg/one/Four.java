package com.jlgg.one;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco eta", etc.)
 * <p>
 * Time Complexity:
 * O(n) time complexity, n = length of string
 */
public class Four {

    static Map<Character, Integer> charFreqsMap;

    static void collectMap(char[] charsArr) {
        charFreqsMap = new HashMap<>();
        for (Character c : charsArr) {
            if (!charFreqsMap.containsKey(c)) {
                charFreqsMap.put(c, 1);
            } else {
                charFreqsMap.put(c, charFreqsMap.get(c) + 1);
            }
        }
    }

    /**
     * Approach: Verify if a string CAN be palindrome.
     * No need to generate permutations, it is factorial time, infeasible.
     * Palindrome 2 conditions:
     * a) Even length string, all chars must have even frequency
     * b) Odd length string, 1 char odd frequency + the rest of chars all even frequency
     */
    static boolean canBePalindrome(String s) {
        char[] sArr = s.toCharArray();
        // collect the Char to Freqs Map
        collectMap(sArr);
        // A palindrome can have no more than 1 char that is odd, this covers both conditions
        int freq;
        boolean odd = false;
        for (Character c : charFreqsMap.keySet()) {
            freq = charFreqsMap.get(c);
            if (freq % 2 != 0) {
                if (odd) {
                    return false;
                }
                odd = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] inputs = {"ab", "abc", "a bb ax", "ab cabc", "abca", "Tact Coa"};

        String in;
        for (String input : inputs) {
            // Remove spaces
            in = input.replaceAll("\\s", "");
            System.out.println(canBePalindrome(in.toLowerCase()));
        }
    }
}
