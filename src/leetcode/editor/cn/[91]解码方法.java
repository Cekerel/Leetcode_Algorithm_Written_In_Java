//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ： 
//
// 
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26" 
//
// 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为： 
//
// 
// "AAJF" ，将消息分组为 (1 1 10 6) 
// "KJF" ，将消息分组为 (11 10 6) 
// 
//
// 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。 
//
// 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "06"
//输出：0
//解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
//
// Related Topics 字符串 动态规划 👍 1373 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        if (s == null || "0".equals(s)) {
            return 0;
        } else if (s.length() <= 1) {
            return s.length();
        } else {
            int [] dp = new int[s.length() + 1];
            char[] chars = s.toCharArray();

            for (int i = 0; i < chars.length; i++) { // 当0前面没有字符, 或者0前面的字符不为1或者2
                if (chars[i] == '0' && (i == 0 || (chars[i - 1] != '1' && chars[i - 1] != '2' ))) {
                    return 0;
                }
            }

            dp[1] = 1; // 第一个位置肯定只有一种方法

            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == '0') { // 如果当前字符为0
                    if (i == 1) { // 当前字符为第2个字符
                        dp[i + 1] = 1;  // 只有一种
                    } else {
                        dp[i + 1] = dp[i - 1]; // 从2个字符之前的位置取译码方案数
                    }
                } else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] <= '6')) { // 当前字符可与上一个字符组合
                    if (i == 1) { // 当前字符为第2个字符
                        dp[i + 1] = 2; // 当前有两种方案
                    } else {
                        dp[i + 1] = dp[i] + dp[i - 1]; // 当前字符的译码方案数等于前一个字符方案数+前两个字符方案数
                    }
                } else {
                    dp[i + 1] = dp[i];
                }
            }
            return dp[chars.length];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
