import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
    
        if (nums.length >= 4) {
            Arrays.sort(nums);
            for (int i1 = 0; i1 < nums.length - 3; i1++) {
                while (i1 > 0 && i1 < nums.length - 3 && nums[i1] == nums[i1 - 1]) {
                    i1++;
                }
                if (i1 < nums.length - 3) {
                    for (int i2 = i1 + 1; i2 < nums.length - 2; i2++) {
                        while (i2 > i1 + 1 && i2 < nums.length - 2 && nums[i2] == nums[i2 - 1]) {
                            i2++;
                        }
                        if (i2 < nums.length - 2) {
                            for (int i3 = i2 + 1; i3 < nums.length - 1; i3++) {
                                while (i3 > i2 + 1 && i3 < nums.length - 1 && nums[i3] == nums[i3 - 1]) {
                                    i3++;
                                }
                                if (i3 < nums.length - 1) {
                                    for (int i4 = i3 + 1; i4 < nums.length; i4++) {
                                        while (i4 > i3 + 1 && i4 < nums.length && nums[i4] == nums[i4 - 1]) {
                                            i4++;
                                        }
                                        if (i4 < nums.length) {
                                            if ((long)nums[i1] + (long)nums[i2] + (long)nums[i3] + (long)nums[i4] == target) {
                                                result.add(Arrays.asList(nums[i1], nums[i2],nums[i3], nums[i4]));
                                            }
                                        }
                                        
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } 
        return result;
    }
}
// @lc code=end

