import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 *
 * https://leetcode-cn.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (58.75%)
 * Likes:    166
 * Dislikes: 0
 * Total Accepted:    17.8K
 * Total Submissions: 29.4K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 输入:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * 输出: ["1->2->5", "1->3"]
 * 
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> nodeList = new ArrayList<>();
        traverse(root, nodeList, "");
        return nodeList;
        // if (root == null) {
        // return new ArrayList<>();
        // } else if (root.left == null && root.right == null) {
        // list.add(Integer.toString(root.val));
        // } else {
        // String string = Integer.toString(root.val);
        // traverse(root.left, list, string);
        // traverse(root.right, list, string);
        // }
    }

    public void traverse(TreeNode node, List<String> list, String string) {
        // if (node == null)
        // return;
        // String str = string + "->" + node.val;
        // if (node.left == null && node.right == null) {
        // list.add(str);
        // } else {
        // traverse(node.left, list, str);
        // traverse(node.right, list, str);
        // }
        
        if (node == null) {
            return;
        }
        String str = string + node.val;
        if (node.left == null && node.right == null) {
            list.add(str);
        } else {
            traverse(node.left, list, str + "->");
            traverse(node.right, list, str + "->");
        }
    }
}
// @lc code=end
