/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tags=&title=&diffculty=0&judgeStatus=0&rp=1&tab=answerKey
 * {1,3,5},{2,4,6} -> {1,2,3,4,5,6} Date: 2021/3/7
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

    /**
     * 递归方式: 1.比两个头结点，小的节点为新的头节点，next节点为继续两个链表合并
     * 2.截止条件，当某个节点为空时，合并的节点为另一个(包含两个都为空)
     */
    public ListNode merge_recursion(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode mergeHead = null;

        if (list1.val < list2.val) {
            mergeHead = list1;
            mergeHead.next = merge_recursion(list1.next, list2);
        } else {
            mergeHead = list2;
            mergeHead.next = merge_recursion(list2.next, list1);
        }
        return mergeHead;
    }

    /**
     * 迭代方式：
     * 1.输入处理，当一个为空，直接返回另一个链表
     * 2.处理两个都不为空的场景，head, pre, cur ，小的节点作为当前节点，迭代
     * 3.当一个链表结束时，直接链入另一个链表
     */
    public ListNode merge_iter(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        ListNode pre = null;
        ListNode cur = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur = list1;
                list1 = list1.next;
            } else {
                cur = list2;
                list2 = list2.next;
            }
            if (head == null) {
                head = pre = cur;
            } else {
                pre.next = cur;
                pre = cur;
            }
        }
        // 当一个为空时，剩下一个合并进去
        if (list1 == null) {
            pre.next = list2;
        }
        if (list2 == null) {
            pre.next = list1;
        }
        return head;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        ListNode list1 = s.buildList(new int[] { 1, 3, 5,7});
        ListNode list2 = s.buildList(new int[] { 2, 4, 6 });

        // s.travalList(s.merge_recursion(list1, list2));
        s.travalList(s.merge_iter(list1, list2));
    }
}