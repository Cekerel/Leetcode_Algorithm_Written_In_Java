/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int [][] dp = new int[m][n];

        // 初始化第一行, 若碰到i则之后的全部置0
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                while (i < m) {
                    dp[i++][0] = 0;
                }
            } else {
                dp[i][0] = 1;
            }
        }
        // 初始化第一列, 若碰到i则之后的全部置0
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                while (j < n) {
                    dp[0][j++] = 0;
                }
            } else {
                dp[0][j] = 1;
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i - 1][j] + dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}
// @lc code=end

