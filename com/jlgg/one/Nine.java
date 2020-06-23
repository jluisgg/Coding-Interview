package com.jlgg.one;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1
 * using only one call to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").
 * <p>
 * Time Complexity:
 * O(N), N = length of s1/2
 */
public class Nine {

    /**
     * Checks if s2 is a substring of s1
     * The idea is to obtain each substring of s1 (subS1) and compare it against s2
     * iterate s1 until you reach the end: s1.length() - s2.length()
     */
    static boolean isSubstring(String s1, String s2) {
        for (int i = 0; i <= (s1.length() - s2.length()); i++) {
            String subS1 = s1.substring(i, i + s2.length());
            if (subS1.equals(s2)) {
                return true;
            }
        }

        return false;
    }

    /**
     * It assumes the s1 has two substrings X and Y determined by the rotation point
     * so s1 = xy, therefore s2 = yx
     * Regardless of the rotation point it assumes yx(s2) will always be a subtring of xyxy (s1s1)
     */
    static boolean isRotation(String s1, String s2) {
        // Check s1 and s2 are equal length and not empty
        StringBuilder sb = new StringBuilder();
        if (s1.length() == s2.length() && !s1.isEmpty()) {
            // concatenate s1s1
            sb.append(s1).append(s1);
            return isSubstring(sb.toString(), s2);
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] inputs = {{"waterbottle", "erbottlewat"}, {"waterbottle", "elwaterbott"},
                {"@aterbottle", "aterbottle@"}, {"aaa", "aaa"}, {"waterbottle", "ewaterbott"}};

        String s1, s2;
        for (String[] input : inputs) {
            // Remove spaces
            s1 = input[0].replaceAll("\\s", "");
            s2 = input[1].replaceAll("\\s", "");
            System.out.println(isRotation(s1, s2));
        }
    }
}
