
/**
 * Source : https://leetcode.com/problems/jewels-and-stones 
 * Author : cloudy 
 * Date : 2018-7-25
 * 
 * Problem: 
 * You're given strings J representing the types of stones that are jewels,
 * and S representing the stones you have.  Each character in S is a type of stone you have. 
 * You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. 
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * 
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * 
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * 
 * solution:
 * 就是遍历S元素 char,存在 J中，cnt++.
 */

import java.util.HashMap;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null) {
            return 0;
        }
        int rst = 0;
        for (char c : S.toCharArray()) {
            if(J.contains(String.valueOf(c))) {
                ++rst;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        JewelsAndStones solution = new JewelsAndStones();
        System.out.println(solution.numJewelsInStones("z", "ZZ"));
        System.out.println(solution.numJewelsInStones("aA", "aAAbbbb"));
    }
}