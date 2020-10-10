import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=653 lang=java
 *
 * [653] 两数之和 IV - 输入 BST
 *
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/description/
 *
 * algorithms
 * Easy (56.64%)
 * Likes:    181
 * Dislikes: 0
 * Total Accepted:    22.2K
 * Total Submissions: 39.1K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n9'
 *
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 *
 * 输入:
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *
 *
 *
 *
 * 案例 2:
 *
 *
 * 输入:
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 *
 *
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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }

    // public void traverse(TreeNode node, List<Integer> list) {
    //     if (node != null) {
    //         traverse(node.left, list);
    //         list.add(node.val);
    //         traverse(node.right, list);
    //     }
    // }

    // public boolean findTarget(TreeNode root, int k) {
    //     Set<Integer> set = new HashSet<>();
    //     return find(root, set, k);
    // }

    // public boolean find(TreeNode node, Set<Integer> set, int k) {
    //     if (node != null) {
    //         if (set.contains(k - node.val)) {
    //             return true;
    //         }
    //         set.add(node.val);
    //         return find(node.left, set, k) || find(node.right, set, k);
    //     }
    //     return false;
    // }
}
// @lc code=end

