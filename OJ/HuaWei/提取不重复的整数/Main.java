
/**
 * Source:
 * https://www.nowcoder.com/practice/253986e66d114d378ae8de2e6c4577c1?tpId=37&tqId=21232&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy 
 * Date: 2018-7-8
 */

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            LinkedHashSet<Character> set = new LinkedHashSet<>();
            for (int i = input.length() - 1; i >= 0; i--) {
                set.add(input.charAt(i));
            }
            for (Character c : set) {
                System.out.print(c);
            }
        }
        sc.close();
    }
}