/**
 * Author: cloudy
 * Date  : 2018-6-14
 */

package com.my.test;

public class ShellSort extends BaseSort {

    public void shellSort(int[] data) {
        int len = data.length;
        for (int step = len / 2; step > 0; step /= 2) {//将数组分为几次做插入排序,这里用step=2
            for (int i = step; i < len; i++) {//step 为间隔
                if (data[i - step] > data[i]) {//和插入排序一样，
                    int tmp = data[i];
                    int j;
                    for (j = i - step; j >= 0 && tmp < data[j]; j -= step) {//只不过 -1换成-step
                        data[j + step] = data[j];
                    }
                    data[j + step] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < BaseSort.data.length; i++) {
            BaseSort.beforeSort(BaseSort.data[i]);
            ShellSort sort = new ShellSort();
            sort.shellSort(BaseSort.data[i]);
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
 */