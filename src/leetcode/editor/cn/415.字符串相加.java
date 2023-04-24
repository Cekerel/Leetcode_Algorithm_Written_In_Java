import java.math.BigDecimal;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 *
 * https://leetcode-cn.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (49.63%)
 * Likes:    135
 * Dislikes: 0
 * Total Accepted:    24.4K
 * Total Submissions: 49.2K
 * Testcase Example:  '"0"\n"0"'
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 *
 */

// @lc code=start
class Solution {
    // public String addStrings(String num1, String num2) {
    //     char [] charsA = null;
    //     char [] charsB = null;
    //     int lengthA = num1.length();
    //     int lengthB = num2.length();
    //     if (lengthA > lengthB) {
    //         charsA = num1.toCharArray();
    //         charsB = (String.format("%0" + (lengthA - lengthB) + "d", 0) + num2).toCharArray();
    //     } else if (lengthA < lengthB) {
    //         charsB = (String.format("%0" + (lengthB - lengthA) + "d", 0) + num1).toCharArray();
    //         charsA = num2.toCharArray();
    //     } else {
    //         charsA = num1.toCharArray();
    //         charsB = num2.toCharArray();
    //     }
    //     int carry = 0;
    //     for (int i = charsB.length - 1; i >= 0; i--) {
    //         int number = (charsA[i] - '0') + (charsB[i] - '0') + carry;
    //         charsA[i] = (char)(number % 10 + '0');
    //         carry = number / 10;
    //     }
    //     return (carry == 1 ? "1" : "") + String.valueOf(charsA);
    // }
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        char [] charsA = num1.toCharArray();
        char [] charsB = num2.toCharArray();
        int lengthA = charsA.length;
        int lengthB = charsB.length;
        int carry = 0;
        for (int i = lengthA - 1, j = lengthB - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
            if (i >= 0) {
                carry += (charsA[i] - '0');
            }
            if (j >= 0) {
                carry += (charsB[j] - '0');
            }
            builder.append(carry % 10);
            carry /= 10;
        }
        return builder.reverse().toString();
    }
}
// @lc code=end

