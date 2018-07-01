package com.my.test;

/*
博客讲解:https://www.liuyun.fun/2018/06/16/七大排序算法之插入排序(3)
 */

public class InsertSort extends BaseSort {

    public void insertSort(int[] data) {
        int len = data.length;
        //思想：将一个数插入已经有序的数组中，刚开始有序的为index=0的一个数
        for (int i = 1; i < len; i++) {
            if (data[i] < data[i - 1]) {//若不满足，则该值已经有序,无须插入
                int tmp = data[i]; //保存 data[i]值，后面 data[i]位置要被填坑
                int j;
                for (j = i - 1; j >= 0 && tmp < data[j]; j--) {//插入的位置i,也就是j+1.因为data[j]赋值，所以截止条件为 j>=0
                    data[j + 1] = data[j];//判定截止条件原则就是数组访问不要有越界
                }
                data[j + 1] = tmp;//j+1位置为需要插入的位置
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < BaseSort.data.length; i++) {
            BaseSort.beforeSort(BaseSort.data[i]);
            InsertSort sort = new InsertSort();
            sort.insertSort(BaseSort.data[i]);
            BaseSort.afterSort(BaseSort.data[i]);
        }
    }
}

/* output
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