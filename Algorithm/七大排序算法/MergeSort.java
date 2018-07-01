/**
 * Author: cloudy
 * Date  : 2018-6-14
 */

package com.my.test;

public class MergeSort extends BaseSort {

    public void mergeSort(int[] data) {
        int len = data.length;
        int[] tmp = new int[len];
        mergeSortImplementRecur(data, 0, len - 1, tmp);
    }

    // 递归实现
    private void mergeSortImplementRecur(int[] data, int startIndex, int endIndex, int[] tmp) {
        if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            mergeSortImplementRecur(data, startIndex, mid, tmp);
            mergeSortImplementRecur(data, mid + 1, endIndex, tmp);
            mergeArray(data, startIndex, mid, endIndex, tmp);
        }
    }

    // 非递归实现
    private void mergeSortImplementIter(int[] data, int startIndex, int endIndex, int[] tmp) {

    }

    private void mergeArray(int[] data, int start, int mid, int last, int[] tmp) {
        int i = start;
        int n = mid;
        int j = mid + 1;
        int m = last;
        int k = 0;
        while (i <= n && j <= m) {
            if (data[i] < data[j]) {
                tmp[k++] = data[i++];
            } else {
                tmp[k++] = data[j++];
            }
        }
        while (i <= n) {
            tmp[k++] = data[i++];
        }
        while (j <= m) {
            tmp[k++] = data[j++];
        }
        for (i = 0; i < k; i++) {
            data[start + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < BaseSort.data.length; i++) {
            BaseSort.beforeSort(BaseSort.data[i]);
            MergeSort sort = new MergeSort();
            sort.mergeSort(data[i]);
            BaseSort.afterSort(BaseSort.data[i]);
        }
    }
}

/*
 * Before Sort 10 9 8 7 6 5 5 4 3 2 1 0
 * 
 * After Sort 0 1 2 3 4 5 5 6 7 8 9 10
 * 
 * Before Sort 1 2 3 4 5 5 6 7
 * 
 * After Sort 1 2 3 4 5 5 6 7
 * 
 * Before Sort 1 7 3 5 0 0 2 4 8 6
 */