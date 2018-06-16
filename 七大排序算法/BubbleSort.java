package com.my.test;

/*
博客讲解: https://www.liuyun.fun/2018/06/14/七大排序算法之冒泡排序(1)
 */
public class BubbleSort {
    public void bubbleSort(int[] input) {
        int rightSide = input.length;
        while (rightSide - 1 > 0) { //第一层控制比较的轮数 n-1轮
            for (int i = 1; i < rightSide; i++) { //每轮下两两比较，边界递减1
                if (input[i - 1] > input[i]) {
                    swap(input, i - 1, i);
                }
            }
            --rightSide;
        }
    }

    public void bubbleSortOpt(int[] input) {
        int rightSide = input.length;
        int lastCompareIndex = rightSide;//两个作用，即作为哨兵，判定是否结束比较(已序情况下），否则就将右边界设定为最后一个比较的index
        while (lastCompareIndex > 0) {
            lastCompareIndex = 0;
            for (int i = 1; i < rightSide; i++) {
                if (input[i - 1] > input[i]) {
                    swap(input, i - 1, i);
                    lastCompareIndex = i;//记录最后一次比较的index
                }
            }
        }
    }

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

    public static void main(String[] args) {
        int[][] data = new int[][]{
                new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0},
                new int[]{1, 2, 3, 4, 5, 6, 7},
                new int[]{1, 7, 3, 5, 0, 2, 4, 8, 6}};

        for (int i = 0; i < data.length; i++) {
            System.out.println("before sort");
            printArray(data[i]);
            BubbleSort sort = new BubbleSort();
//            sort.bubbleSort(data[i]);
            sort.bubbleSortOpt(data[i]);
            System.out.println("after sort");
            printArray(data[i]);
        }
    }
}
