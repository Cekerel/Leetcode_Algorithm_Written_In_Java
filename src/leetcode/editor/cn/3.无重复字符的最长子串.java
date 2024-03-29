import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (35.67%)
 * Likes:    4373
 * Dislikes: 0
 * Total Accepted:    673.6K
 * Total Submissions: 1.9M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 *
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {

        /*
         * 暴力解
         */
        // if (Objects.isNull(s) || s.length() == 0) {
        //     return 0;
        // }
        // char[] charArray = s.toCharArray();
        // int max = 0;
        // for (int i = 0; i < charArray.length; i++) {
        //     int length = 0;
        //     Set<Character> characterSet = new HashSet<>();
        //     for (int j = i; j < charArray.length && !characterSet.contains(charArray[j]); j++) {
        //         characterSet.add(charArray[j]);
        //         length++;
        //     }
        //     max = Math.max(max, length);
        // }
        // return max;

        if (s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
    
}
// @lc code=end

