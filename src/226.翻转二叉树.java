import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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

        // 迭代版本实现
        // if (root == null) {
        //     return root;
        // }
        // TreeNode node = root;
        // Queue<TreeNode> myQueue = new LinkedList<>();
        // while (!myQueue.isEmpty() || node != null){
        //     if (node != null) {
        //         TreeNode temp = node.left;
        //         node.left = node.right;
        //         node.right = temp;
        //         if (node.right != ) {
                    
        //         }
        //             myQueue.offer();
        //     }
        // }

        // 递归版本实现
        if (root != null) {
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        invertTree(root.left);
        invertTree(root.right);
        }
        return root;
    }
}
