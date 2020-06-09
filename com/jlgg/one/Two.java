package com.jlgg.one;

import java.util.Arrays;

/**
 * Problem: Given two strings, write a method to decide if one is a permutation of the other.
 * <p>
 * Context:
 * A permutation is a rearrangement of letters.
 * A string of length N has N! permutation.
 * Given ABC, the permutations: ABC, ACB, BAC, BCA, CBA, CAB
 * 3! = 3*2*1 = 6
 */
public class Two {

    /**
     * Sort both strings and compare if equals
     * Time Complexity:
     * a = length of s1
     * b = length of s2
     * O(a) + O(b) + O(a log a) + O(b log b) + O (a) = O(a + b) linear
     */
    static boolean isPermutation(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);

        return Arrays.equals(s1Arr, s2Arr);
    }

    public static void main(String[] args) {
        String[][] inputs = {{"ABC", "ACB"}, {"ABC", "ABE"}, {"ABC", ""}};

        StringBuilder sb;
        for (String[] input : inputs) {
            sb = new StringBuilder();
            sb.append(input[1]);
            if (isPermutation(input[0], input[1])) {
                sb.append(" is ");
            } else {
                sb.append(" is not ");
            }
            sb.append("a permutation of ").append(input[0]);
            System.out.println(sb.toString());
        }
    }
}
