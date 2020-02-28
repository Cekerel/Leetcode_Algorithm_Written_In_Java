import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
 *
 * algorithms
 * Easy (42.45%)
 * Likes:    237
 * Dislikes: 0
 * Total Accepted:    68.1K
 * Total Submissions: 145.5K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 *
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 *
 * 说明：
 *
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 *
 * 进阶:
 *
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 *
 */

// @lc code=start
class Solution {
    // public int[] intersect(int[] nums1, int[] nums2) {
    //     Map<Integer, Integer> map1 = new HashMap<>();
    //     Map<Integer, Integer> map2 = new HashMap<>();
    //     for (int i : nums1) {
    //         map1.merge(i, 1, Integer::sum);
    //     }
    //     for (int i : nums2) {
    //         map2.merge(i, 1, Integer::sum);
    //     }
    //     int[] results = new int[nums1.length];
    //     int pointer = 0;
    //     Set<Integer> set1 = map1.keySet();
    //     for (Integer integer : set1) {
    //         if (map2.containsKey(integer)) {
    //             int num1 = map1.get(integer);
    //             int num2 = map2.get(integer);
    //             int le = num1 > num2 ? num2 : num1;
    //             for (int i = 0; i < le; i++) {
    //                 results[pointer++] = integer;
    //             }
    //         }
    //     }
    //     return Arrays.copyOf(results, pointer);
    // }

    // public int[] intersect(int[] nums1, int[] nums2) {
    //     Map<Integer, Integer> map1 = new HashMap<>();
    //     for (int i : nums1) {
    //         map1.merge(i, 1, Integer::sum);
    //     }
    //     int[] results = new int[nums1.length];
    //     int pointer = 0;
    //     for (int i : nums2) {
    //         if (map1.containsKey(i)) {
    //             results[pointer++] = i;
    //             int get = map1.get(i) - 1;
    //             if (get == 0)
    //                 map1.remove(i);
    //             else
    //                 map1.put(i, get);
    //         }
    //     }
    //     return Arrays.copyOf(results, pointer);
    // }

    public int[] intersect(int[] nums1, int[] nums2) {
        // List<Integer> list = new ArrayList<>();
        // for (int i = 0; i < nums1.length; i++) {
        //     for (int j = 0; j < nums2.length; j++) {
        //         if (nums1[i] == nums2[j]) {
        //             list.add(nums1[i]);
        //             nums2[j] = Integer.MIN_VALUE;
        //             break;
        //         }
        //     }
        // }
        // int length = list.size();
        // int [] result = new int[length];
        // int pointer = 0;
        // for (int i : list) {
        //     result[pointer++] = i;
        // }
        // return result;
            List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i : nums1) {
            numberMap.merge(i, 1, Integer::sum);
        }
        for (int i : nums2) {
            if (numberMap.containsKey(i)) {
                int value = numberMap.get(i);
                if (value != 0) {
                    list.add(i);
                    numberMap.put(i, value - 1);
                }
            }
        }
        int length = list.size();
        int [] result = new int[length];
        int pointer = 0;
        for (int i = 0; i < length; i++) {
            result[pointer++] = list.get(i);
        }
        return result;
    }
}
// @lc code=end

