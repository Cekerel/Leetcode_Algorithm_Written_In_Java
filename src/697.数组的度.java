import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 *
 * https://leetcode-cn.com/problems/degree-of-an-array/description/
 *
 * algorithms
 * Easy (54.80%)
 * Likes:    186
 * Dislikes: 0
 * Total Accepted:    26.2K
 * Total Submissions: 47.9K
 * Testcase Example:  '[1,2,2,3,1]'
 *
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1:
 *
 *
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 *
 * 示例 2:
 *
 *
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 *
 *
 * 注意:
 *
 *
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 *
 *
 */

// @lc code=start
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> longestList = new ArrayList<>();
        List<List<Integer>> longestLists = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            if (longestList.size() <= map.get(nums[i]).size()) {
                if (longestList.size() < map.get(nums[i]).size()) {
                    longestLists.clear();
                }
                longestList = new ArrayList<Integer>(map.get(nums[i]));
                longestLists.add(longestList);
            }
        }
        int longLength = Integer.MAX_VALUE;
        for (List<Integer> list : longestLists) {
            longLength = Math.min(list.get(list.size() - 1) - list.get(0) + 1, longLength);
        }
        return longLength;
    }
    // public int findShortestSubArray(int[] nums) {
    //     Map<Integer, Integer> left = new HashMap(),
    //         right = new HashMap(), count = new HashMap();

    //     for (int i = 0; i < nums.length; i++) {
    //         int x = nums[i];
    //         if (left.get(x) == null) left.put(x, i);
    //         right.put(x, i);
    //         count.put(x, count.getOrDefault(x, 0) + 1);
    //     }

    //     int ans = nums.length;
    //     int degree = Collections.max(count.values());
    //     for (int x: count.keySet()) {
    //         if (count.get(x) == degree) {
    //             ans = Math.min(ans, right.get(x) - left.get(x) + 1);
    //         }
    //     }
    //     return ans;
    // }
}
// @lc code=end

