package com.my.test;

public class HeapSort extends BaseSort {

    public void heapSort(int[] data) {
        int len = data.length;
        buildMaxHeap(data, len);//建立大顶堆
        for (int i = len; i > 0; i--) {
            swap(data, 0, i - 1);//i-1位置就每次为最大
            maxHeapAdjustDown(data, i - 1, 0);//每次交换后，就确定了排序的一个值，剩下有 i-1个元素待排
        }
    }

    private void buildMaxHeap(int[] data, int len) {
        //从最后一个非叶子节点开始，向上逐一调整
        for (int i = len / 2 - 1; i >= 0; i--) {
            maxHeapAdjustDown(data, len, i);
        }
    }

    private void maxHeapAdjustDown(int[] data, int len, int rootIndex) {
        int tmp = data[rootIndex];
        int subIndex = rootIndex * 2 + 1;
        while (subIndex < len) {
            //找到更大的子节点
            if (subIndex + 1 < len && data[subIndex + 1] > data[subIndex]) {
                subIndex++;
            }
            //截止条件，若父节点是最大的，则停止
            if (tmp >= data[subIndex]) {
                break;
            }
            //否则替换父节点
            data[rootIndex] = data[subIndex];
            rootIndex = subIndex;
            subIndex = rootIndex * 2 + 1;
        }
        data[rootIndex] = tmp;
    }


    //降序排序
    public void heapSortDescend(int[] data) {
        int len = data.length;
        makeMinHeapArray(data, len);
        for (int i = len; i > 0; i--) {
            swap(data, 0, i - 1);
            minHeapAdjust(data, i - 1, 0);
        }
    }

    private void makeMinHeapArray(int[] data, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            minHeapAdjust(data, len, i);
        }
    }

    private void minHeapAdjust(int[] data, int len, int rootIndex) {
        int tmp = data[rootIndex];
        int subIndex = 2 * rootIndex + 1;

        while (subIndex < len) {
            if (subIndex + 1 < len && data[subIndex] > data[subIndex + 1]) {
                subIndex++;
            }
            if (tmp <= data[subIndex]) {
                break;
            }
            data[rootIndex] = data[subIndex];
            rootIndex = subIndex;
            subIndex = 2 * rootIndex + 1;
        }
        data[rootIndex] = tmp;
    }

    public static void main(String[] args) {
        for (int i = 0; i < BaseSort.data.length; i++) {
            BaseSort.beforeSort(BaseSort.data[i]);
            HeapSort sort = new HeapSort();
            sort.heapSort(BaseSort.data[i]);
            BaseSort.afterSort(BaseSort.data[i]);
        }
    }
}
