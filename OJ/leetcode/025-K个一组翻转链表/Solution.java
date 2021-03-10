
/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序

输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]

输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]

输入：head = [1], k = 1
输出：[1]

 * Date: 2021/3/10
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