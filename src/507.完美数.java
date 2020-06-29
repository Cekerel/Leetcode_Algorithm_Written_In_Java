
/*
 * @lc app=leetcode.cn id=507 lang=java
 *
 * [507] 完美数
 *
 * https://leetcode-cn.com/problems/perfect-number/description/
 *
 * algorithms
 * Easy (38.26%)
 * Likes:    65
 * Dislikes: 0
 * Total Accepted:    15.1K
 * Total Submissions: 39.5K
 * Testcase Example:  '28'
 *
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 * 
 * 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
 * 
 * 
 * 
 * 示例：
 * 
 * 输入: 28
 * 输出: True
 * 解释: 28 = 1 + 2 + 4 + 7 + 14
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 输入的数字 n 不会超过 100,000,000. (1e8)
 * 
 */

// @lc code=start
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 0) {
            return false;
        }
        int sum = 0;
        int sqrt = (int) (getSqrt(num) + 0.5);
        for (int i = 1; i <= sqrt; i++) {
            if (num % i == 0) {
                sum += i + (num == i * i ? 0 : num / i);
            }
        }
        return sum == num * 2;
    }

    public double getSqrt(double num) {
        double x = num;
        double episilon = 1e-4;
        while (Math.abs(num - x * x) > episilon) {
            x = (x + num / x) / 2.0;
        }
        return x;
    }
}
// @lc code=end
