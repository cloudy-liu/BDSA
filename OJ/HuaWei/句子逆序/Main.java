
/**
 * Source:
 * https://www.nowcoder.com/practice/48b3cb4e3c694d9da5526e6255bb73c3?tpId=37&tqId=21236&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy 
 * Date: 2018-7-8
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] array = input.split(" ");
            StringBuilder builder = new StringBuilder();
            for (int i = array.length - 1; i >= 0; i--) {
                builder.append(array[i]).append(" ");
            }
            System.out.println(builder.toString().trim());
        }
        sc.close();
    }
}