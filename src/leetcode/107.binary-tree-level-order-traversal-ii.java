
/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * algorithms
 * Easy (58.04%)
 * Total Accepted:    9.4K
 * Total Submissions: 16K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其自底向上的层次遍历为：
 * 
 * [
 * ⁠ [15,7],
 * ⁠ [9,20],
 * ⁠ [3]
 * ]
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        List<Integer> numList = new ArrayList<>();
        TreeNode node = new TreeNode(0);
        nodeQueue.offer(root);
        while (nodeQueue.size() != 0) {
            int size = nodeQueue.size();
            numList = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                node = nodeQueue.poll();
                numList.add(node.val);
                if (node.left != null)
                    nodeQueue.offer(node.left);
                if (node.right != null)
                    nodeQueue.offer(node.right);
            }
            finalList.add(0, numList);
        }
        return finalList;
    }
}
