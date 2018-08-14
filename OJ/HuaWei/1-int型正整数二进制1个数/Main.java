
/**
 * Source:
 * https://www.nowcoder.com/practice/440f16e490a0404786865e99c6ad91c9?tpId=37&tqId=21238&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy 
 * Date: 2018-7-10
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            // String input = Integer.toBinaryString(sc.nextInt());
            // int count = 0;
            // for(char c: input.toCharArray()){
            //     if(c == '1') {
            //         ++count;
            //     }
            // }
            // System.out.println(count);
            int n = sc.nextInt();
            int count = 0;
            while(n != 0) {//n不为0,表示至少有一个1
                ++count;
                n = n & (n-1); // n&n-1 是将n最右边1变为 0.
            }
            System.out.println(count);
        }
        sc.close();
    }
}