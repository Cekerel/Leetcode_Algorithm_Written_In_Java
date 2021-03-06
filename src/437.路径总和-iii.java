/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 *
 * https://leetcode-cn.com/problems/path-sum-iii/description/
 *
 * algorithms
 * Easy (54.21%)
 * Likes:    336
 * Dislikes: 0
 * Total Accepted:    26.7K
 * Total Submissions: 48.9K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 
 * 找出路径和等于给定数值的路径总数。
 * 
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * 
 * 示例：
 * 
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 
 * ⁠     10
 * ⁠    /  \
 * ⁠   5   -3
 * ⁠  / \    \
 * ⁠ 3   2   11
 * ⁠/ \   \
 * 3  -2   1
 * 
 * 返回 3。和等于 8 的路径有:
 * 
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
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
    // public int pathSum(TreeNode root, int sum) {
    //     return getPathNum(root, sum, sum);
    // }

    // public int getPathNum(TreeNode node, int difference, int sum) {
    //     if (node == null) {
    //         return 0;
    //     }
    //     int counter = 0;
    //     if (node.val == difference) {
    //         counter++;
    //     }
    //     if (node.left != null) {
    //         counter += getPathNum(node.left, difference - node.val, sum);
    //         counter += getPathNum(node.left, sum, sum);
    //     }
    //     if (node.right != null) {
    //         counter += getPathNum(node.right, difference - node.val, sum);
    //         counter += getPathNum(node.right, sum, sum);
    //     }
    //     return counter;
    // }


    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int dfs(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        sum -= node.val;
        return (sum == 0 ? 1 : 0) + dfs(node.left, sum) + dfs(node.right, sum);
    }
}
// @lc code=end

