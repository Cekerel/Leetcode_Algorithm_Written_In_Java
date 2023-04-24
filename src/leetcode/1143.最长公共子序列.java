import java.util.Objects;

/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (Objects.isNull(text1) || Objects.isNull(text2)) {
            return 0;
        }

        char[] textArray1 = text1.toCharArray();
        char[] textArray2 = text2.toCharArray();

        int[][] dp = new int[textArray1.length + 1][textArray2.length + 1];

        for (int i = 0; i < textArray1.length; i++) {
            for (int j = 0; j < textArray2.length; j++) {
                if (textArray1[i] == textArray2[j]) {
                    dp[i + 1][j + 1] = Math.max(dp[i][j] + 1, Math.max(dp[i + 1][j], dp[i][j + 1]));
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[textArray1.length][textArray2.length];
    }
}
// @lc code=end
