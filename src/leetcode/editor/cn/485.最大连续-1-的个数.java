/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] 最大连续1的个数
 *
 * https://leetcode-cn.com/problems/max-consecutive-ones/description/
 *
 * algorithms
 * Easy (56.46%)
 * Likes:    99
 * Dislikes: 0
 * Total Accepted:    40.1K
 * Total Submissions: 71K
 * Testcase Example:  '[1,0,1,1,0,1]'
 *
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 *
 *
 * 注意：
 *
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 *
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maximum = 0;
        int length = nums.length;
        int pointer = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                pointer++;
            } else {
                pointer = 0;
            }
            maximum = maximum > pointer ? maximum : pointer;
        }
        return maximum;
    }
}
// @lc code=end

