/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 *
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/description/
 *
 * algorithms
 * Easy (39.17%)
 * Likes:    111
 * Dislikes: 0
 * Total Accepted:    19.7K
 * Total Submissions: 50.3K
 * Testcase Example:  '[1,12,-5,-6,50,3]\n4'
 *
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例 1:
 *
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 *
 *
 * 注意:
 *
 *
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 *
 *
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0D;
        double average = Double.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        average = sum * 1.0D / k;
        double maxAverage = average;
        for (int i = k; i < nums.length; i++) {
            average += (nums[i] - nums[i - k]) * 1.0D / k;
            maxAverage = Math.max(maxAverage, average);
        }
        return maxAverage;
    }
}
// @lc code=end

