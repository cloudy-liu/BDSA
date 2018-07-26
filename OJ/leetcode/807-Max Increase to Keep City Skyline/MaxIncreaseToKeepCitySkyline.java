
/**
 * Source : https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/
 * Author : cloudy 
 * Date : 2018-7-26
 * 
 * Problem: 
 * In a 2 dimensional array grid, each value grid[i][j] represents the height 
 * of a building located there.We are allowed to increase the height of any 
 * number of buildings, by any amount (the amounts can be different for 
 * different buildings). Height 0 is considered to be a building as well. 
 * At the end, the "skyline" when viewed from all four directions of the grid, 
 * i.e. top, bottom, left, and right, must be the same as the skyline of the 
 * original grid. A city's skyline is the outer contour of the rectangles formed 
 * by all the buildings when viewed from a distance. See the following example.
 * What is the maximum total sum that the height of the buildings can be increased?
 * 
 * Example:
 * Input: grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
 * Output: 35
 * Explanation: 
 * The grid is:
[ [3, 0, 8, 4], 
  [2, 4, 5, 7],
  [9, 2, 6, 3],
  [0, 3, 1, 0] ]

* The skyline viewed from top or bottom is: [9, 4, 8, 7]
* The skyline viewed from left or right is: [8, 7, 9, 3]
* The grid after increasing the height of buildings without affecting skylines is:

gridNew = [ [8, 4, 8, 7],
            [7, 4, 7, 7],
            [9, 4, 8, 7],
            [3, 3, 3, 3] ]

Notes:

1 < grid.length = grid[0].length <= 50.
All heights grid[i][j] are in the range [0, 100].
All buildings in grid[i][j] occupy the entire grid cell: that is, they are a 1 x 1 x grid[i][j] rectangular prism.

* solution:
* 
 */

import java.util.HashMap;

public class MaxIncreaseToKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        /**
         * V1: 暴力法 遍历行列时，求取该行该列的最大值，然后取两者的较小值，和该矩阵中的值做差
         * 同时，列的取值，通过可缓存下来，该解法 Java 13ms, 击败 8.74% 。垫底的速度。囧。
         */
        // int rowLen = grid.length;
        // int colLen = grid[0].length;
        // int rowMax = 0;
        // int colMax = 0;
        // int rst = 0;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < rowLen; i++) {
        // // rowMax
        // rowMax = 0;
        // for (int k = 0; k < colLen; k++) {
        // if (grid[i][k] > rowMax) {
        // rowMax = grid[i][k];
        // }
        // }
        // for (int j = 0; j < colLen; j++) {
        // // colMax
        // if (!map.containsKey(j)) {
        // colMax = 0;
        // for (int m = 0; m < rowLen; m++) {
        // if (grid[m][j] > colMax) {
        // colMax = grid[m][j];
        // }
        // }
        // map.put(j, colMax);
        // } else {
        // colMax = map.get(j);
        // }

        // int DiffValue = Math.min(rowMax, colMax);
        // rst += (DiffValue - grid[i][j]);
        // }
        // }
        // return rst;

        /**
         * V2: 先一次性计算出，每行，每列的最大值，这样做两次 O(m*n)复杂度
         * 
         */

        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[] rowMax = new int[rowLen];
        int[] colMax = new int[colLen];
        int rst = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);//存储每行的最大值 i为行号
                colMax[j] = Math.max(colMax[j], grid[i][j]);//存储每列的最大值，j为列号
            }
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                rst += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        MaxIncreaseToKeepCitySkyline solution = new MaxIncreaseToKeepCitySkyline();
        // int[][] data = new int[][] { new int[] { 3, 0, 8, 4 }, new int[] { 2, 4, 5, 7
        // }, new int[] { 9, 2, 6, 3 },
        // new int[] { 0, 3, 1, 0 } };
        int[][] data = new int[][] { new int[] { 59, 88, 44 }, new int[] { 3, 18, 38 }, new int[] { 21, 26, 51 } };
        System.out.println(solution.maxIncreaseKeepingSkyline(data));

    }
}