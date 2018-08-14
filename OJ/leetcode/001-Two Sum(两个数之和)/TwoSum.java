
/**
 * Source : https://leetcode.com/problems/two-sum/ 
 * Author : cloudy 
 * Date : 2018-7-22
 * 
 * Problem: 
 * Given an array of integers, return indices of the two numbers such
 * that they add up to a specific target. You may assume that each input would
 * have exactly one solution, and you may not use the same element twice.
 * 给定一个数组和一个目标数，返回该数组中两个数之和等于目标数的索引。给定的数组一定包含解，且数组中每个数只能用一次。
 * 例子： Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] = 2
 * + 7 = 9, return [0, 1].
 * 
 * solution:
 * 不用考虑数组只有一个数的时候，
 * 使用hashMap存储余数的索引，key=余数,value=index.比如遍历上面数组时，2的余数为7，判断hashMap
 * 是否存在，不存在就put(余数,index),存在就直接取出.
 * 存储的是余数
 */

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[] { map.get(nums[i]), i };
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] data = new int[][] { new int[] { 6, 6 }, new int[] { 2, 7, 11, 15 } };
        int[] targetArray = { 12, 9 };
        TwoSum solution = new TwoSum();
        for (int i = 0; i < data.length; i++) {
            int[] rst = solution.twoSum(data[i], targetArray[i]);
            for (int j : rst) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}