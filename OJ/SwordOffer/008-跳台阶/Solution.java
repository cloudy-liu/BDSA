/**
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果） Date:2021/3/19
 */
public class Solution {

    public int jumpFloor(int target) {
        if (target == 1 || target == 2) {
            return target;
        }

        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    /** Fibnicci 变形 */
    public int jumpFloorIter(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int numberMinusTwo = 1;
        int numberMinusOne = 2;
        int rst = 0;
        for (int i = 3; i <= n; i++) {
            rst = numberMinusOne + numberMinusTwo;
            numberMinusTwo = numberMinusOne;
            numberMinusOne = rst;
        }
        return rst;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
     * 
     * an= 1+2+3+4 +..+a(n-1) --》求 an
     * 2^(n-1)
     * @param args
     */

    public int JumpFloorII(int n) {
        if (n < 1) {
            return 0;
        }
        int i = n - 1;
        int rst = 1;
        while (i > 0) {
            rst = 2 * rst;
            i--;
        }
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().JumpFloorII(3));
    }
}