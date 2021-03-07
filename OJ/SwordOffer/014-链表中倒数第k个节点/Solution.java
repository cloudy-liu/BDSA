/**
 * link:https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9?tpId=13&tqId=11167&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
 * 
 * {1,2,3,4,5},2 -》 {4}
 * Date: 2021/3/7
 */

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public ListNode findKthToTail(ListNode pHead, int k) {
        if (pHead == null || k == 0) {
            return null;
        }
        ListNode first = pHead;
        ListNode target = pHead;

        // first和target相差 k-1 步
        for (int i = 0; i < k - 1; i++) {
            if (first.next != null) {
                first = first.next;
            } else {
                // 当k大于本身链表长度时，返回null
                return null; // test data: {1,2,3,4,5},6
            }
        }

        while (first.next != null) {
            first = first.next;
            target = target.next;
        }
        return target;
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

    public void travalList(ListNode head) {
        while (head != null) {
            System.out.println(head.val + "->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = s.buildList(new int[] { 1 });

        // {},0
        // {1,2},1
        // {1,2,3},4
        ListNode rst = s.findKthToTail(head, 0);
        System.out.println(rst.val);

    }
}
