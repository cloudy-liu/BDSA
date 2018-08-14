
/**
 * Source:
 * https://www.nowcoder.com/practice/d9162298cb5a437aad722fccccaae8a7?tpId=37&tqId=21227&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy
 * Date: 2018-7-7
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        while (scaner.hasNext()) {
            String input = scaner.nextLine();
            if (input.trim().length() == 0) {
                continue;
            }
            while (input.length() >= 8) {
                System.out.println(input.substring(0, 8));
                input = input.substring(8);
            }
            if (input.length() > 0 && input.length() < 8) {
                input += "00000000";
                System.out.println(input.substring(0, 8));
            }
        }
        scaner.close();
    }
}