/**
 * Author: cloudy
 * Date  : 2018-6-14
 */

package com.my.test;

public class BaseSort {
    public static int[][] data = new int[][]{
            new int[]{10, 9, 8, 7, 6, 5, 5, 4, 3, 2, 1, 0},
            new int[]{1, 2, 3, 4, 5, 5, 6, 7},
            new int[]{1, 7, 3, 5, 0, 0, 2, 4, 8, 6}
    };

    public void swap(int[] a, int indexI, int indexJ) {
        if (a == null || indexI >= a.length || indexJ >= a.length) {
            System.out.println("a is null ,index out of bound");
            return;
        }
        int tmp = a[indexI];
        a[indexI] = a[indexJ];
        a[indexJ] = tmp;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }

    public static void beforeSort(int[] data) {
        System.out.println("Before Sort");
        printArray(data);
    }

    public static void afterSort(int[] data) {
        System.out.println("After Sort");
        printArray(data);
    }
}
