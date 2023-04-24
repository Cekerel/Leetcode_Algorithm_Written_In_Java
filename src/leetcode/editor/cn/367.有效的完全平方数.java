
import java.util.stream.IntStream;
/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 *
 * https://leetcode-cn.com/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (41.55%)
 * Likes:    93
 * Dislikes: 0
 * Total Accepted:    24.1K
 * Total Submissions: 55.6K
 * Testcase Example:  '16'
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 *
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 *
 *
 */

// @lc code=start
class Solution {
    public double sqrt(double x) {
        // double g = x;
        // while (Math.abs(g * g - x) > 1e-6) {
        //     g = (g + x / g) / 2;
        // }
        // return g;

        if (x < 0)
            return Double.NaN;
        double err = 1e-15;
        double t = x;
        while (Math.abs(t - x / t) > err * t) {
            t = (x / t + t) / 2.0;
        }
        return t;
    }

    public boolean isPerfectSquare(int num) {
        double result = sqrt(num);
        return result - ((int) result) < 1e-6;

    }


}
// @lc code=end

