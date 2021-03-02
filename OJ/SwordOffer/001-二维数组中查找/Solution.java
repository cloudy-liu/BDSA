/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例1 输入 复制 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]] 返回值
 * 
 * true
 * 
 * Date: 2021/2/28 21:31
 */
public class Solution {

    public boolean find(int target, int[][] array) {
        if (array == null) {
            return false;
        }
        int rows = array.length;
        int cols = array[0].length;
        int row = 0;
        int col = cols - 1;
        while (array != null & row < rows & col >= 0) {
            if (array[row][col] == target) {
                return true;
            } else if (array[row][col] > target) {
                // delete one column
                --col;
            } else {
                // delete one row
                ++row;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // [[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
        int[][] data = new int[][] { new int[] { 1, 2, 8, 9 }, new int[] { 2, 4, 9, 12 }, new int[] { 4, 7, 10, 13 },
                new int[] { 6, 8, 11, 15 } };
        Solution s = new Solution();
        boolean rst = s.find(14, data);
        if (rst) {
            System.out.println("True");
        } else {
            System.out.println("false");
        }

    }
}