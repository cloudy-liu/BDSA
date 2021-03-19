/**
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey
 * 
 * 求第n个斐波那契数列： 0,1,1,2,3,5,8..
 * Date:2021/3/19
 */
public class Solution {

    public int fibonacciRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public int fibnoiccIter(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int number_minus_two = 0;
        int number_minus_one = 1;
        int rst = 0;
        for (int i = 2; i <= n; i++) {
            rst = number_minus_one + number_minus_two;
            number_minus_two = number_minus_one;
            number_minus_one = rst;
        }
        return rst;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 0; i < 10; i++) {
            System.out.println(s.fibnoiccIter(i));
        }
    }
}