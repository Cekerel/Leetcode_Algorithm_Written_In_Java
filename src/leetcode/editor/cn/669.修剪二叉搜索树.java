/*
 * @lc app=leetcode.cn id=669 lang=java
 *
 * [669] 修剪二叉搜索树
 *
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/description/
 *
 * algorithms
 * Easy (66.95%)
 * Likes:    285
 * Dislikes: 0
 * Total Accepted:    18.3K
 * Total Submissions: 27.3K
 * Testcase Example:  '[1,0,2]\n1\n2'
 *
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L)
 * 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 *
 * 示例 1:
 *
 *
 * 输入:
 * ⁠   1
 * ⁠  / \
 * ⁠ 0   2
 *
 * ⁠ L = 1
 * ⁠ R = 2
 *
 * 输出:
 * ⁠   1
 * ⁠     \
 * ⁠      2
 *
 *
 * 示例 2:
 *
 *
 * 输入:
 * ⁠   3
 * ⁠  / \
 * ⁠ 0   4
 * ⁠  \
 * ⁠   2
 * ⁠  /
 * ⁠ 1
 *
 * ⁠ L = 1
 * ⁠ R = 3
 *
 * 输出:
 * ⁠     3
 * ⁠    /
 * ⁠  2
 * ⁠ /
 * ⁠1
 *
 *
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root != null) {
            if (root.val < low)
                root = trimBST(root.right, low, high);
            else if (root.val > high)
                root = trimBST(root.left, low, high);
            else {
                root.left = trimBST(root.left, low, high);
                root.right = trimBST(root.right, low, high);
            }
        }
        return root;
    }
}
// @lc code=end

