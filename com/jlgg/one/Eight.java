package com.jlgg.one;

import java.util.Arrays;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 * <p>
 * Time complexity: O(R*C), R = number of rows, C = number of columns
 * Space complexity: O(N), N = the largest dimension (row or column)
 */
public class Eight {

    /**
     * If we attempt to fill with zeros while traversing the matrix, we found the problem that we will
     * eventually set the entire matrix to zero.
     * To avoid it we first identify which rows and cols contain a zero and store them in arrays.
     * Then we fill the rows and cols of the matrix.
     */
    static void zeroMatrix(int[][] matrix, int rows, int columns) {

        // Arrays to track which rows and cols contain a zero
        boolean[] rowsArr = new boolean[rows];
        boolean[] columnsArr = new boolean[columns];

        // Identify the rows and columns with zero
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    rowsArr[i] = true;
                    columnsArr[j] = true;
                }
            }
        }

        // set row els to zero
        for (int i = 0; i < rowsArr.length; i++) {
            if (rowsArr[i]) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // set column els to zero
        for (int i = 0; i < columnsArr.length; i++) {
            if (columnsArr[i]) {
                for (int j = 0; j < rows; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 4, 5}, {6, 7, 2, 9}, {3, 2, 5, 6}};

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        zeroMatrix(matrix, matrix.length, 4);

        System.out.println("Zero Matrix:");
        printMatrix(matrix);

    }
}
