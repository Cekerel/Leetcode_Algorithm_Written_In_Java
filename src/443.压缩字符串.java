import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 *
 * https://leetcode-cn.com/problems/string-compression/description/
 *
 * algorithms
 * Easy (39.35%)
 * Likes:    103
 * Dislikes: 0
 * Total Accepted:    14K
 * Total Submissions: 35.3K
 * Testcase Example:  '["a","a","b","b","c","c","c"]'
 *
 * 给定一组字符，使用原地算法将其压缩。
 * 
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 
 * 在完成原地修改输入数组后，返回数组的新长度。
 * 
 * 
 * 
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：
 * ["a","a","b","b","c","c","c"]
 * 
 * 输出：
 * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
 * 
 * 说明：
 * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：
 * ["a"]
 * 
 * 输出：
 * 返回1，输入数组的前1个字符应该是：["a"]
 * 
 * 说明：
 * 没有任何字符串被替代。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 
 * 输出：
 * 返回4，输入数组的前4个字符应该是：["a","b","1","2"]。
 * 
 * 说明：
 * 由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
 * 注意每个数字在数组中都有它自己的位置。
 * 
 * 
 * 注意：
 * 
 * 
 * 所有字符都有一个ASCII值在[35, 126]区间内。
 * 1 <= len(chars) <= 1000。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        // if (chars.length < 2) {
        //     return chars.length;
        // }
        // Map<Character, Integer> sumMap = new HashMap<>();
        // for (char c : chars) {
        //     sumMap.merge(c, 1, Integer::sum);
        // }
        // StringBuilder builder = new StringBuilder();
        // Set<Character> keySet = sumMap.keySet();
        // for (Character character : keySet) {
        //     builder.append(character);
        //     int num = sumMap.get(character);
        //     if (num != 1) {
        //         builder.append(num + "");
        //     }
        // }
        // chars = builder.toString().toCharArray();
        // return chars.length;

        int write = 0, anchor = 0; // write为写入指针; anchor标注一段连续字符的起始位置;
        for(int read = 0; read < chars.length; read++){
            // 当达到数组最后位置或连续字符的最后位置
            if(read + 1 == chars.length || chars[read + 1] != chars[read]){
                chars[write++] = chars[anchor]; // 写入字符
                if(read > anchor){ // 写入长度
                    for(char c : ("" + (read - anchor + 1)).toCharArray())
                        chars[write++] = c;
                }
                anchor = read + 1;
            }
        } 
        return write;
    }
}
// @lc code=end

