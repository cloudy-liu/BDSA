
/**
 * Source  : https://leetcode.com/problems/valid-parentheses
 * Author  : cloudy
 * Date   : 2018-7-1
 * 
 * solution:
 * using a stack. when scan left parentheis , push into stack, when scan right parenthese,
 * pop top stack. at last check stack is empty.
 */

import java.util.HashMap;
import java.util.Stack;


public class ValidParentheses {

    public boolean isValid(String s) {
        // my solution is not very simple
        // 
        // Stack<Character> stack = new Stack<>();
        // for (int i = 0; i < s.length(); i++) {
        //     char currentChar = s.charAt(i);
        //     if ((currentChar == '(' || currentChar == '[' || currentChar == '{')) {
        //         stack.push(currentChar);
        //     } else if (stack.isEmpty()) {
        //         return false;
        //     } else {
        //         Character top = stack.peek();
        //         if ((top == '[' && currentChar == ']') || (top == '{' && currentChar == '}')
        //                 || (top == '(' && currentChar == ')')) {
        //             stack.pop();
        //         } else {
        //             return false;
        //         }
        //     }
        // }
        // return stack.isEmpty();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // consider opposite side, make code more simple
            if (c == '(') { 
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean verify(String input, boolean expected) {
        return isValid(input) == expected;
    }

    // test
    public static void main(String[] args) {
        HashMap<String, Boolean> data = new HashMap<>();
        data.put("()", true);
        data.put("()[]{}", true);
        data.put("(]", false);
        data.put("([)]", false);
        data.put("{[]}", true);
        data.put(")", false);
        data.put("()))", false);
        data.put("(", false);
        data.put("(])", false);

        ValidParentheses test = new ValidParentheses();
        for (String key : data.keySet()) {
            if (!test.verify(key, data.get(key))) {
                System.out.println(key + " " + data.get(key) + " --> fail");
            }
        }
        System.out.println("test done");
    }
}