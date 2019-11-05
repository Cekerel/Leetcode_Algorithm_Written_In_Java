

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (53.91%)
 * Likes:    123
 * Dislikes: 0
 * Total Accepted:    54.6K
 * Total Submissions: 96.3K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] nums = new int[26];
        Arrays.fill(nums, 0);
        int lengthOfS = s.length();
        int lengthOfT = t.length();
        if (lengthOfS != lengthOfT) {
            return false;
        } else {
            char[] cS = s.toCharArray();
            char[] cT = t.toCharArray();
            for (int i = 0; i < lengthOfS; i++) {
                nums[(int) (cS[i] - 'a')]++;
                nums[(int) (cT[i] - 'a')]--;
            }
            for (int i = 0; i < 26; i++) {
                if (nums[i] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end
