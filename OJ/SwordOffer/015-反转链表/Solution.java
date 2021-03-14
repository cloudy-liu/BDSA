import org.graalvm.compiler.replacements.nodes.ReverseBytesNode;

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

class ListWrapper {

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
     * 反转单链表
     * 迭代思路
     * 1.三个指针，pre,cur(head),next
     * 2.正序遍历 cur,先记录下个next节点，然后将当前cur指向之前一个节点pre,然后在更新
     */
    public ListNode reverseListIter(ListNode head) {
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    /**
     * 递归思路反转单链表(从第 n 推到到 n+1 的情况):
     * 1->2->3->4->5->6
     * 一个节点的链表反转就是自己（截止条件）
     * 1             2<-3<-4-<-5<-6
     * head  head.next           newHead
     */
    public ListNode reverseListRecursive(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 反转链表前 K 个节点
     *  1->2->3->4->5->6, k=3 --> 3->2->1->4->5->6
     *
     * 迭代思想：
     * 跟迭代反转整个链表一样，当遍历到K个节点时结束，首节点next指向k+1个节点
     */
    public ListNode reverseKNodeIter(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        int i = 1;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            if (i == k) {
                head.next = next;
                break;
            }
            i++;
        }
        return pre;
    }

    /**
     * 递归方式反转前K个节点：
     * 1->2->3->4->5->6
     * 思路：
     *    1->2->3         4->5->6
     * head       kNextNode
     * 1->2->3 反转，也即是 1,2<-3 4->5->6，2,3反转ok了，处理 1和2的关系，当递归到3时（此时为唯一节点），
     * 保存4节点值
     */
    public ListNode kNextNode = null;

    public ListNode reverseKNodeRecursive(ListNode head, int k) {
        if (k == 1) {
            kNextNode = head.next;
            return head;
        }
        ListNode newHead = reverseKNodeRecursive(head.next, k - 1);
        head.next.next = head;
        head.next = kNextNode;
        return newHead;
    }

    /**
     * 反转[m,n)个区间链表
     * 1->2->3->4->5->6, m=2,n=4
     * 1  2<-3<-4 5->6
     * 1->4->3->2->5->6
     */

    public ListNode reverseListByNode(ListNode start, ListNode end) {
        // [a,b)
        System.out.println("start.val=" + start.val + ",end.val=" + end.val);
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

    // public ListNode reverseBetweenIter(ListNode head, int m, int n) {
    //     if (head == null || m >= n) {
    //         return head;
    //     }

    //     ListNode start = head;

    //     int i = 1;
    //     while (i < m) {
    //         start = start.next;
    //         i++;
    //     }
    //     ListNode end = start;
    //     while (i < n) {
    //         end = end.next;
    //         i++;
    //     }
    //     ListNode newHead = reverseListByNode(start, end.next);
    //     if(start == head) {// 前K个节点反转
    //         return newHead;
    //     } else {

    //     }
    //     return head;
    // }

    /**
     * K个一组反转链表：
     * 
     * 1->2->3->4->5->6->7, k=3
     * 3->2->1->6->5->4->7
     */

    public ListNode reverseKGroup(ListNode head, int k) {
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
}

public class Solution {

    public static void main(String[] args) {
        ListWrapper lw = new ListWrapper();

        System.out.println("origin list:");
        ListNode head = lw.buildList(new int[] { 1, 2, 3, 4, 5, 6,7});
        lw.travalList(head);

        System.out.println("iter reverse list:");
        ListNode reverseHead = lw.reverseListIter(head);
        lw.travalList(reverseHead);
        System.out.println("reverse list again by recursive:");
        reverseHead = lw.reverseListRecursive(reverseHead);
        lw.travalList(reverseHead);

        // System.out.println("reverse pre 4 node: ");
        // lw.travalList(lw.reverseKNodeIter(reverseHead, 4));
        // lw.travalList(lw.reverseKNodeRecursive(reverseHead, 3));
        System.out.println("reverse [m,n) Node ");
        lw.travalList(lw.reverseKGroup(reverseHead,3));

    }
}
