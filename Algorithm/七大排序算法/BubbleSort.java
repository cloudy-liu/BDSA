package com.my.test;

/**
 * related blog link:
 */
public class BubbleSort extends BaseSort {
    public void bubbleSort(int[] data) {
        int rightSide = data.length;
        while (rightSide - 1 > 0) { // 第一层控制比较的轮数 n-1轮
            for (int i = 1; i < rightSide; i++) { // 每轮下两两比较，边界递减1
                if (data[i - 1] > data[i]) {
                    swap(data, i - 1, i);
                }
            }
            --rightSide;
        }
    }

    public void bubbleSortOpt(int[] data) {
        int rightSide = data.length;
        // 两个作用，即作为哨兵，判定是否结束比较(已序情况下），否则就将右边界设定为最后一个比较的index
        int lastCompareIndex = rightSide;
        while (lastCompareIndex > 0) {
            rightSide = lastCompareIndex;
            lastCompareIndex = 0;
            for (int i = 1; i < rightSide; i++) {
                if (data[i - 1] > data[i]) {
                    swap(data, i - 1, i);
                    lastCompareIndex = i;// 记录最后一次比较的index
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < BaseSort.data.length; i++) {
            BaseSort.beforeSort(BaseSort.data[i]);
            BubbleSort sort = new BubbleSort();
            sort.bubbleSortOpt(BaseSort.data[i]);
            BaseSort.afterSort(BaseSort.data[i]);
        }
    }
}

/*
 * output before sort 10 9 8 7 6 5 4 3 2 1 0
 * 
 * after sort 0 1 2 3 4 5 6 7 8 9 10
 * 
 * before sort 1 2 3 4 5 6 7
 * 
 * after sort 1 2 3 4 5 6 7
 * 
 * before sort 1 7 3 5 0 2 4 8 6
 * 
 * after sort 0 1 2 3 4 5 6 7 8
 */