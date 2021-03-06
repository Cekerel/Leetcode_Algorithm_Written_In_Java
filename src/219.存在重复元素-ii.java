
/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 *
 * https://leetcode-cn.com/problems/contains-duplicate-ii/description/
 *
 * algorithms
 * Easy (34.80%)
 * Likes:    89
 * Dislikes: 0
 * Total Accepted:    15.7K
 * Total Submissions: 45K
 * Testcase Example:  '[1,2,3,1]\n3'
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j
 * 的差的绝对值最大为 k。
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 
 * 示例 2:
 * 
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 
 * 示例 3:
 * 
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * 
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> tempSet = new HashSet<>();
        int length = nums.length;
        int size = 0;
        for (int i = 0; i < length; i++) {
            if (tempSet.contains(nums[i])) {
                return true;
            }
            tempSet.add(nums[i]);
            size++;
            if (size > k) {
                tempSet.remove(nums[i - k]);
                size--;
            }
        }
        return false;
    }
}
