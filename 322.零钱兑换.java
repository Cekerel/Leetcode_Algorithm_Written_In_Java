/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {

        /*
         *  二维dp 
         */
        // if (amount <= 0) {
        //     return amount;
        // }
        // int length = coins.length;

        // int[][] dp = new int[length + 1][amount + 1];

        // for (int i = 0; i < length + 1; i++) {
        //     dp[i][0] = 0;
        //     for (int j = 1; j < amount + 1; j++) {
        //         dp[i][j] = amount + 1;
        //     }
        // }

        // for (int i = 0; i < length; i++) {   // 对于每个硬币面额
        //     for (int j = 0; j <= amount; j++) { // 对于每个金额
        //         if (j < coins[i]) {
        //             dp[i + 1][j] = dp[i][j];
        //         } else {
        //             // for (int k = 0; k * coins[i] <= j; k++) {
        //             //     dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j - k * coins[i]] + k);
        //             // }
        //             dp[i + 1][j] = Math.min(dp[i][j], dp[i + 1][j - coins[i]] + 1);
        //         }
        //     }
        // }
        // return dp[length][amount] == amount + 1 ? -1 : dp[length][amount];


        /*
         * 一维dp
         */
        if (amount <= 0) {
            return amount;
        }
        int length = coins.length;

        int[] dp = new int[amount + 1];

        for (int j = 1; j < amount + 1; j++) {
            dp[j] = amount + 1;
        }
        dp[0] = 0;

        for (int i = 0; i < length; i++) {   // 对于每个硬币面额
            for (int j = 0; j <= amount; j++) { // 对于每个金额
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
// @lc code=end

