/*
 * @lc app=leetcode.cn id=551 lang=java
 *
 * [551] 学生出勤记录 I
 *
 * https://leetcode-cn.com/problems/student-attendance-record-i/description/
 *
 * algorithms
 * Easy (51.67%)
 * Likes:    50
 * Dislikes: 0
 * Total Accepted:    18.2K
 * Total Submissions: 35.3K
 * Testcase Example:  '"PPALLP"'
 *
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 *
 *
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 *
 *
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 *
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 *
 * 示例 1:
 *
 * 输入: "PPALLP"
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入: "PPALLL"
 * 输出: False
 *
 *
 */

// @lc code=start
class Solution {
    public boolean checkRecord(String s) {


        // return s.length() - s.replaceAll("A", "").length() < 2 && s.length() - s.replaceAll("LLL", "").length() < 3;

        // char[] charArray = s.toCharArray();
        // int countA = 0;
        // for (int i = 0; i < charArray.length; i++) {
        //     if (charArray[i] == 'A' && ++countA >= 2) {
        //         return false;
        //     }
        //     int startLLL = i;
        //     int endLLL = i;
        //     while (endLLL < charArray.length && charArray[endLLL] == 'L') {
        //         endLLL++;
        //     }
        //     if (endLLL - startLLL >= 3) {
        //         return false;
        //     }
        // }
        // return true;

        char[] chars = s.toCharArray();
        int numA = 0;
        int numL = 0;
        int longestL = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'A') {
                numA++;
                if (numA > 1) {
                    return false;
                }
            }
            if (chars[i] == 'L') {
                numL++;
                if (numL > 2)
                    return false;
            } else {
                numL = 0;
            }
            // longestL = Math.max(longestL, numL);
        }
        // return numA < 2 && longestL < 3;

        return true;
    }
}
// @lc code=end

