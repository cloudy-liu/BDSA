
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
使用一个 HashSet记录出现过的字符，每次遍历时查找这个set是否存在，
若存在，则证明出现重复了，更新此时的长度，开启下一位的连续查询
 */

import java.util.HashSet;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        int rst = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                Character c = s.charAt(j);
                if (set.contains(c)) {
                    break;
                } else {
                    set.add(c);
                }
            }
            rst = Math.max(maxLen, set.size());
            set.clear();
        }
        return rst;
        // int rst = 0;
        // HashSet<Character> set = new HashSet<>();
        // for (int i = 0; i < s.length(); i++) {
        //     int j = i;
        //     while (j < s.length() && !set.contains(s.charAt(j))) {
        //         set.add(s.charAt(j));
        //         j++;
        //     }
        //     rst = Math.max(rst, j - i);
        //     set.clear();
        // }
        // return rst;
    }

    public static void main(String[] args) {
        LongestSubstring solution = new LongestSubstring();
        String[] data = new String[] { "abcabcbb", "bbbbb", "pwwkew" ,"c"};
        for (String s : data) {
            System.out.println(s + "-->" + solution.lengthOfLongestSubstring(s));
        }
    }
}