/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
 *
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/description/
 *
 * algorithms
 * Easy (51.54%)
 * Likes:    468
 * Dislikes: 0
 * Total Accepted:    69.1K
 * Total Submissions: 134.1K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 *
 *
 * 示例 :
 * 给定二叉树
 *
 * ⁠         1
 * ⁠        / \
 * ⁠       2   3
 * ⁠      / \
 * ⁠     4   5
 *
 *
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    private int maxLength = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int length = getDepth(root.left, 0) + getDepth(root.right, 0); // 计算根节点中的最大直径 (即左子树深度和右子树深度和)
        maxLength = Math.max(maxLength, length);  //在根节点最大直径和子树最大直径之间取最大值
        return maxLength;
    }

    public int getDepth(TreeNode node, int depth) {
        if (node != null) {
            int leftDepth = getDepth(node.left, depth);
            int rightDepth = getDepth(node.right, depth);
            depth += 1 + Math.max(leftDepth, rightDepth);
            maxLength = Math.max(maxLength, leftDepth + rightDepth);  //计算子树中的最大直径
        }
        return depth;
    }
}
// @lc code=end
