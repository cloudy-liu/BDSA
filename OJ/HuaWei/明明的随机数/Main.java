
/**
 * Source: https://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0?tpId=37&tqId=21226&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy
 * Date: 2018-7-7
 */

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        while (scaner.hasNext()) { // multi testing data
            int count = scaner.nextInt();
            TreeSet<Integer> set = new TreeSet<>(); //TreeSet<Integer> can sort by itself
            while (count > 0) {
                set.add(scaner.nextInt());
                --count;
            }
            for (Integer i : set) {
                System.out.println(i);
            }
        }
        scaner.close();
    }
}
