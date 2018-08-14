
/**
 * Source:
 * https://www.nowcoder.com/practice/ae809795fca34687a48b172186e3dafe?tpId=37&tqId=21234&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy 
 * Date: 2018-7-8
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            for (int i = input.length() - 1; i >= 0; i--) {
                System.out.print(input.charAt(i));
            }
        }
        sc.close();
    }
}