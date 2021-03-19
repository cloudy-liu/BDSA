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

    // public int jumpFloorIter(int n) {
    //     if (n == 1 || n == 2) {
    //         return n;
    //     }
    //     int a1 = 1;
    //     int a2 = 2;
    //     int rst = 0;
    //     for (int i = 3; i <= n; i++) {
    //         rst = a1 + a2;
    //         a2 = 
    //     }
    // }

    public static void main(String[] args) {
        System.out.println(new Solution().jumpFloor(3));
    }
}