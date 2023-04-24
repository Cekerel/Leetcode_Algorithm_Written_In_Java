/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
 *
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/description/
 *
 * algorithms
 * Easy (62.24%)
 * Likes:    278
 * Dislikes: 0
 * Total Accepted:    30.6K
 * Total Submissions: 49.1K
 * Testcase Example:  '[5,2,13]'
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater
 * Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 * ⁠             5
 * ⁠           /   \
 * ⁠          2     13
 *
 * 输出: 转换为累加树:
 * ⁠            18
 * ⁠           /   \
 * ⁠         20     13
 *
 *
 *
 *
 * 注意：本题和 1038:
 * https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 *
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // public TreeNode convertBST(TreeNode root) {
    //     calculate(root, 0);
    //     return root;
    // }

    // public void calculate(TreeNode node, int previousValue) {
    //     if (node != null) {
    //         node.val = node.val + previousValue + getSum(node.right);
    //         calculate(node.left, node.val);
    //         calculate(node.right, previousValue);
    //     }
    // }

    // public int getSum(TreeNode node) {
    //     int sum = 0;
    //     if (node != null) {
    //         return node.val + getSum(node.left) + getSum(node.right);
    //     }
    //     return sum;
    // }


    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
// @lc code=end

