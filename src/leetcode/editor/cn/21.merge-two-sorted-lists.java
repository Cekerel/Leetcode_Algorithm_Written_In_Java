/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 *
 * algorithms
 * Easy (51.64%)
 * Total Accepted:    39.4K
 * Total Submissions: 76.2K
 * Testcase Example:  '[1,2,4]\n[1,3,4]'
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 * 示例：
 * 
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode listNode = list;
        while (l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                listNode.next = l1;
                listNode = listNode.next;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                listNode = listNode.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            listNode.next = l2;
        }
        if (l2 == null) {
            listNode.next = l1;
        }
        return list.next;
    }
}
