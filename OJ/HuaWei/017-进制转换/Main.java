
/**
 * Source:
 * https://www.nowcoder.com/practice/8f3df50d2b9043208c5eed283d1d4da6?tpId=37&tqId=21228&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy 
 * Date: 2018-7-7
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine().toUpperCase();
            int value = 0;
            String hexStr = input.substring(2);
            for (int i = hexStr.length() - 1; i >= 0; i--) {
                char c = hexStr.charAt(i);
                int v = (c >= 'A' && c <= 'Z') ? (c - 'A' + 10) : (c - '0');
                value += (int) Math.pow(16.0, hexStr.length() - 1 - i) * v;
            }
            System.out.println(value);
            // System.out.println(Integer.parseInt(hexStr, 16));
        }
        scanner.close();
    }
}