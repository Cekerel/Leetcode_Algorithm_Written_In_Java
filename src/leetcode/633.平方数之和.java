/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 *
 * https://leetcode-cn.com/problems/sum-of-square-numbers/description/
 *
 * algorithms
 * Easy (33.79%)
 * Likes:    137
 * Dislikes: 0
 * Total Accepted:    28.6K
 * Total Submissions: 84.7K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a^2 + b^2 = c。
 *
 * 示例1:
 *
 *
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *
 *
 *
 *
 * 示例2:
 *
 *
 * 输入: 3
 * 输出: False
 *
 *
 */

// @lc code=start
class Solution {
    // public boolean judgeSquareSum(int c) {
    //     for (long a = 0; a * a <= c; a++) {
    //         int b = c - (int)(a * a);
    //         if (binary_search(0, b, b))
    //             return true;
    //     }
    //     return false;
    // }
    // public boolean binary_search(long s, long e, int n) {
    //     if (s > e)
    //         return false;
    //     long mid = s + (e - s) / 2;
    //     if (mid * mid == n)
    //         return true;
    //     if (mid * mid > n)
    //         return binary_search(s, mid - 1, n);
    //     return binary_search(mid + 1, e, n);
    // }

    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}
// @lc code=end

