/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 求众数
 *
 * https://leetcode-cn.com/problems/majority-element/description/
 *
 * algorithms
 * Easy (58.16%)
 * Total Accepted:    27.9K
 * Total Submissions: 48K
 * Testcase Example:  '[3,2,3]'
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,3]
 * 输出: 3
 * 
 * 示例 2:
 * 
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 * 
 * 
 */
class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length, tempNum, maxValue = 0, maxTimes = 0;
        if (length == 0)
            return 0;
        else if (length == 1)
            return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                tempNum = map.get(num) + 1;
                if (maxTimes <= tempNum) {
                    maxTimes = tempNum;
                    maxValue = num;
                }
                map.put(num, tempNum);
            } else {
                map.put(num, 1);
            }
        }
        return maxValue;
    }
}
