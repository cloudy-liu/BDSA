
/**
 * link:https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey
 * input: {67,0,24,58}
 * output: [58,24,0,67]
 */

import java.util.ArrayList;
import java.util.Stack;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (listNode == null) {
            return rst;
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            rst.add(stack.pop());
        }
        return rst;
    }

    public ListNode buildListNode(int[] a) {
        ListNode head = null;
        ListNode cur = null;
        ListNode next = null;
        for (int i : a) {
            cur = new ListNode(i);
            if (head == null) {
                head = cur;
                next = cur;
            } else {
                next.next = cur;
                next = cur;
            }
        }
        return head;
    }

    public void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = new int[] { 67, 0, 24, 58 };

        ListNode head = s.buildListNode(a);
        s.printListNode(head);
        s.printListFromTailToHead(head);
    }
}