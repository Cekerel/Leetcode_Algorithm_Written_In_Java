/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 *
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (47.16%)
 * Likes:    66
 * Dislikes: 0
 * Total Accepted:    21.4K
 * Total Submissions: 44K
 * Testcase Example:  '"hello"'
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 * 示例 1:
 * 
 * 输入: "hello"
 * 输出: "holle"
 * 
 * 
 * 示例 2:
 * 
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 
 * 说明:
 * 元音字母不包含字母"y"。
 * 
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        int length = s.length();
        if (length == 0) {
            return s;
        }
        char [] chars = s.toCharArray();
        int left = 0, right = length - 1;
        while(left < right) {
            if (isVowel(chars[left]) && isVowel(chars[right])) {
                char c = chars[left];
                chars[left] = chars[right];
                chars[right] = c;
                left++;
                right--;
            } else if (!isVowel(chars[left]) && isVowel(chars[right])) {
                left++;
            } else if (isVowel(chars[left]) && !isVowel(chars[right])) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return new String(chars);
    }
    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        } 
        return false;
    }
}
// @lc code=end

