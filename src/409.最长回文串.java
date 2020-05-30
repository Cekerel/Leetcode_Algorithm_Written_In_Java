import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 *
 * https://leetcode-cn.com/problems/longest-palindrome/description/
 *
 * algorithms
 * Easy (52.08%)
 * Likes:    102
 * Dislikes: 0
 * Total Accepted:    16.3K
 * Total Submissions: 31.3K
 * Testcase Example:  '"abccccdd"'
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 *
 */

// @lc code=start
class Solution {
    // public int longestPalindrome(String s) {
    //     char [] chars = s.toCharArray();
    //     Map<Character, Integer> map = new HashMap<>();
    //     for (char c : chars) {
    //         map.merge(c, 1, Integer::sum);
    //     }
    //     int sum = 0;
    //     boolean extra = false;
    //     Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
    //     for (Map.Entry<Character, Integer> entry : entrySet) {
    //         if (entry.getValue() % 2 == 1) {
    //             extra = true;
    //         }
    //         sum += entry.getValue() / 2 * 2;
    //     }
    //     if (extra) {
    //         sum++;
    //     }
    //     return sum;
    // }

    public int longestPalindrome(String s) {
        int [] nums = new int [52];
        Arrays.fill(nums, 0);
        boolean extra = false;
        char [] chars = s.toCharArray();
        for (char c : chars) {
            if (((int)c) < 91)
                nums[((int)(c - 'A')) + 26]++;
            else
                nums[((int)(c - 'a'))]++;
        }
        int sum = 0;
        for (int i : nums) {
            if (i % 2 == 1) {
                extra = true;
            }
            sum += i / 2 * 2;
        }
        if (extra) {
            sum++;
        }
        return sum;
    }
}
// @lc code=end

