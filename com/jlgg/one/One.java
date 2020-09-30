package com.jlgg.one;

import java.util.Arrays;

/**
 * Problem: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 * <p>
 * Context:
 * ASCII (American Standard Code for Information Interchange), 7 bit charset: 128 chars [0 - 127]
 * <p>
 * Unicode is a superset of ASCII
 * Java char is unicode 16 bit charset UTF-16
 */
public class One {

    /**
     * Sort the array and check for adjacent index
     * Time Complexity: O(n log n) + O(n) = O(n), n = number of chars
     */
    static boolean allUnique(String s) {
        char[] sArr = s.toCharArray();
        // Sorting: O(n log n)
        Arrays.sort(sArr);
        // Iteration: O(n)
        for (int i = 0; i < sArr.length; i++) {
            if (i + 1 < sArr.length) {
                if (sArr[i] == sArr[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] inputs = {"abcd", "abcA", "@ghkl%", "@bAa", "@abc@", "AbAcd", "%%", "a b c"};

        StringBuilder sb;
        for (String s : inputs) {
            sb = new StringBuilder("The characters in ").append(s);
            if (allUnique(s)) {
                sb.append(" are unique.");
            } else {
                sb.append(" are not unique.");
            }
            System.out.println(sb.toString());
        }
    }
}
