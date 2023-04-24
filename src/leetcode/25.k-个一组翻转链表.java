/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    class Node {
        private ListNode node;
 
        public ListNode getNode() {
            return node;
        }
 
        public void setNode(ListNode node) {
            this.node = node;
        }
    }
 
    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if (head == null || head.next == null)
            return head;
 
        ListNode root, pointer;
        root = pointer = null;
 
        int count = 0;
        Node node = new Node();
        boolean notSoLong = false;
 
 
        while (head != null && head.next != null && !notSoLong) {
            if (count++ % k == 0) {
                if (root == null) {
                    notSoLong = getLastListNode(head, 0, k - 1, node);
                    root = node.getNode();
                } else {
                    notSoLong = getLastListNode(head, 0, k - 1, node);
                    pointer.next = node.getNode();
                }
                pointer = head;
                head = head.next;
            }
        }  ;
 
        return root;
    }
 
    public boolean getLastListNode(ListNode listNode, int start, int end,
                                   Node node) {
        if (listNode == null || listNode.next == null || start >= end) {
            node.setNode(listNode);
            return start < end;
        }
 
        // 不长于
        if (!getLastListNode(listNode.next, start + 1, end, node)) {
            ListNode tempNode = listNode.next.next;
 
            listNode.next.next = listNode;
            listNode.next = tempNode;
            return false;
        } else {
            node.setNode(listNode);
            return true;
        }
    }



    // /**
    //  *
    //  * @param head ListNode类
    //  * @param k int整型
    //  * @return ListNode类
    //  */
    // public ListNode reverseKGroup (ListNode head, int k) {
    //     // write code here
    //     if (head == null || head.next == null)
    //         return head;
    
    //     ListNode root, pointer;
    //     root = pointer = null;
    
    //     int count = 0;
    //     AtomicBoolean notSoLong = new AtomicBoolean(false);
    
    //     while (head != null && !notSoLong.get()) {
    //         if (count++ % k == 0) {
    //             if (root == null) {
    //                 root = getLastListNode(head, 0, k - 1, notSoLong);
    //             } else {
    //                 pointer.next = getLastListNode(head, 0, k - 1, notSoLong);
    //             }
    //             pointer = head;
    //             head = head.next;
    //         }
    //     }  ;
    
    //     return root;
    // }
    
    // public ListNode getLastListNode(ListNode node, int start, int end,
    //                                 AtomicBoolean notSoLong) {
    //     if (node == null || node.next == null || start >= end) {
    //         if (start < end) {
    //             notSoLong.set(true);
    //         }
    //         return node;
    //     }
    
    //     ListNode lastNode = getLastListNode(node.next, start + 1, end, notSoLong);
    
    //     if (!notSoLong.get()) {
    //         ListNode tempNode = node.next.next;
    
    //         node.next.next = node;
    //         node.next = tempNode;
    //     } else {
    //         lastNode = node;
    //     }
    
    //     return lastNode;
    // }

}
// @lc code=end

