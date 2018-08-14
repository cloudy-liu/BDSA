
/**
 * Source:
 * https://www.nowcoder.com/practice/de044e89123f4a7482bd2b214a685201?tpId=37&tqId=21231&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy 
 * Date: 2018-7-8
 */

import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = sc.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<>();
            while (count > 0) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + value);
                } else {
                    map.put(key, value);
                }
                --count;
            }
            for (Integer key : map.keySet()) {
                System.out.println(key + " " + map.get(key));
            }
        }
        sc.close();
    }
}