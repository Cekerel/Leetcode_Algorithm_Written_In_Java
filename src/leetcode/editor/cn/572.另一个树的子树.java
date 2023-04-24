import java.util.ArrayList;
import java.util.List;

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
 * Definition for a binary tree node.
 *public class TreeNode {
 *    int val;
 *    TreeNode left;
 *    TreeNode right;
 *    TreeNode() {
 *    }
 *    TreeNode(int val) {
 *        this.val = val;
 *    }
 *    TreeNode(int val, TreeNode left, TreeNode right) {
 *        this.val = val;
 *        this.left = left;
 *        this.right = right;
 *    }
}*/

class Solution {

    // 暴力解法
    // public boolean isSubtree(TreeNode s, TreeNode t) {
    //     if (s != null) {
    //         return subTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
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

    // KMP解法
    public boolean isSubtree(TreeNode s, TreeNode t) {
        List<Integer> sTraverse = new ArrayList<>();
        List<Integer> tTraverse = new ArrayList<>();
        getTreeTraverse(s, sTraverse);
        getTreeTraverse(t, tTraverse);
        return KMP(sTraverse, tTraverse) >= 0;

    }

    public int KMP(List<Integer> s, List<Integer> t) {
        int[] next = getNext(t);
        int now = 0;
        int i = 0;
        while (i < s.size()) {
            if (s.get(i).equals(t.get(now))) {
                i++;
                now++;
            } else if (now != 0) {
                now = next[now - 1];
            } else {
                i++;
            }

            if (now >= next.length) {
                return i - now + 1;
            }
        }
        return -1;
    }

    public int[] getNext(List<Integer> t) {
        int[] next = new int[t.size()];
        next[0] = 0;
        int i = 1;
        int now = 0;
        while (i < next.length) {
            if (t.get(i).equals(t.get(now))) {
                next[i++] = ++now;
            } else if (now != 0){
                now = next[now -1];
            } else {
                next[i++] = now;
            }
        }
        return next;
    }

    public void getTreeTraverse(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            if (node.left != null) {
                getTreeTraverse(node.left, list);
            } else {
                list.add(Integer.MAX_VALUE);
            }
            if (node.right != null) {
                getTreeTraverse(node.right, list);
            } else {
                list.add(Integer.MIN_VALUE);
            }
        }
    }
}
// @lc code=end
