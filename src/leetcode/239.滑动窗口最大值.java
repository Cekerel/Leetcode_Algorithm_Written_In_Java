/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 *
 * https://leetcode-cn.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (49.61%)
 * Likes:    823
 * Dislikes: 0
 * Total Accepted:    122.1K
 * Total Submissions: 246.7K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k
 * 个数字。滑动窗口每次只向右移动一位。
 * 
 * 返回滑动窗口中的最大值。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * -10^4 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= k) {
            return new int[] { getMaximum(nums, 0, k) };
        } else {
            int size = nums.length - k + 1;
            int[] ans = new int[size];
            ans[0] = getMaximum(nums, 0, k);
            for (int i = k; i < nums.length; i++) {
                if (nums[i - k] == ans[i - k]) {
                    ans[i - k + 1] = getMaximum(nums, i - k + 1, i + 1);
                } else {
                    if (ans[i - k] <= nums[i]) {
                        ans[i - k + 1] = nums[i];
                    } else {
                        ans[i - k + 1] = ans[i - k];
                    }
                }
            }
            return ans;
        }
    }
    
    public int getMaximum(int[] nums, int start, int end) {
        int maximum = nums[start];
        for (int i = start; i < end; i++) {
            maximum = Math.max(maximum, nums[i]);
        }
        return maximum;
    }
}
// @lc code=end

