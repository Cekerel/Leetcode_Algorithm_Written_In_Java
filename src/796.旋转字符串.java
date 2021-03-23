/*
 * @lc app=leetcode.cn id=796 lang=java
 *
 * [796] 旋转字符串
 *
 * https://leetcode-cn.com/problems/rotate-string/description/
 *
 * algorithms
 * Easy (51.41%)
 * Likes:    116
 * Dislikes: 0
 * Total Accepted:    16.5K
 * Total Submissions: 32.1K
 * Testcase Example:  '"abcde"\n"cdeab"'
 *
 * 给定两个字符串, A 和 B。
 * 
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea'
 * 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 * 
 * 
 * 示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 * 
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 * 
 * 注意：
 * 
 * 
 * A 和 B 长度不超过 100。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean rotateString(String A, String B) {

        return (A.length() == B.length()) && (A + A).contains(B);
    }

    // public  int KMP(String A, String B) {
    //     if (A.length() != 0 && B.length() != 0) {
    //         int[] next = getNext(B);

    //         char[] aArray = A.toCharArray();
    //         char[] bArray = B.toCharArray();
    //         int i = 0;
    //         int j = 0;

    //         while (i < aArray.length && j < bArray.length) {
    //             if (j <= 0 || aArray[i] == bArray[j]) {
    //                 i++;
    //                 j++;
    //             } else {
    //                 j = next[j - 1];
    //                 i++;
    //             }
    //         }

    //         if (j == bArray.length) {
    //             return i - j + 1;
    //         }
    //     }
    //     return -1;
    // }
    
    // public  int[] getNext(String B) {
    //     char [] charArray = B.toCharArray();
    //     int[] next = new int[charArray.length];
    //     next[0] = -1;
    //     int i = 0;
    //     int j = -1;
    //     while (i < charArray.length) {
    //         if (j <= 0 || charArray[i] == charArray[j]) {
    //             next[i++] = ++j;
    //         } else {
    //             j = next[j];
    //             i++;
    //         }
    //     }
    //     return next;
    // }
}
// @lc code=end

