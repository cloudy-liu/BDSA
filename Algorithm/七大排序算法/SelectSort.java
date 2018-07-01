package com.my.test;

/**
 *
 */
public class SelectSort extends BaseSort{

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


    public static void main(String[] args) {
        for (int i = 0; i < BaseSort.data.length; i++) {
            BaseSort.beforeSort(BaseSort.data[i]);
            SelectSort sort = new SelectSort();
            sort.selectSort(BaseSort.data[i]);
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