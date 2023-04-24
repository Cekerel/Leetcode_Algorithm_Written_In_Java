import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import javafx.scene.shape.Ellipse;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (35.86%)
 * Total Accepted:    41.5K
 * Total Submissions: 115.7K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */
class Solution {
    public boolean isValid(String s) {
        if (s == null) 
            return true;
        Stack<Character> charStack = new Stack<>();
        int length = s.length();
        char c = '\0';
        for (int i = 0; i < length; i++) {
            c = s.charAt(i);
            if(c == '{' || c == '[' || c == '(') {
                charStack.push(c);
            }
            else if (c == '}' || c == ']' || c == ')') {
                if (charStack.size() == 0) {
                    return false;
                } else {
                    if (c == '}' && charStack.peek() == '{') {
                        charStack.pop();
                    } else if (c == ']' && charStack.peek() == '[') {
                        charStack.pop();
                    } else if (c == ')' && charStack.peek() == '(') {
                        charStack.pop();
                    } else
                        return false;
                }
            }
        }
        if (charStack.size() != 0)
            return false;
        else
            return true;
    }
}
