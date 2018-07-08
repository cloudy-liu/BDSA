
/**
 * Source:
 * https://www.nowcoder.com/practice/196534628ca6490ebce2e336b47b3607?tpId=37&tqId=21229&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy
 * Date: 2018-7-8
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long input = sc.nextLong();
            for (int i = 2; input != 1 && i <= input; i++) {
                while (input % i == 0) {
                    System.out.print(i + " ");
                    input /= i;
                }
            }
            System.out.println();
        }
        sc.close();
    }
}