
/**
 * Source:
 * https://www.nowcoder.com/practice/184edec193864f0985ad2684fbc86841?tpId=37&tqId=21243&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy
 * Date : 2018-7-22
 */

/*
 * 密码要求:
1.长度超过8位
2.包括大小写字母.数字.其它符号,以上四种至少三种
3.不能有相同长度超2的子串重复
说明:长度超过2的子串

输入描述:
一组或多组长度超过2的子符串。每组占一行

输出描述:
如果符合要求输出：OK，否则输出NG

示例1
输入
021Abc9000
021Abc9Abc1
021ABC9000
021$bc9000
输出
OK
NG
NG
OK
 */

/**
 * Solution:
2.遍历一次字符数组，大小写，数字，其他字符都设置一个值，若存在则置1，最后判断四个值的和是否小于3
3.获取一个字串的重复子串以及重复个数。
思路：遍历一次数组，从索引0开始取长度为2的子串，然后分为前子串str1 (0,2)和后str2 [2,~)的子串，
判断 str2是否包含str1,若包含则在计算共有多少个，str2在更新为除去str1后的子串，在判断。直到str2不包含str1.
此时判断的是长度为2的子串，接着在此基础上，查找长度为3.因为长的一定包含短的，比如"abcdcdabcd" 重复最长的子
串是"abcd"，但是其子串"ab"一定包含。
 */
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static HashMap<String, Integer> getRepeatedSubStr(String line) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            int j = i + 2;
            if (j < line.length()) {
                String str1 = line.substring(i, j);
                String str2 = line.substring(j);
                while (str2.contains(str1)) {
                    int cnt = 1;
                    while (str2.contains(str1)) {
                        // System.out.println(str1 + "-->" + str2);
                        ++cnt;
                        str2 = str2.substring(str2.indexOf(str1) + str1.length());
                    }
                    if (!hashMap.containsKey(str1) && str1.length() > 2) {
                        hashMap.put(str1, cnt);
                    }
                    if (++j < line.length()) {
                        str1 = line.substring(i, j);
                        str2 = line.substring(j);
                    }
                }
            }
        }
        return hashMap;
    }

    public static void judge(String line) {
        if (line.length() <= 8) {
            System.out.println("NG");
            return;
        }
        int lowLetter = 0;
        int upperLetter = 0;
        int numLetter = 0;
        int otherLetter = 0;
        for (char c : line.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lowLetter = 1;
            } else if (c >= 'A' && c <= 'Z') {
                upperLetter = 1;
            } else if (c >= '0' && c <= '9') {
                numLetter = 1;
            } else {
                otherLetter = 1;
            }
        }
        if (lowLetter + upperLetter + numLetter + otherLetter < 3) {
            System.out.println("NG");
            return;
        }
        HashMap<String, Integer> map = Main.getRepeatedSubStr(line);
        if (!map.isEmpty()) {
            System.out.println("NG");
            return;
        }
        System.out.println("OK");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 计算字符串中重复的字符
        while (sc.hasNext()) {
            String line = sc.nextLine();
            Main.judge(line);
        }
        sc.close();
    }
}