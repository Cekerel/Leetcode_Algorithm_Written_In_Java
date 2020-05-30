import java.util.Arrays;
import java.util.stream.Stream;

/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 *
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/description/
 *
 * algorithms
 * Easy (33.91%)
 * Likes:    50
 * Dislikes: 0
 * Total Accepted:    12.8K
 * Total Submissions: 37.8K
 * Testcase Example:  '"Hello, my name is John"'
 *
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 *
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 *
 *
 */

// @lc code=start
class Solution {
    public int countSegments(String s) {

        // 要优雅(滑稽)
        // return (int) Arrays.asList(s.split("\\s+")).stream().filter(string -> string.length() > 0).count();

        //有限自动机
        boolean symbol = true;
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(!Character.isWhitespace(s.charAt(i)) && symbol) {
                count++;
                symbol = false;
            }
            else if (Character.isWhitespace(s.charAt(i))) {
                symbol = true;
            }
        }
        return count;
    }
}


// @lc code=end
