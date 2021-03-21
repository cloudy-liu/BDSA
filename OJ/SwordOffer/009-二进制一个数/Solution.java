
/**
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示
 */

public class Solution {

    /**
     * 1. n右移一位 和 1 进行与，结果为0，则表示该位为0，这样要移动32 2.
     * 当n为负数时，右移动时，最前的符号位要保持为1，会导致死循环，反过来想，让1移动
     */
    public int NumberOf1(int n) {
        // solution 1. 移动32次
        // int rst = 0;
        // int flag = 1;
        // while (flag != 0) {
        // if ((n & flag) != 0) {
        // rst++;
        // }
        // flag = flag << 1;
        // }

        // solution 2
        // 将最右边1变为0的次数
        int rst = 0;
        while (n != 0) {//n不为0，则至少包含一个1
            rst++;
            n &= n - 1;// n&(n-1) 将最右1变为0，看有多少次
        }
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().NumberOf1(10));
    }
}