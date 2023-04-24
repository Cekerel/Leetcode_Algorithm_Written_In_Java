import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 *
 * https://leetcode-cn.com/problems/ransom-note/description/
 *
 * algorithms
 * Easy (48.36%)
 * Likes:    75
 * Dislikes: 0
 * Total Accepted:    17K
 * Total Submissions: 32.9K
 * Testcase Example:  '"a"\n"b"'
 *
 * 给定一个赎金信 (ransom)
 * 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回
 * true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 *
 * 注意：
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 *
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char [] charsA = ransomNote.toCharArray();
        char [] charsB = magazine.toCharArray();
        int lengthA = ransomNote.length();
        int lengthB = magazine.length();
        int [] alphabet = new int[26];
        Arrays.fill(alphabet, 0);
        for (int i = 0; i < lengthA; i++) {
            alphabet[(int)(charsA[i] - 'a')]++;
        }
        for (int i = 0; i < lengthB; i++) {
            alphabet[(int)(charsB[i] - 'a')]--;
        }
        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

