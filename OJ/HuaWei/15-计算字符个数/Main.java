
/**
 * Source:
 * https://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0?tpId=37&tqId=21226&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy 
 * Date: 2018-7-7
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        char target = scanner.nextLine().toLowerCase().charAt(0);
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == target) {
                ++count;
            }
        }
        System.out.println(count);
        scanner.close();
    }
}