/**
 * Author: cloudy
 * Date  : 2018-6-22
 */

package com.my.test;

public class FibTest {

    //递归实现
    public static long fibRecursion(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return n;
        }
        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }

    //尾递归实现
    public static long fibTailRecursion(int n, int fibResult, int fibPlusOne) {
        if (n == 0) {
            return fibResult;
        }
        return fibTailRecursion(n - 1, fibResult + fibPlusOne, fibResult);
    }

    //迭代实现
    public static long fibIter(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return n;
        }

        long fibPlusOne = 1;
        long fibPlusTwo = 0;
        long rst = 0;

        for (int i = 1; i < n; i++) {
            rst = fibPlusOne + fibPlusTwo;
            fibPlusTwo = fibPlusOne;
            fibPlusOne = rst;
        }
        return rst;
    }

    public static void main(String[] args) {
        int fibValue = 40;
        long start = System.currentTimeMillis();
        for (int i = 0; i < fibValue; i++) {
            try {
                fibRecursion(i);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println("Recursion spend : " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < fibValue; i++) {
            fibTailRecursion(i, 0, 1);
        }
        System.out.println("tail Recursion spend : " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < fibValue; i++) {
            fibIter(i);
        }
        System.out.println("iter spend : " + (System.currentTimeMillis() - start) + " ms");
    }
 }


/* output
Recursion spend : 1562 ms
tail Recursion spend : 0 ms
iter spend : 0 ms
 */