package com.jlgg.one;

/**
 * String Compression: Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 * <p>
 * Time Complexity
 * .append() is O(1) amortized time complexity
 * So the algorithm is:  O(n), n = length of string
 */
public class Six {

    static String compress(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            count++;
            // If end of string or the next char is different append current char to the compressed string
            if (i + 1 == s.length() || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i)).append(count);
                count = 0;
            }
        }

        return sb.length() < s.length() ? sb.toString() : s;
    }

    public static void main(String[] args) {
        String[] inputs = {"aabcccccaaa", "aabbcc", "xabcdefaaaaaaaaaaaaax"};

        for (String input : inputs) {
            System.out.println(compress(input));
        }

    }
}
