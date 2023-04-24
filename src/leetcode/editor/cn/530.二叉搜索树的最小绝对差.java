import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
 *
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * algorithms
 * Easy (57.38%)
 * Likes:    121
 * Dislikes: 0
 * Total Accepted:    17.1K
 * Total Submissions: 29.9K
 * Testcase Example:  '[1,null,3,2]'
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 * ⁠  1
 * ⁠   \
 * ⁠    3
 * ⁠   /
 * ⁠  2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 *
 *
 *
 * 提示：
 *
 *
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * 相同
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
    private int pre = -1;
    private int diffMin = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root != null) {
            getMinimumDifference(root.left);
            if (pre != -1) {
                diffMin = Math.min(diffMin, root.val - pre);
            }
            pre = root.val;
            getMinimumDifference(root.right);
        }
        return diffMin;
    }


    // public int getMinimumDifference(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     getList(root, list);
    //     int diff = Integer.MAX_VALUE;
    //     int length = list.size();
    //     for (int i = 1; i < length; i++) {
    //         diff = Math.min(diff, list.get(i) - list.get(i - 1));
    //     }
    //     return diff;
    // }
    // public void getList(TreeNode root, List<Integer> list) {
    //     if (root != null) {
    //         getList(root.left, list);
    //         list.add(root.val);
    //         getList(root.right, list);
    //     }
    // }




    /**
     * 附录:    一棵所有节点为非负值的二叉搜索树中父子节点的差的绝对值的最小值算法
     *
     */
    // public int getMinimumDifferenceBetweenFatherAndSon(TreeNode root) {
    //     int diff = Integer.MAX_VALUE;
    //     if (root != null) {
    //         if (root.left != null) {
    //             diff = Math.min(diff, Math.min(Math.abs(root.val - root.left.val), getMinimumDifference(root.left)));
    //         }
    //         if (root.right != null) {
    //             diff = Math.min(diff, Math.min(Math.abs(root.val - root.right.val), getMinimumDifference(root.right)));
    //         }
    //     }
    //     return diff;
    // }
}
// @lc code=end

