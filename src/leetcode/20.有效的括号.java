import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (Objects.isNull(s) || s.length() < 2) {
            return false;
        }
        Stack<Character> characterStack = new Stack<>();

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '{' || charArray[i] == '[' || charArray[i] == '(') {
                characterStack.push(charArray[i]);
            } else if (characterStack.isEmpty()) {
                return false;
            }
            if (charArray[i] == ')' && characterStack.pop() != '(') {
                return false;
            }
            if (charArray[i] == ']' && characterStack.pop() != '[') {
                return false;
            }
            if (charArray[i] == '}' && characterStack.pop() != '{') {
                return false;
            }
        }
        return characterStack.isEmpty();
    }
}
// @lc code=end

