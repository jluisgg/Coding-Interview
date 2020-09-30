package com.jlgg.one;

/**
 * URLify: Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 */
public class Three {
    /**
     * Book Solution: edit the string starting from the end and working backwards
     * We have extra buffer at the end, allows change chars without worrying about overwriting
     */
    static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        int index = trueLength + spaceCount * 2;
        for (int i = trueLength - 1; i >= 0; i--) {
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
        String[][] inputs = {{"Mr John Smith    ", "13"}, {"      ", "2"}, {"H e l l o        ", "9"}};
        for (String[] input : inputs) {
            char[] cArr = input[0].toCharArray();
            replaceSpaces(cArr, Integer.parseInt(input[1]));
            System.out.println(String.valueOf(cArr));
        }
    }
}
