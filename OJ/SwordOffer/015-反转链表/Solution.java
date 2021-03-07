/**
 * 输入一个链表，反转链表后，输出新链表的表头 {1,2,3} -> {3,2,1} Date: 2021/3/7
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int e) {
        this.val = e;
    }
}

public class Solution {

    public void travalList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("");
    }

    public ListNode buildList(int[] a) {
        if (a == null) {
            return null;
        }

        ListNode head = null;
        ListNode pre = null;
        for (int i : a) {
            ListNode cur = new ListNode(i);
            if (head == null) {
                head = pre = cur;
            } else {
                pre.next = cur;
                pre = cur;
            }
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        // if (head == null) {
        // return null;
        // }
        // ListNode pre = head;
        // ListNode cur = head.next;
        // while (cur != null) {
        // ListNode next = cur.next;
        // cur.next = pre;
        // if (pre == head) {
        // head.next = null;
        // }
        // pre = cur;
        // cur = next;
        // }
        // // pre is the tail node
        // return pre;

        ListNode newHead = null;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                newHead = cur;// cur.next == null, cur is the last node
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = s.buildList(new int[] { 1, 2, 3, 4, 5, 6 });
        s.travalList(head);

        s.travalList(s.reverseList(head));
    }
}
