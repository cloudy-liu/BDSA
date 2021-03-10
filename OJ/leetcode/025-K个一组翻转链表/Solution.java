
/**
 * 
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int e) {
        this.val = e;
    }

    public static void travalList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-->");
        }
        head = head.next;
        System.out.println("");
    }

    public static ListNode buildList(int[] a) {
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
}

public class Solution {

    public void reverseListByHeadTail(ListNode pre, ListNode head, ListNode tail) {
        ListNode newHead = null;

        ListNode pre = tail.next;
        ListNode next = null;
        while (head != null) {
            next = head.next;// save
            head.next = pre;
            pre = head;
            head = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode reverseHead = null;
        ListNode newHead = null;
        int i = 1;
        ListNode cur = head;
        while (cur != null) {
            if (reverseHead == null) {
                reverseHead = cur;
            }
            i++;
            cur = cur.next;
            if (i == k) {
                ListNdoe rst = reverseListByHeadTail(reverseHead, cur);
                if (newHead == null) {
                    newHead = rst;
                }
                i = 1;
                reverseHead = null;
            }

        }
        return newHead;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}