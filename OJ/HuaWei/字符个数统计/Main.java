
/**
 * Source:
 * https://www.nowcoder.com/practice/eb94f6a5b2ba49c6ac72d40b5ce95f50?tpId=37&tqId=21233&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy 
 * Date: 2018-7-8
 */

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            HashSet<Character> set = new HashSet<>();
            for (char c : input.toCharArray()) {
                set.add(c);
            }
            System.out.println(set.size());
        }
        sc.close();
    }
}