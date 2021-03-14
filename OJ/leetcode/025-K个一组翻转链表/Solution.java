
/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序
 * 
 * 输入：head = [1,2,3,4,5], k = 2 输出：[2,1,4,3,5]
 * 
 * 输入：head = [1,2,3,4,5], k = 3 输出：[3,2,1,4,5]
 * 
 * 输入：head = [1], k = 1 输出：[1]
 * 
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
            head = head.next;
        }
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

    public ListNode reverseListByNode(ListNode start, ListNode end) {
        // [a,b)
        ListNode cur = start;
        ListNode pre = null;
        ListNode next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < k; i++) {
            if (right == null) {
                return left;
            }
            right = right.next;
        }

        ListNode newHead = reverseListByNode(left, right);
        left.next = reverseKGroup(right, k);
        return newHead;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.buildList(new int[] { 1, 2, 3, 4, 5 });
        ListNode.travalList(s.reverseKGroup(head, 2)); // [2,1,4,3,5]

        head = ListNode.buildList(new int[] { 1, 2, 3, 4, 5 });
        ListNode.travalList(s.reverseKGroup(head, 3)); // [3,2,1,4,5]

        head = ListNode.buildList(new int[] { 1 });
        ListNode.travalList(s.reverseKGroup(head, 1)); // [1]

    }

}