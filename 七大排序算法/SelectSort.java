package com.my.test;

/*
博客讲解:
 */
public class SelectSort {

    public void selectSort(int[] data) {//升序排序
        int len = data.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i; //初始化假定i为最小值的索引
            for (int j = i + 1; j < len; j++) {//从 i+1处，开始寻找最小值的索引
                if (data[minIndex] > data[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) { //比较一轮下来后，minIndex位置若发生变化，交换
                swap(data, minIndex, i);
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
            SelectSort sort = new SelectSort();
            sort.selectSort(data[i]);
            System.out.println("after sort");
            printArray(data[i]);
        }
    }
}

/*
before sort
10 9 8 7 6 5 4 3 2 1 0

after sort
0 1 2 3 4 5 6 7 8 9 10

before sort
1 2 3 4 5 6 7

after sort
1 2 3 4 5 6 7

before sort
1 7 3 5 0 2 4 8 6

after sort
0 1 2 3 4 5 6 7 8
 */