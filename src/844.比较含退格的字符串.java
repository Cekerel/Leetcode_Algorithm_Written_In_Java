import java.util.Deque;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=844 lang=java
 *
 * [844] 比较含退格的字符串
 *
 * https://leetcode-cn.com/problems/backspace-string-compare/description/
 *
 * algorithms
 * Easy (51.95%)
 * Likes:    286
 * Dislikes: 0
 * Total Accepted:    73.3K
 * Total Submissions: 141K
 * Testcase Example:  '"ab#c"\n"ad#c"'
 *
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * S 和 T 只含有小写字母以及字符 '#'。
 * 
 * 
 * 
 * 
 * 进阶：
 * 
 * 
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * 
 * 
 * 
 * 
 */

// @lc code=start


class Solution {
    /**
     * 暴力解: 利用双向链表
     */
    // private Deque<Character> queue = new LinkedBlockingDeque<>();

    // public boolean backspaceCompare(String s, String t) {
    //     return handleString(queue, s).equals(handleString(queue, t));
    // }
    // public String handleString(Deque<Character> queue, String string) {
    //     char[] charArray = string.toCharArray();
    //     for (int i = 0; i < charArray.length; i++) {
    //         if (charArray[i] == '#') {
    //             if(queue.isEmpty())
    //                 continue;
    //             else
    //                 queue.pollLast();

    //         } else {
    //             queue.add(charArray[i]);
    //         }
    //     }
    //     String result = new String();
    //     while(!queue.isEmpty()) {
    //         result = result + queue.pollFirst();
    //     }
    //     return result;
    // }

    /**
     * 其它想法: 双指针
     */
    // public boolean backspaceCompare(String s, String t) {
    //     // System.out.println(getSimplifiedString(t));
    //     return getSimplifiedString(s).equals(getSimplifiedString(t));
    //     // return false;
    // }

    // public String getSimplifiedString(String string) {
    //     char[] charArray = string.toCharArray();
    //     int pointerSharpSign = charArray.length - 1;
    //     int pointerCharacter = charArray.length - 1;

    //     // 获取到右边第一个#的位置, 先从这个位置向左找出第一个字母将其置为空字符, 同时将该#置为空字符
    //     while(pointerSharpSign >= 0) {
    //         if (charArray[pointerSharpSign] != '#') {
    //             pointerSharpSign--;
    //         } else {
    //             charArray[pointerSharpSign] = ' ';
    //             pointerCharacter = --pointerSharpSign;
    //             while(pointerCharacter >= 0 && (charArray[pointerCharacter] == '#' || charArray[pointerCharacter] == ' ')) {
    //                 pointerCharacter--;
    //             }
    //             if (pointerCharacter >= 0) {
    //                 charArray[pointerCharacter] = ' ';
    //             }
    //         }            
    //     }
    //     String result = new String();
    //     int length = charArray.length;
    //     for(int i = 0; i < length; i++) {
    //         if(charArray[i] != ' ')
    //             result = result + charArray[i];
    //     }
    //     return result;
    // }

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
// @lc code=end

