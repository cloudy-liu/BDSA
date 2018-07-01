package com.my.test;

/**
 *
 */
public class QuickSort extends BaseSort {

    private static final int MAX_SORT_NUMBER = 9;

    public void quickSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int base = data[start];//start 位置为基准值
        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && data[j] >= base) {//从右往左找小于的位置 j
                j--;
            }
            if (i < j) {
                data[i++] = data[j];
            }
            while (i < j && data[i] <= base) { //从左往右找大于基准值的i
                i++;
            }
            if (i < j) {
                data[j--] = data[i];
            }
        }
        if (i == j) {//此时i为基准值的索引
            data[i] = base;
        }
        quickSort(data, start, i - 1);//递归调用左序列
        quickSort(data, i + 1, end);// 递归调用右序列
    }

    public void quickSortOpt(int[] data, int start, int end) {
        if (end - start < MAX_SORT_NUMBER) {//优化1，小数据采用 直接插入法
            insertSort(data, start, end);
        } else {
            while (start < end) {//优化2,尾递归减少调用栈
                int i = start;
                int j = end;

                //优化3。采用中值法，选择基准值
                int mid = (start + end) / 2;
                if (data[start] > data[end]) {
                    swap(data, start, end);
                }
                if (data[mid] > data[end]) {
                    swap(data, mid, end);
                }
                if (data[mid] > data[start]) {
                    swap(data, mid, start);
                }
                int base = data[start];

                while (i < j) {
                    while (i < j && data[j] >= base) {
                        j--;
                    }
                    if (i < j) {
                        data[i++] = data[j];
                    }
                    while (i < j && data[i] <= base) {
                        i++;
                    }
                    if (i < j) {
                        data[j--] = data[i];
                    }
                }
                if (i == j) {
                    data[i] = base;
                }
                quickSort(data, start, i - 1);
                start = i + 1;//优化2 尾递归
            }
        }
    }

    private void insertSort(int[] data, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            if (data[i - 1] > data[i]) {
                int tmp = data[i];
                int j;
                for (j = i - 1; j >= 0 && tmp < data[j]; j--) {
                    data[j + 1] = data[j];
                }
                data[j + 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < BaseSort.data.length; i++) {
            BaseSort.beforeSort(BaseSort.data[i]);
            QuickSort sort = new QuickSort();
            sort.quickSortOpt(data[i], 0, data[i].length - 1);
            BaseSort.afterSort(BaseSort.data[i]);
        }
    }
}

/*
Before Sort
10 9 8 7 6 5 5 4 3 2 1 0

After Sort
0 1 2 3 4 5 5 6 7 8 9 10

Before Sort
1 2 3 4 5 5 6 7

After Sort
1 2 3 4 5 5 6 7

Before Sort
1 7 3 5 0 0 2 4 8 6

After Sort
0 0 1 2 3 4 5 6 7 8
 */