/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
 *
 * https://leetcode-cn.com/problems/binary-tree-tilt/description/
 *
 * algorithms
 * Easy (56.24%)
 * Likes:    82
 * Dislikes: 0
 * Total Accepted:    16.1K
 * Total Submissions: 28.6K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个二叉树，计算整个树的坡度。
 *
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 *
 * 整个树的坡度就是其所有节点的坡度之和。
 *
 *
 *
 * 示例：
 *
 * 输入：
 * ⁠        1
 * ⁠      /   \
 * ⁠     2     3
 * 输出：1
 * 解释：
 * 结点 2 的坡度: 0
 * 结点 3 的坡度: 0
 * 结点 1 的坡度: |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 *
 *
 *
 *
 * 提示：
 *
 *
 * 任何子树的结点的和不会超过 32 位整数的范围。
 * 坡度的值不会超过 32 位整数的范围。
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // public int findTilt(TreeNode root) {
    //     int tilt = 0;
    //     if (root != null) {
    //         tilt += Math.abs(getSum(root.left) - getSum(root.right)) + findTilt(root.right) + findTilt(root.left);
    //     }
    //     return tilt;
    // }

    // public int getSum(TreeNode node) {
    //     int sum = 0;
    //     if (node != null) {
    //         sum = getSum(node.left) + getSum(node.right) + node.val;
    //     }
    //     return sum;
    // }

    int tilt = 0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }

    public int traverse(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = traverse(node.left);
        int right = traverse(node.right);
        tilt += Math.abs(left - right);
        return node.val + left + right;
    }

}
// @lc code=end

