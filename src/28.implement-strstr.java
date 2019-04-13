/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现strStr()
 *
 * https://leetcode-cn.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (37.24%)
 * Total Accepted:    33.5K
 * Total Submissions: 90K
 * Testcase Example:  '"hello"\n"ll"'
 *
 * 实现 strStr() 函数。
 * 
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 * 
 * 示例 1:
 * 
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 
 * 
 * 说明:
 * 
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * 
 */
class Solution {
    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);
        if (needle.isEmpty())
            return 0;
        int [] next = getNext(needle);
        int lengthOfHaystack = haystack.length();
        int lengthOfNeedle = needle.length();
        int i = 0;
        int j = 0;
        while (i < lengthOfHaystack && j < lengthOfNeedle) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            i++;
        }
        if (j == lengthOfNeedle)
            return i - j;
        return -1;
    }

    public int [] getNext(String subString) {
        int length = subString.length();
        int [] next = new int[length];
        next[0] = 0;
        int i = 1;
        int j = 0;
        while (i < length) {
            while (j > 0 && subString.charAt(i) != subString.charAt(j)) {
                j = next[j - 1];
            }
            if (subString.charAt(i) == subString.charAt(j)) {
                j++;
            }
            next[i++] = j;
        }
        return next;
    }
}
