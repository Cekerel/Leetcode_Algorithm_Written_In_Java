/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 *
 * https://leetcode-cn.com/problems/valid-palindrome-ii/description/
 *
 * algorithms
 * Easy (39.90%)
 * Likes:    272
 * Dislikes: 0
 * Total Accepted:    53.8K
 * Total Submissions: 134.7K
 * Testcase Example:  '"aba"'
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "aba"
 * 输出: True
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 
 * 
 * 注意:
 * 
 * 
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 * 
 * 
 */

// @lc code=start
class Solution {
    // public boolean validPalindrome(String s) {
    //     int i = 0, j = s.length() - 1;
    //     while (i < j) {
    //         if (s.charAt(i) != s.charAt(j)) {
    //             return isValid(s, i + 1, j) || isValid(s, i, j - 1);
    //         }
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }

    // public boolean isValid(String s, int i, int j) {
    //     while (i < j) {
    //         if (s.charAt(i) != s.charAt(j)) {
    //             return false;
    //         }
    //         i++;
    //         j--;
    //     }
    //     return true;
    // }
    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        char [] chars = s.toCharArray();
        while (low < high) {
            char c1 = chars[low], c2 = chars[high];
            if (c1 == c2) {
                low++;
                high--;
            } else {
                boolean flag1 = true, flag2 = true;
                for (int i = low, j = high - 1; i < j; i++, j--) {
                    char c3 = chars[i], c4 = chars[j];
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = low + 1, j = high; i < j; i++, j--) {
                    char c3 = chars[i], c4 = chars[j];
                    if (c3 != c4) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }
}
// @lc code=end

