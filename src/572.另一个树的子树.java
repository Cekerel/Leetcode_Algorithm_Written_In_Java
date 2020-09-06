/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一个树的子树
 *
 * https://leetcode-cn.com/problems/subtree-of-another-tree/description/
 *
 * algorithms
 * Easy (47.02%)
 * Likes:    345
 * Dislikes: 0
 * Total Accepted:    48.7K
 * Total Submissions: 103.5K
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'
 *
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s
 * 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 *
 *
 * 给定的树 t：
 *
 *
 * ⁠  4
 * ⁠ / \
 * ⁠1   2
 *
 *
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * ⁠   /
 * ⁠  0
 *
 *
 * 给定的树 t：
 *
 *
 * ⁠  4
 * ⁠ / \
 * ⁠1   2
 *
 *
 * 返回 false。
 *
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    // public boolean isSubtree(TreeNode s, TreeNode t) {
    //     if (s != null) {
    //         return subTree(s, t) || isSubtree(s.left, t) || subTree(s.right,t);
    //     }
    //     return false;
    // }
    // public boolean subTree(TreeNode s, TreeNode t) {
    //     if (s == null && t == null)
    //         return true;
    //     if (s != null && t != null && s.val == t.val) {
    //         return subTree(s.left, t.left) && subTree(s.right, t.right);
    //     }
    //     return false;
    // }


    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
//t是s的子树，要么t等于s，要么t等于s的左/右子树。
        return subFrom(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean subFrom(TreeNode s, TreeNode t){
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return subFrom(s.left, t.left) && subFrom(s.right, t.right);
    }
}
// @lc code=end
