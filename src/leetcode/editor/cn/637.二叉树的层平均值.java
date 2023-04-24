import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
 *
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/description/
 *
 * algorithms
 * Easy (65.19%)
 * Likes:    160
 * Dislikes: 0
 * Total Accepted:    25.4K
 * Total Submissions: 38.9K
 * Testcase Example:  '[3,9,20,15,7]'
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 节点值的范围在32位有符号整数范围内。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, List<TreeNode>> levels = new HashMap<>();
        levelTraverse(root, 1, levels);
        if (levels.size() != 0) {
            // return levels.keySet().stream().map(k -> (List<TreeNode>) levels.get(k)).map(
            //         l -> l.stream().map(node -> Double.valueOf(node.val)).reduce(Double::sum).orElse(0.0D) / l.size())
            //         .collect(Collectors.toList());
            List<Double> average = new ArrayList<>();
            levels.values().forEach(l -> {
                Double sum = Double.valueOf(0.0D);
                for (TreeNode node : l) {
                    sum += node.val;
                }
                average.add(sum / l.size());
            });
            return average;

        }
        return new ArrayList<>();
    }

    public void levelTraverse(TreeNode node, int level, Map<Integer, List<TreeNode>> map) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(level)) {
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(node);
        levelTraverse(node.left, level + 1, map);
        levelTraverse(node.right, level + 1, map);
    }
}
// @lc code=end
