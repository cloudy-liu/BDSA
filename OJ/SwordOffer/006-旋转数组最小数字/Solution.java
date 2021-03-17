/**
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
 * 题目描述 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。 示例 输入[3,4,5,1,2] 返回值 1
 */
public class Solution {

    public int minNumberInRotateArray(int[] array) {
        int rst = 0;
        if (array == null || array.length == 0) {
            return rst;
        }
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (startIndex != endIndex) {
            if (endIndex - startIndex == 1) {
                rst = array[endIndex];
                break;
            }
            int mid = (startIndex + endIndex) / 2;
            if (array[mid] > array[startIndex]) {
                startIndex = mid;
            } else {
                endIndex = mid;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minNumberInRotateArray(new int[] { 3, 4, 5, 1, 2 }));// 1
        System.out.println(s.minNumberInRotateArray(new int[] { 5, 6, 7, 1, 2, 3, 4 }));// 1
        System.out.println(s.minNumberInRotateArray(new int[] { 5, 6, 7, 8, 9, 2, 3, 4 }));// 2
        System.out.println(s.minNumberInRotateArray(new int[] {}));// 0
        System.out.println(s.minNumberInRotateArray(null));// 0
    }
}