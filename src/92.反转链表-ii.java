/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head != null && head.next != null && right != left) {
            if (left == 1) {
                return reverseList(head, left, right);
            } else {
                int count = 1;
                ListNode pointer = head;
                while (count++ < left - 1) {
                    pointer = pointer.next;
                }
                pointer.next = reverseList(pointer.next, count, right);
            }

        }
        return head;
    }

    public ListNode reverseList(ListNode node, int start, int end) {
        if (node == null || node.next == null || start >= end) {
            return node;
        }

        ListNode lastNode = reverseList(node.next, start + 1, end);

        ListNode tempNode = node.next.next;

        node.next.next = node;
        node.next = tempNode;

        return lastNode;
    }
}
// @lc code=end

