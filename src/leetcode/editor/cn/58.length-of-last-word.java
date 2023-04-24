import java.util.Stack;

/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 *
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (28.28%)
 * Total Accepted:    16.3K
 * Total Submissions: 57.1K
 * Testcase Example:  '"Hello World"'
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 
 * 如果不存在最后一个单词，请返回 0 。
 * 
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 
 * 示例:
 * 
 * 输入: "Hello World"
 * 输出: 5
 * 
 * 
 */
class Solution {
    public int lengthOfLastWord(String s) {
        // String [] tempString = s.split(" ");
        // int length = tempString.length;
        // System.out.println(length);
        // if (length == 0) {
        //     return length;
        // } else {
        //     return tempString[length - 1].length();
        // }
        int length = s.length();
        boolean marker = false;
        Stack<Character> tempStack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i); 
            if (c != ' ') {
                if (marker) {
                    tempStack.removeAllElements();
                    marker = false;
                }
                tempStack.push(c);
            } else {
                if (!marker) {
                    marker = true;
                }
            }
        }
        return tempStack.size();
    }
}
