
/**
 * Source:
 * https://www.nowcoder.com/practice/7960b5038a2142a18e27e4c733855dac?tpId=37&tqId=21244&tPage=2&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy 
 * Date: 2018-8-14
 * 
 * Problem:
 * 密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 
 * 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
 * 假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，他通过一种算法把这个
 * 密码变换成YUANzhi1987，这个密码是他的名字和出生年份，怎么忘都忘不了，
 * 而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。他是这么变换的，
 * 大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, 
 * pqrs--7, tuv--8 wxyz--9, 0--0,就这么简单，渊子把密码中出现的小写字母都变成对应的数字，
 * 数字和其他的符号都不做变换，
 * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，
 * 如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦。
 * 
 * 输入描述:
 * 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
 * 输出描述:
 * 输出渊子真正的密文
 * 
 * 输入
 * YUANzhi1987
 * 输出
 * zvbo9441987
 * 
 * solution:
 * 输入：字符，只对字母做变换，其他不变
 */

import java.util.Scanner;

public class Main {

    public static String changeLetter(String s) {
        String rst = "";
        if ("abc".indexOf(s) != -1) {
            rst = "2";
        } else if ("def".indexOf(s) != -1) {
            rst = "3";
        } else if ("ghi".indexOf(s) != -1) {
            rst = "4";
        } else if ("jkl".indexOf(s) != -1) {
            rst = "5";
        } else if ("mno".indexOf(s) != -1) {
            rst = "6";
        } else if ("pqrs".indexOf(s) != -1) {
            rst = "7";
        } else if ("tuv".indexOf(s) != -1) {
            rst = "8";
        } else if ("wxyz".indexOf(s) != -1) {
            rst = "9";
        } else {
            rst = s;
        }
        return rst;
    }

    /**
     * V1. 1h.jiong
     */
    public static String changedToRst(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            char tmp = c;
            if (!Character.isLetter(c)) {
                builder.append(Character.toString(tmp));
            } else if (Character.isLowerCase(c)) {
                builder.append(Main.changeLetter(Character.toString(tmp)));
            } else {
                tmp = (char) (Character.toLowerCase(c) + 1);
                tmp = (tmp > 'z') ? 'a' : tmp;
                builder.append(Character.toString(tmp));
            }
        }
        return builder.toString();
    }

    /**
     * V2: 使用字符数组逐一处理,最后将字符转为String返回
     */
    public static String changedToRst2(String s) {
        char[] cArray = s.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            char c = cArray[i];
            if (c >= 'a' && c <= 'c') {
                cArray[i] = '2';
            } else if (c >= 'd' && c <= 'f') {
                cArray[i] = '3';
            } else if (c >= 'g' && c <= 'i') {
                cArray[i] = '4';
            } else if (c >= 'j' && c <= 'l') {
                cArray[i] = '5';
            } else if (c >= 'm' && c <= 'o') {
                cArray[i] = '6';
            } else if (c >= 'p' && c <= 's') {
                cArray[i] = '7';
            } else if (c >= 't' && c <= 'v') {
                cArray[i] = '8';
            } else if (c >= 'w' && c <= 'z') {
                cArray[i] = '9';
            } else if (c >= 'A' && c <= 'Z') {
                // 大写转小写 +32 26个字母取余，得出于'a'的距离，然后在转为char
                cArray[i] = (char) ((c + 32 + 1 - 'a') % 26 + 'a');
            }
        }

        return String.valueOf(cArray);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(Main.changedToRst2(s));
        }
        scanner.close();
    }
}