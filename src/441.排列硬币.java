import java.math.BigDecimal;

/*
 * @lc app=leetcode.cn id=441 lang=java
 *
 * [441] 排列硬币
 *
 * https://leetcode-cn.com/problems/arranging-coins/description/
 *
 * algorithms
 * Easy (40.09%)
 * Likes:    52
 * Dislikes: 0
 * Total Accepted:    17.9K
 * Total Submissions: 44.2K
 * Testcase Example:  '5'
 *
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * 
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * 
 * 示例 1:
 * 
 * 
 * n = 5
 * 
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 
 * 因为第三行不完整，所以返回2.
 * 
 * 
 * 示例 2:
 * 
 * 
 * n = 8
 * 
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 
 * 因为第四行不完整，所以返回3.
 * 
 * 
 */


// @lc code=start
class Solution {
    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }
        double x = (double) n;
        return (int) (Math.sqrt(2 * x + 0.25) - 0.5);
    }

    // private double getSqrt(double n) {
    //     double epsilon = 1e-7;
    //     double h = n;
    //     while (Math.abs(h * h - n) > epsilon) {
    //         h = (h + n / h) / 2.0;
    //     }
    //     System.out.println(h);
    //     return h;
    // }
}
// @lc code=end

