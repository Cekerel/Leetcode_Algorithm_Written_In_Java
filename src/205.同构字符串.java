import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 *
 * https://leetcode-cn.com/problems/isomorphic-strings/description/
 *
 * algorithms
 * Easy (44.56%)
 * Likes:    109
 * Dislikes: 0
 * Total Accepted:    12.2K
 * Total Submissions: 27.4K
 * Testcase Example:  '"egg"\n"add"'
 *
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * 
 * 示例 1:
 * 
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 
 * 示例 3:
 * 
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 * 
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int lengths = s.length();
        int lengtht = t.length();
        if (lengths != lengtht) {
            return false;
        }
        if (lengths == 0) {
            return true;
        }
        HashMap<Character, Character> testMaps = new HashMap<>();
        char cs = '\0';
        char ct = '\0';
        for (int i = 0; i < lengths; i++) {
            cs = s.charAt(i);
            ct = t.charAt(i);
            if (testMaps.containsKey(cs)) {
                if (testMaps.get(cs) != ct) {
                    return false;
                }
            } else {
                if (testMaps.containsValue(ct))
                    return false;
                testMaps.put(cs, ct);
            }
        }
        return true;
    }
}
