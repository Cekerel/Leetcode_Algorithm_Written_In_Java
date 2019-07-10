import java.util.Stack;

/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 *
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 *
 * algorithms
 * Easy (70.43%)
 * Likes:    218
 * Dislikes: 0
 * Total Accepted:    20.3K
 * Total Submissions: 28.8K
 * Testcase Example:  '[4,2,7,1,3,6,9]'
 *
 * 翻转一棵二叉树。
 * 
 * 示例：
 * 
 * 输入：
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 2     7
 * ⁠/ \   / \
 * 1   3 6   9
 * 
 * 输出：
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 7     2
 * ⁠/ \   / \
 * 9   6 3   1
 * 
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * 
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> myStack = new Stack<>();
        if (root == null)
            return root;
        TreeNode firstNode = root.left;
        TreeNode secondNode = root.right;
        TreeNode tempNode = null;
        while (myStack.size() != 0 || (firstNode != null || secondNode != null)) {
            if (firstNode != null && secondNode != null) {
                myStack.add(firstNode);
                myStack.add(secondNode);
                firstNode = firstNode.left;
                secondNode = secondNode.right;
            } else {
                secondNode = myStack.pop().left;
                firstNode = myStack.pop().right;
            }
        }

        return root;
    }
}
