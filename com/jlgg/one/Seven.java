package com.jlgg.one;

import java.util.Arrays;

/**
 * Rotate Matrix:
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 * <p>
 * Time complexity:
 * O(H*W), H = height and W = width
 */
public class Seven {

    /**
     * My solution does not require the original image to have the same height and width.
     * Creates a new bi-dimensional array and places the elements of every row in the new column
     * Cons: requires O(height * width) storage
     */
    static void rotate90Clockwise(int[][] image, int height, int width) {
        // dimensions are switched
        int[][] newImage = new int[width][height];

        for (int row = 0; row < height; row++) {
            int newColumn = (height - 1) - row;
            for (int column = 0; column < width; column++) {
                int pixel = image[row][column];
                int newRow = column;
                newImage[newRow][newColumn] = pixel;
            }
        }

        // Print the New Image
        System.out.println("\nThe new image:");
        for (int i = 0; i < newImage.length; i++) {
            System.out.println(Arrays.toString(newImage[i]));
        }
    }

    public static void main(String[] args) {
        int[][] image = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        int[][] image2 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};

        rotate90Clockwise(image, image.length, 3);
        rotate90Clockwise(image2, image2.length, 5);
    }
}
