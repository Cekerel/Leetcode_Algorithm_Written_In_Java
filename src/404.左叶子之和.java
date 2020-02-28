/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 *
 * https://leetcode-cn.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (53.64%)
 * Likes:    126
 * Dislikes: 0
 * Total Accepted:    17.3K
 * Total Submissions: 32.3K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 *
 *
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return traverse(root, false);
    }

    public int traverse(TreeNode node, boolean isLeft) {
        int sum = 0;
        if (node != null) {
            if (node.left == null && node.right == null && isLeft) {
                sum += node.val;
            }
            if (node.left != null) {
                sum += traverse(node.left, true);
            }
            if (node.right != null) {
                sum += traverse(node.right, false);
            }
        }
        return sum;
    }
}
// @lc code=end
