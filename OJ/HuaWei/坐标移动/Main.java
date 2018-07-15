
/**
 * Source:
 * https://www.nowcoder.com/practice/119bcca3befb405fbe58abe9c532eb29?tpId=37&tqId=21240&rp=0&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * Author: cloudy 
 * Date: 2018-7-10
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String[] sArray = input.split(";");
            int x = 0;
            int y = 0;
            for (String s : sArray) {
                if(s.length() <= 0 ) {
                    continue;
                }
                char first = s.charAt(0);
                if ((first == 'A' || first == 'W' || first == 'S' || first == 'D') && s.length() <= 3) {
                    int count = 0;
                    try {
                        count = Integer.valueOf(s.substring(1));
                    } catch (NumberFormatException e) {
                        continue;
                    }
                    if (first == 'A') {
                        x -= count;
                    } else if (first == 'D') {
                        x += count;
                    } else if (first == 'W') {
                        y += count;
                    } else if (first == 'S') {
                        y -= count;
                    }
                }
            }
            System.out.println(x + "," + y);
        }
        sc.close();
    }
}