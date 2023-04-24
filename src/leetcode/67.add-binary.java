

/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (45.51%)
 * Total Accepted:    15.4K
 * Total Submissions: 33.6K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
        java.math.BigInteger aInteger = new java.math.BigInteger(a);
        java.math.BigInteger bInteger = new java.math.BigInteger(b);
        aInteger =  aInteger.add(bInteger);
        char [] chars = aInteger.toString().toCharArray();
        int length = chars.length;
        boolean carry = false;
        if (length != 0) {        
            for (int i = length - 1; i >= 0; i--) {
                if (carry) {
                    if (chars[i] == '0') {
                        chars[i] = '1';
                        carry = false;
                    } else {
                        if(chars[i] == '2')
                            chars[i] = '1';
                        else if (chars[i] == '1')
                            chars[i] = '0';
                        if (i == 0) {
                            return "1" + new String(chars);
                        }
                    } 
                } else {
                    if(chars[i] == '2') {
                        chars[i] = '0';
                        if (i == 0)
                            return "1" + new String(chars);
                        else 
                            carry = true;
                    }
                }
            }
        }
        return new String(chars);
    }
}
