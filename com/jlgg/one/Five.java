package com.jlgg.one;

/**
 * One Away: There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 * ple, pale -> true
 */
public class Five {
    /**
     * If the strings have different length then every char of B must be contained in A
     * if the strings have same length then 1 char max can be different
     * <p>
     * Time Complexity: O(B), B = length of shorter string
     */
    static boolean calDifferences(String a, String b, boolean diffLength) {
        int index = 0;
        boolean oneCharDifferent = false;
        while (index < b.length()) {
            if (!a.contains(String.valueOf(b.charAt(index)))) {
                if (diffLength) {
                    return false;
                }
                // same length
                if (oneCharDifferent) {
                    return false;
                }
                oneCharDifferent = true;
            }
            index++;
        }
        return true;
    }

    static boolean isEditable(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int l1 = s1.length();
        int l2 = s2.length();
        int lengthsDiff = Math.abs(l1 - l2);
        if (lengthsDiff == 1) {
            if (l2 < l1) {
                return calDifferences(s1, s2, true);
            }
            return calDifferences(s2, s1, true);
        } else if (lengthsDiff == 0) {
            return calDifferences(s1, s2, false);
        }

        return false;
    }

    public static void main(String[] args) {
        String[][] inputs = {{"pale", "ple"}, {"pales", "pale"}, {"pale", "bale"},
                {"pale", "bake"}, {"ple", "pale"}, {"abc", "abcd"}};

        for (String[] input : inputs) {
            System.out.println(isEditable(input[0], input[1]));
        }
    }
}
