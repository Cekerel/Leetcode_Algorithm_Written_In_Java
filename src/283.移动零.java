/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (54.94%)
 * Likes:    446
 * Dislikes: 0
 * Total Accepted:    87.4K
 * Total Submissions: 150.4K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 *
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 *
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int slow = 0, fast = 0;
        while (fast < length) {
            if (nums[slow] == 0 && nums[fast] != 0) {
                nums[slow++] = nums[fast];
                nums[fast] = 0;
            } else if (nums[slow] != 0)
                slow++;
            fast++;
        }
        if (slow != 0) {
            for (int i = slow + 1; i < length; i++) {
                nums[i] = 0;
            }
        }
    }
}
// @lc code=end

