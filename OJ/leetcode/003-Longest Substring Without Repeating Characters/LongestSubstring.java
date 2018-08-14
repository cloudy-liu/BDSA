
/**
 * Source : https://leetcode.com/problems/longest-substring-without-repeating-characters
 * Author : cloudy 
 * Date : 2018-7-23
 * 
 * Problem: 
Given a string, find the length of the longest substring without repeating characters.

Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 * solution:
 */

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        /**
         * V1: O(n^2) 思路：不重复用可使用hashset特征。两个指针，第一个指针逐一扫描整个字串，
         * 第二个指针在第一个指针基础上右移，逐一检测是否有重复元素，有重复则停止，
         * 更新长度，取当期结果与该次结果的最大值，set清空，开始下一次的扫描。
         */
        // int rst = 0;
        // HashSet<Character> set = new HashSet<>();
        // char[] cArray = s.toCharArray();
        // for (int i = 0; i < cArray.length; i++) {
        //     for (int j = i; j < cArray.length; j++) {
        //         if (set.contains(cArray[j])) {
        //             break;
        //         } else {
        //             set.add(cArray[j]);
        //         }
        //     }
        //     if (set.size() > rst) {
        //         rst = set.size();
        //     }
        //     set.clear();
        // }
        // return rst;

        /**
         * V2: O(n) 思路：两个指针，只扫描一次，用HashMap存该字符对应的索引值，若字符相同，则会更新
         * 指针i遍历整个字符，指针j则记录相同字符最后位置的索引。遍历i时，逐一将该字符加入
         * hashmap中，key=字符，val=索引值。若出现重复时，则更新j值，j为出现相同字符的最后位置
         * 结果长度就是 i-j+1.
         */
        int rst = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            rst = Math.max(rst, i - j + 1);
        }
        return rst;
    }

    public static void main(String[] args) {
        LongestSubstring solution = new LongestSubstring();
        String[] data = new String[] { "abcabcbb", "bbbbb", "pwwkew", "c" };
        for (String s : data) {
            System.out.println(s + "-->" + solution.lengthOfLongestSubstring(s));
        }
    }
}