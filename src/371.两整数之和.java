
/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 *
 * https://leetcode-cn.com/problems/sum-of-two-integers/description/
 *
 * algorithms
 * Easy (51.67%)
 * Likes:    186
 * Dislikes: 0
 * Total Accepted:    21.4K
 * Total Submissions: 39.9K
 * Testcase Example:  '1\n2'
 *
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * 
 * 示例 1:
 * 
 * 输入: a = 1, b = 2
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: a = -2, b = 3
 * 输出: 1
 * 
 */

// @lc code=start
class Solution {
    // 两个整数a, b; a ^ b是无进位的相加； a&b得到每一位的进位；让无进位相加的结果与进位不断的异或，每次异或之后得到的进位需要左移一位, 直到进位值为0；
    // 这种算法 妙啊
    public int getSum(int a, int b) {
        if (b != 0) {
            return getSum(a ^ b, (a & b) << 1);
        }
        return a;
    }
}
// @lc code=end