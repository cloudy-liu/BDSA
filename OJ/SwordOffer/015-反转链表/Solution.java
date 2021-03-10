/**
 * 输入一个链表，反转链表后，输出新链表的表头
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey
 * {1,2,3} -> {3,2,1} Date: 2021/3/7
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

    public ListNode reverseListRecurise(ListNode head) {
        if (head == null) {
            return null;
        }
        //截止条件，当一个节点时，反转就是自己
        if (head.next == null) {
            return head;
        }

        //获取到下一段的新头节点
        ListNode newHead = reverseListRecurise(head.next);
        head.next.next = head; //将head.next 节点反转
        head.next = null; //同时原来的头节点要置null
        return newHead;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = s.buildList(new int[] { 1, 2, 3, 4, 5, 6 });
        s.travalList(head);

        s.travalList(s.reverseListRecurise(head));
    }
}
