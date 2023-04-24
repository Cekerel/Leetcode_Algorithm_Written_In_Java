/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel表列序号
 *
 * https://leetcode-cn.com/problems/excel-sheet-column-number/description/
 *
 * algorithms
 * Easy (63.22%)
 * Total Accepted:    10.7K
 * Total Submissions: 16.9K
 * Testcase Example:  '"A"'
 *
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * 
 * 例如，
 * 
 * ⁠   A -> 1
 * ⁠   B -> 2
 * ⁠   C -> 3
 * ⁠   ...
 * ⁠   Z -> 26
 * ⁠   AA -> 27
 * ⁠   AB -> 28 
 * ⁠   ...
 * 
 * 
 * 示例 1:
 * 
 * 输入: "A"
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入: "AB"
 * 输出: 28
 * 
 * 
 * 示例 3:
 * 
 * 输入: "ZY"
 * 输出: 701
 * 
 * 致谢：
 * 特别感谢 @ts 添加此问题并创建所有测试用例。
 * 
 */
class Solution {
    public int titleToNumber(String s) {
        int length = s.length();
        int difference = 0;
        if (length == 1) {
            difference = s.charAt(0) - 'A' + 1;
        } else {
            for (int i = length - 1; i >= 0; i--) {
                if (i == length - 1) {
                    difference = s.charAt(i) - 'A' + 1;
                } else {
                    difference += (s.charAt(i) - 'A' + 1) * Math.pow(26, length - 1 - i);
                }
            }
        }
        return difference;
    }
}
