package com.jlgg.one;

import java.util.Arrays;

/**
 * URLify: Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 */
public class Three {

    static void insertChar(char[] cArr, char c, int index) {
        for (int i = cArr.length - 1; i > index; i--) {
            cArr[i] = cArr[i - 1];
        }
        cArr[index] = c;
    }

    static String sURLify(String s, int l) {
        char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] == ' ') {
                //insert '%','2','0'
                sArr[i] = '%';
                insertChar(sArr, '2', i + 1);
                insertChar(sArr, '0', i + 2);
            }
        }

        return String.valueOf(sArr);
    }

    /**
     * Book Solution: edit the string starting from the end and working backwards
     * We have extra buffer at the end, allows change chars without worrying about overwriting
     */
    static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) {
            str[trueLength] = '\0'; // End array
        }
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static void main(String[] args) {
        String[][] inputs = {{"Mr John Smith    ", "13"}, {"      ", "2"}, {"Hello", "5"}};
        for (String[] input : inputs) {
            //System.out.println(sURLify(input[0], Integer.parseInt(input[1])));
            char[] cArr = input[0].toCharArray();
            replaceSpaces(cArr, Integer.parseInt(input[1]));
            System.out.println(String.valueOf(cArr));
        }
    }
}
