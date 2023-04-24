/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        int [][] dp = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                dp[i][j] = matrix[i][j] - '0';
            }
        }

        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] > '0') {
                    if (i == 0 || j == 0) {
                        // 边缘为1的正方形面积即为1
                        dp[i][j] = 1;
                    } else {
                        // 
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
// @lc code=end

