/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (31.06%)
 * Total Accepted:    73.2K
 * Total Submissions: 235.6K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: 321
 * 
 * 
 * 示例 2:
 * 
 * 输入: -123
 * 输出: -321
 * 
 * 
 * 示例 3:
 * 
 * 输入: 120
 * 输出: 21
 * 
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 
 */
class Solution {
    public int reverse(int x) {
        int number = 0;
        boolean overflow = false;
        String numberString = Integer.toString(x);
        boolean containsInterval = numberString.contains("-");
        StringBuffer buffer = new StringBuffer(numberString);
        java.math.BigInteger integer = new java.math.BigInteger(containsInterval == true ? "-" + buffer.reverse().toString().replace("-", "") : buffer.reverse().toString());
        java.math.BigInteger integerMax = new java.math.BigInteger(Integer.toString(Integer.MAX_VALUE));
        java.math.BigInteger integerMin = new java.math.BigInteger(Integer.toString(Integer.MIN_VALUE));
        
        if ((!containsInterval && integer.compareTo(integerMax) == 1) || (containsInterval && integer.compareTo(integerMin) == -1))
            overflow = true;
        else
            number = Integer.parseInt(integer.toString());
        return overflow == true ? 0 : number;
    }
}
