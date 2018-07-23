
/**
 * Source : https://leetcode.com/problems/add-two-numbers/
 * Author : cloudy 
 * Date : 2018-7-22
 * 
 * Problem: 
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 * solution:
1.按照要求做的话，将链表转为数字，然后相加求和，在转为链表，对大数会溢出，这是坑 1
2.单纯的考虑对应位的相加，逐一将链表的两个数相加即可，若结果大于10，则需要进位。
(1) 长度相同时，逐一相加，
(2) 长度不同时，一个会提前完成，所以需要在考虑不同的情况
 */

/**
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * Version 1. 先考虑长度相同时，两个数相加，同时产生carry,若和大于10，产生进位
         */
        // int carry = 0;
        // int sum = 0;
        // ListNode head = null;
        // ListNode cur = null;
        // while (l1 != null && l2 != null) {
        //     sum = l1.val + l2.val + carry;
        //     carry = (sum >= 10) ? 1 : 0;
        //     sum %= 10;
        //     if (head == null) {
        //         head = new ListNode(sum);
        //         cur = head;
        //     } else {
        //         cur.next = new ListNode(sum);
        //         cur = cur.next;
        //     }
        //     l1 = l1.next;
        //     l2 = l2.next;
        // }
        // // 若一个长度更长时处理
        // while (l1 != null) {
        //     sum = l1.val + carry;
        //     carry = (sum >= 10) ? 1 : 0;
        //     sum %= 10;
        //     cur.next = new ListNode(sum);
        //     cur = cur.next;
        //     l1 = l1.next;
        // }
        // while (l2 != null) {
        //     sum = l2.val + carry;
        //     carry = (sum >= 10) ? 1 : 0;
        //     sum %= 10;
        //     cur.next = new ListNode(sum);
        //     cur = cur.next;
        //     l2 = l2.next;
        // }
        // // 注意，最后一位进位时，也要处理
        // if (carry == 1) {
        //     cur.next = new ListNode(1);
        // }

        /**
         * version 2. 将上面代码优化一下，提炼一下，简洁许多。
         * 循环条件修改为 ||
         */
        // int sum = 0;
        // int carry = 0;
        // ListNode head = null;
        // ListNode cur = null;
        // while (l1 != null || l2 != null || carry != 0) {
        //     int v1 = (l1 != null) ? l1.val : 0;
        //     int v2 = (l2 != null) ? l2.val : 0;
        //     sum = v1 + v2 + carry;
        //     carry = (sum >= 10) ? 1 : 0;
        //     sum %= 10;
        //     if(head == null) {
        //         head = new ListNode(sum);
        //         cur = head;
        //     } else {
        //         cur.next = new ListNode(sum);
        //         cur = cur.next;
        //     }
        //     l1 = (l1 != null) ? l1.next : null;
        //     l2 = (l2 != null) ? l2.next : null;
        // }
        // return head;

        /**
         * Version 3.在优化，去掉中间那个产生节点的 if-else 语句，head节点事先分配好
         * 去掉 v1,v2 的临时变量， carry 产生直接用 sum取商
         */
        int sum = 0;
        int carry = 0;
        ListNode pre = new ListNode(0);
        ListNode head = pre;
        while(l1 != null || l2 != null || carry != 0) {
            sum = ((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0) + carry;
            carry = sum / 10;
            sum %= 10;
            pre.next = new ListNode(sum);
            pre = pre.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return head.next;
    }

    public static ListNode buildListNode(int[] data) {
        ListNode head = null;
        ListNode cur = null;
        for (int i : data) {
            ListNode tmpNode = new ListNode(i);
            if (head == null) {
                head = tmpNode;
                cur = head;
            } else {
                cur.next = tmpNode;
                cur = tmpNode;
            }
        }
        return head;
    }

    public static void printNode(ListNode l) {
        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data1 = { 9 };
        int[] data2 = { 1, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
        // int[] data1 = { 2, 4, 3 };
        // int[] data2 = { 5, 6, 4 };
        ListNode l1 = buildListNode(data1);
        ListNode l2 = buildListNode(data2);
        printNode(l1);
        printNode(l2);
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode rst = solution.addTwoNumbers(l1, l2);
        while (rst != null) {
            System.out.print(rst.val + "->");
            rst = rst.next;
        }
    }
}