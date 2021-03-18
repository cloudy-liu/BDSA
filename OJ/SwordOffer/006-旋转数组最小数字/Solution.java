/**
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
 * 题目描述 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。 示例 输入[3,4,5,1,2] 返回值 1
 */
public class Solution {

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }
        int startIndex = 0;
        int endIndex = array.length - 1;
        int mid = startIndex; // 针对旋转个数为0，原数组

        while (array[startIndex] >= array[endIndex]) {
            if (endIndex - startIndex == 1) {
                mid = endIndex;
                break;
            }
            mid = (startIndex + endIndex) / 2;
            if (array[mid] == array[startIndex] && array[startIndex] == array[endIndex]) {
                return minValue(array, startIndex, endIndex);
            }
            if (array[mid] >= array[startIndex]) { // mid 为于前面大数中
                startIndex = mid;
            } else if (array[mid] <= array[endIndex]) { // mid 位于后面小数中
                endIndex = mid;
            }
        }
        return array[mid];
    }

    public int minValue(int[] a, int start, int end) {
        int min = a[start];
        for (int i = start; i <= end; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minNumberInRotateArray(new int[] { 1, 2, 3, 4, 5 }));// 1
        System.out.println(s.minNumberInRotateArray(new int[] { 3, 4, 5, 1, 2 }));// 1
        System.out.println(s.minNumberInRotateArray(new int[] { 5, 6, 7, 1, 2, 3, 4 }));// 1
        System.out.println(s.minNumberInRotateArray(new int[] { 5, 6, 7, 8, 9, 2, 3, 4 }));// 2
        System.out.println(s.minNumberInRotateArray(new int[] {}));// 0
        System.out.println(s.minNumberInRotateArray(null));// 0
        System.out.println(s.minNumberInRotateArray(new int[] { 2, 1, 2, 2, 2 }));// 1
        System.out.println(s.minNumberInRotateArray(new int[] { 2, 2, 2, 1, 2 }));// 1
    }
}