
/**
 * Source: https://www.nowcoder.com/practice/8c949ea5f36f422594b306a2300315da?tpId=37&tqId=21224&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy
 * Date: 2018-7-7
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        String input = scaner.nextLine();
        System.out.println(input.length() - 1 - input.lastIndexOf(" "));
        scaner.close();
    }
}
  