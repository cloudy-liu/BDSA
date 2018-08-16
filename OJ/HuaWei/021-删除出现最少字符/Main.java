
/**
 * Source:
 * https://www.nowcoder.com/practice/05182d328eb848dda7fdd5e029a56da9?tpId=37&tqId=21246&tPage=2&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy 
 * Date: 2018-8-16
 * 
 * Problem:
 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。
 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 
输入描述:
字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。

输出描述:
删除字符串中出现次数最少的字符后的字符串。

输入
abcdd


输出
dd
 * solution:
 * 1.利用hashMap获取每个字符出现的次数
 * 2.获取最小的次数
 * 3.遍历字符串，输出不是最小次数的字符即可
 */

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            HashMap<Character, Integer> map = new HashMap<>();
            char[] cArray = s.toCharArray();
            for (char c : cArray) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }

            int minCount = map.size();
            for (Character c : map.keySet()) {
                if (map.get(c) < minCount) {
                    minCount = map.get(c);
                }
            }
            for (int i = 0; i < cArray.length; i++) {
                if(map.get(cArray[i]) != minCount) {
                    System.out.print(cArray[i]);
                }
            }
            System.out.println("");
        }
        scanner.close();
    }
}