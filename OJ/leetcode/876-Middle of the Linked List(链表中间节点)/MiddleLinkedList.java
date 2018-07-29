
/**
 * Source : https://leetcode.com/problems/middle-of-the-linked-list/description/
 * Author : cloudy 
 * Date : 2018-7-29
 * 
 * Problem: 
 * Given a non-empty, singly linked list with head node head, 
 * return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 * 
 * solution:
 * 遍历一次链表，将节点存入，然后取出 size/2 节点即是结果
 */

import java.util.ArrayList;
import java.util.List;

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

public class MiddleLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode rst = null;
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        int middleIndex = list.size() / 2;
        return list.get(middleIndex);
    }

    public void printNode(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }

    public ListNode buildLinkedList(int[] data) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        for (int i : data) {
            pre.next = new ListNode(i);
            pre = pre.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4, 5, 6 };
        MiddleLinkedList solution = new MiddleLinkedList();
        ListNode l1 = solution.buildLinkedList(data);
        solution.printNode(l1);
        solution.printNode(solution.middleNode(l1));
    }
}