
/**
 * 题目描述
请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
示例1
输入
复制
"We Are Happy"
返回值
复制
"We%20Are%20Happy"

C++思路： 先遍历一次数组，获取长度，空格个数，开辟一个新的数组（包含空格转为%20字符个数），然后
从后面往前移动，这样移动次数最少，O(n) 即可移完
Java思路： 直接调用库函数
 */
public class Solution {

    public String replaceString(String s) {
        if (s != null) {
            return s.replace(" ", "%20");
        }
        return "";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.replaceString("We Are Happy"));
        System.out.println(s.replaceString("We Are Happy "));
        System.out.println(s.replaceString(" We Are  Happy"));

    }
}
