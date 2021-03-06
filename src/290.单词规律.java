import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 *
 * https://leetcode-cn.com/problems/word-pattern/description/
 *
 * algorithms
 * Easy (39.41%)
 * Likes:    120
 * Dislikes: 0
 * Total Accepted:    15.5K
 * Total Submissions: 37.3K
 * Testcase Example:  '"abba"\n"dog cat cat dog"'
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 
 * 示例1:
 * 
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 
 * 示例 4:
 * 
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 * 
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String str) {
        String [] strings = str.split(" ");
        int length = pattern.length();
        if (length != strings.length) {
            return false;
        }
        char [] chars = pattern.toCharArray();
        Map<Character, String> stringMap = new HashMap<>();
        String string = new String();
        for (int i = 0; i < length; i++) {
            string = stringMap.get(chars[i]);
            if (string != null) {
                if (!string.equals(strings[i])) {
                    return false;
                }
            } else if (stringMap.containsValue(strings[i]))
                return false;
            else
                stringMap.put(chars[i], strings[i]);
        }
        return true;
    }
}
// @lc code=end

