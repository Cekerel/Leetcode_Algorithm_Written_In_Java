import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (63.73%)
 * Likes:    150
 * Dislikes: 0
 * Total Accepted:    46.2K
 * Total Submissions: 68.3K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 
 * 说明:
 * 
 * 
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * 
 * 
 */

// @lc code=start
class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();
        for (Integer integer : nums1) {
            aSet.add(integer);
        }
        for (Integer integer : nums2) {
            bSet.add(integer);
        }
        if (nums1.length > nums2.length)
            return insection(bSet, aSet, nums2.length);
        else
            return insection(aSet, bSet, nums1.length);

            
        // aSet.removeIf(a -> !bSet.contains(a));
        // Integer[] nums = aSet.toArray(new Integer[0]);
        // int [] results = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        // results[i] = nums[i].intValue();
        // }
        // return results;

    }

    public int[] insection(Set<Integer> set1, Set<Integer> set2, int length) {
        int[] results = new int[length];
        int pointer = 0;
        for (Integer i : set1) {
            if (set2.contains(i)) {
                results[pointer++] = i;
            }
        }
        return Arrays.copyOf(results, pointer);
    }

}
// @lc code=end
