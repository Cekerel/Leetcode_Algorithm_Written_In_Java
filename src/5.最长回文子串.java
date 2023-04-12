/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }

        char[] charArray = s.toCharArray();
        int maxLength = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i; j < charArray.length; j++) {
                if (checkPalindrome(charArray, i, j) && j + 1 - i > maxLength) {
                    startIndex = i;
                    endIndex = j + 1;
                    maxLength = j + 1 - i;
                }
            }
        }
        return s.substring(startIndex, endIndex);
    }

    public boolean checkPalindrome(char[] charArray, int start, int end) {
        while (start < end) {
            if (charArray[start] == charArray[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

