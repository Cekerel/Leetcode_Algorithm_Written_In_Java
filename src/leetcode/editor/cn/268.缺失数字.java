

/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 缺失数字
 *
 * https://leetcode-cn.com/problems/missing-number/description/
 *
 * algorithms
 * Easy (51.37%)
 * Likes:    185
 * Dislikes: 0
 * Total Accepted:    40K
 * Total Submissions: 75.1K
 * Testcase Example:  '[3,0,1]'
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 
 * 示例 1:
 * 
 * 输入: [3,0,1]
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 
 * 
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 * 
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        // int length = nums.length;
        // int sum = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     sum += nums[i];
        // }
        // return (length + 1) * length / 2 - sum;
        int length = nums.length;
        int pointer = length;
        for (int i = 0; i < nums.length; i++) {
            pointer ^= i ^ nums[i];
        }
        return pointer;
    }
}
// @lc code=end

