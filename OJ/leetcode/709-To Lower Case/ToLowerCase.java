
/**
 * Source : https://leetcode.com/problems/to-lower-case/description/
 * Author : cloudy 
 * Date : 2018-7-27
 * 
 */

public class ToLowerCase {
    public String toLowerCase(String str) {
        if(str == null) {
            return "";
        }
        return str.toLowerCase();
    }

    public static void main(String[] args) {
        ToLowerCase solution = new ToLowerCase();
        System.out.println(solution.toLowerCase("HelloWorld"));
    }
}