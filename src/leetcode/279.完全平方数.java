/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        /*
         * 二维dp
         */
        // int MAX_N = (int) Math.sqrt(n);

        // int [] [] dp = new int[MAX_N + 1][n + 1];
        // for (int i = 0; i <= MAX_N; i++) {
        //     dp[i][0] = 0;
        //     for (int j = 1; j <= n; j++) {
        //         dp[i][j] = n + 1;
        //     }
        // }

        // for (int i = 0; i < MAX_N; i++) {
        //     for (int j = 0; j <= n; j++) {
        //         if (j < (i + 1) * (i + 1)) {
        //             dp[i + 1][j] = dp[i][j];
        //         } else {
        //             dp[i + 1][j] = Math.min(dp[i][j], dp[i + 1][j - (i + 1) * (i + 1)] + 1);
        //         }
        //     }
        // }
        // return dp[MAX_N][n];

        /*
         * 一维dp
         */
        int MAX_N = (int) Math.sqrt(n);

        int [] dp = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            dp[j] = n + 1;
        }
        dp[0] = 0;

        for (int i = 0; i < MAX_N; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= (i + 1) * (i + 1)) {
                    dp[j] = Math.min(dp[j], dp[j - (i + 1) * (i + 1)] + 1);
                }
            }
        }
        return dp[n];
    }
}
// @lc code=end

