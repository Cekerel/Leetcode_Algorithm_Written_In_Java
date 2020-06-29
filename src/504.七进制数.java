import java.util.Stack;

/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 *
 * https://leetcode-cn.com/problems/base-7/description/
 *
 * algorithms
 * Easy (49.22%)
 * Likes:    45
 * Dislikes: 0
 * Total Accepted:    12.7K
 * Total Submissions: 25.9K
 * Testcase Example:  '100'
 *
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 100
 * 输出: "202"
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: -7
 * 输出: "-10"
 * 
 * 
 * 注意: 输入范围是 [-1e7, 1e7] 。
 * 
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        //  return Integer.toString(num, 7);
        
        
        
        
        // if (num == 0) {
        //     return "0";
        // }
        // Stack<Integer> stack = new Stack<>();
        // int number = Math.abs(num);
        // while (number != 0) {
        //     stack.push(number % 7);
        //     number /= 7;
        // }
        // StringBuilder builder = new StringBuilder();
        // builder.append(num >= 0 ? "" : "-");
        // while (!stack.isEmpty()) {
        //     builder.append(stack.pop());
        // }
        // return builder.toString();


        if (num < 0) 
            return "-" + convertToBase7(-1 * num);
        if (num < 7)
            return Integer.toString(num);
        else
            return convertToBase7(num / 7) + Integer.valueOf(num % 7);
    }
}
// @lc code=end

