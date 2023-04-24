/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int currentPathSum = root.val;
        TreeNode leftNode = root.left;
        int leftSum = 0;
        while (leftNode != null) {
            leftSum += leftNode.val;
            leftNode = leftNode.left;
        }

        TreeNode rightNode = root.right;
        int rightSum = 0;
        while (rightNode != null) {
            rightSum += rightNode.val;
            rightNode = rightNode.right;
        }


        int leftPathSum = Integer.MIN_VALUE;
        int rightPathSum = Integer.MIN_VALUE;
        if (root.left != null) {
            leftPathSum = Math.max(leftPathSum, maxPathSum(root.left));
        }
        if (root.right != null) {
            rightPathSum = Math.max(rightPathSum, maxPathSum(root.right));
        }
        return Math.max(leftPathSum, Math.max(rightPathSum, Math.max(root.val, Math.max(root.val + leftSum, Math.max(root.val + rightSum, root.val + leftSum + rightSum)))));
    }
}
// @lc code=end

