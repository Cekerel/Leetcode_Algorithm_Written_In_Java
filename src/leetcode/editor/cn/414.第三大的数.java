import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 *
 * https://leetcode-cn.com/problems/third-maximum-number/description/
 *
 * algorithms
 * Easy (34.39%)
 * Likes:    106
 * Dislikes: 0
 * Total Accepted:    20.1K
 * Total Submissions: 58.5K
 * Testcase Example:  '[3,2,1]'
 *
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 *
 *
 * 示例 2:
 *
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 *
 *
 * 示例 3:
 *
 *
 * 输入: [2, 2, 3, 1]
 *
 * 输出: 1
 *
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *
 *
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        // Arrays.sort(nums);
        // List<Integer> list = new ArrayList<>();
        // int length = nums.length - 1;
        // if (length >= 0) {
        //     list.add(nums[length]);
        // }
        // for (int i = length - 1; i >= 0; i--) {
        //     if (nums[i] != nums[i + 1]) {
        //         list.add(nums[i]);
        //     }
        // }
        // if (list.size() < 3) {
        //     return list.get(0);
        // } else {
        //     return list.get(2);
        // }


        TreeSet<Integer> set = new TreeSet<>(); //红黑树
        for (int i : nums) {
            set.add(i);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        if (set.size() < 3) {
            return set.last();
        } else {
            return set.first();
        }
    }

}
// @lc code=end

