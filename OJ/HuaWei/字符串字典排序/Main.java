
/**
 * Source:
 * https://www.nowcoder.com/practice/5af18ba2eb45443aa91a11e848aa6723?tpId=37&tqId=21237&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy 
 * Date: 2018-7-10
 */

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = Integer.valueOf(sc.nextLine());
            ArrayList<String> list = new ArrayList<>();
            while (count > 0) {
                list.add(sc.nextLine());
                --count;
            }
            Collections.sort(list);
            for (String s : list) {
                System.out.println(s);
            }
        }
        sc.close();
    }
}