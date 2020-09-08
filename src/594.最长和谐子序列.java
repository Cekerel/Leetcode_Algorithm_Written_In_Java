import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=594 lang=java
 *
 * [594] 最长和谐子序列
 *
 * https://leetcode-cn.com/problems/longest-harmonious-subsequence/description/
 *
 * algorithms
 * Easy (48.43%)
 * Likes:    120
 * Dislikes: 0
 * Total Accepted:    15.3K
 * Total Submissions: 31.6K
 * Testcase Example:  '[1,3,2,2,5,2,3,7]'
 *
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * 
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 
 * 
 * 说明: 输入的数组长度最大不超过20,000.
 * 
 */

// @lc code=start
class Solution {
    int maxLength = 0;
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums){
            map.merge(i, 1, Integer::sum);
        }
        map.keySet().forEach(i -> {
           if (map.containsKey(i + 1)) {
               maxLength = Math.max(maxLength, map.get(i + 1) + map.get(i));
           }
        });
        return maxLength;
    }
}
// @lc code=end

