/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        // 元素和相等
        // 子集数为2
        // 单个子集的和要为 sum[nums[k]] / 2
        // 01背包

        int length = nums.length;

        int sum = 0;
        int pointer = 0;
        while (pointer < length) {
            sum += nums[pointer++];
        }

        if (sum % 2 == 0) {
            int [][] dp = new int[length + 1][sum + 1];
            sum /= 2;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j <= sum; j++) {
                    if (j < nums[i]) {
                        dp[i + 1][j] = dp[i][j];
                    } else {
                        dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - nums[i]] + nums[i]);
                    }
                }
            }
            return dp[length][sum] == sum;
        } else {
            return false;
        }

    
    }
}
// @lc code=end

