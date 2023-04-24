/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (31.35%)
 * Total Accepted:    45.5K
 * Total Submissions: 145.1K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return new String();
        else if (strs.length == 1)
            return strs[0];
        int length = strs[0].length(); 
        int strlen = 0;
        for (String string : strs) {
            if (length >= (strlen = string.length())) {
                length = strlen;
            }
            if(string.length() == 0)
                return new String();
        }
        int index = 0;
        int sum = strs.length;
        boolean isBreak = false;
        char c = '\0';
        for (int i = 0; i < length; i++) {
            c = strs[0].charAt(i);
            for (int j = 1; j < sum; j++) {
                if (c != strs[j].charAt(i)) {
                    isBreak = true;
                    break;
                }
            }
            if (isBreak == true) {
                break;
            }
            index = i + 1;
        }
        return strs[0].substring(0, index).toString();
    }
}
