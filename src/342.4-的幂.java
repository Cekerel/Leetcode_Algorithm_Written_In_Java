/*
 * @lc app=leetcode.cn id=342 lang=java
 *
 * [342] 4的幂
 *
 * https://leetcode-cn.com/problems/power-of-four/description/
 *
 * algorithms
 * Easy (45.91%)
 * Likes:    73
 * Dislikes: 0
 * Total Accepted:    17K
 * Total Submissions: 35.8K
 * Testcase Example:  '16'
 *
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 16
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: 5
 * 输出: false
 * 
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * 
 */

// @lc code=start
class Solution {
    public boolean isPowerOfFour(int num) {
        // return Integer.toString(num, 4).matches("^10*$");
        // if (num == 0) {
        //     return false;
        // } else {
        //     while (num % 4 == 0) {
        //         num /= 4;
        //     }
        //     return num == 1;
        // }
        double epsilon = 1e-7;
        return ((Math.log(num) / Math.log(4)) % 1 + epsilon) <= 2 * epsilon;

    }
}
// @lc code=end

