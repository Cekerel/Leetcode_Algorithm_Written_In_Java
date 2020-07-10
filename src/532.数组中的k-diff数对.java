import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=532 lang=java
 *
 * [532] 数组中的K-diff数对
 *
 * https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/description/
 *
 * algorithms
 * Easy (34.44%)
 * Likes:    86
 * Dislikes: 0
 * Total Accepted:    16.8K
 * Total Submissions: 48.7K
 * Testcase Example:  '[3,1,4,1,5]\n2'
 *
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和
 * j 都是数组中的数字，且两数之差的绝对值是 k.
 *
 * 示例 1:
 *
 *
 * 输入: [3, 1, 4, 1, 5], k = 2
 * 输出: 2
 * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 *
 *
 * 示例 2:
 *
 *
 * 输入:[1, 2, 3, 4, 5], k = 1
 * 输出: 4
 * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 *
 *
 * 示例 3:
 *
 *
 * 输入: [1, 3, 1, 5, 4], k = 0
 * 输出: 1
 * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 *
 *
 * 注意:
 *
 *
 * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
 * 数组的长度不超过10,000。
 * 所有输入的整数的范围在 [-1e7, 1e7]。
 *
 *
 */

// @lc code=start
class Solution {
    // public int findPairs(int[] nums, int k) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     int count = 0;
    //     if (k < 0)
    //         return count;
    //     for (int i = 0; i < nums.length; i++) {
    //         map.putIfAbsent(nums[i], 0);
    //         map.put(nums[i], map.get(nums[i]) + 1);
    //     }
    //     for (int i : map.keySet()) {
    //         if (k == 0) {
    //             if (map.get(i) > 1)
    //                 count++;
    //         } else if (map.containsKey(i + k)) {
    //             count++;
    //         }
    //     }
    //     return count;
    // }
    public int findPairs(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        int count = 0;
        while (right < len) {
            int t = nums[right] - nums[left];
            if (t < k) {
                right++;
            } else if (t > k) {
                left++;
            } else {
                count++;
                right++;
                left++;
            }
            while (right < len && nums[right] == nums[right - 1]) {
                right++;
            }
            while (left > 0 && left < len && nums[left] == nums[left - 1]) {
                left++;
            }
            if (right <= left) {
                right = left + 1;
            }
        }
        return count;
    }
}
// @lc code=end
