import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 *
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (45.07%)
 * Likes:    121
 * Dislikes: 0
 * Total Accepted:    15.5K
 * Total Submissions: 34.5K
 * Testcase Example:  '[1,null,2,2]'
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 
 * 假定 BST 有如下定义：
 * 
 * 
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 
 * 
 * 例如：
 * 给定 BST [1,null,2,2],
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  2
 * 
 * 
 * 返回[2].
 * 
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
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

    private int currentTimes = 1;
    private int maxTimes = 0;
    private int currentElements = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getList(root, list);
        int size = list.size();
        int [] nums = new int [size];
        for (int i = 0; i < size; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public void getList(TreeNode root, List<Integer> list) {
        if (root != null) {
            getList(root.left, list);
            if (currentElements == root.val) {
                currentTimes++;
            } else {
                currentTimes = 1;
                currentElements = root.val;
            }
            if (currentTimes >= maxTimes) {
                if (currentTimes > maxTimes) {
                    maxTimes = currentTimes;
                    list.clear();
                }
                list.add(root.val);
            }
            getList(root.right, list);
        }
    }

}
// @lc code=end

