//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2299 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        } else if (nums.length <= 1) {
            return true;
        }

        int farthestPos = 0; // 当前能到达的最远位置

        for (int i = 0; i < nums.length; i++) {
            if (i > farthestPos) { // 当前位置超过了前面能到达的最远位置
                return false;
            } else {
                farthestPos = Math.max(farthestPos, i + nums[i]); // 当前能到达的最远位置
            }
        }
        return true;
    }

//    public boolean canJump(int[] nums) {
//        if (nums == null) {
//            return false;
//        } else if (nums.length <= 1) {
//            return true;
//        }
//
//        int [] dp = new int[nums.length]; // 到达i位置需要的最小跳跃次数
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0; // 第0位置不需要跳
//
//        int i = 0;
//        while (i < nums.length) {
//            int maxLen = Math.min(nums[i], nums.length - 1 - i); // 当前能到达的最远位置
//            for (int j = maxLen; j >= 1; j--) {
//                dp[i + j] = Math.min(dp[i + j], dp[i] + 1); // 根据当前位置的nums[i]更新所有能到达位置的最小跳跃次数
//                if (i + j >= nums.length - 1) {
//                    return true;
//                }
//            }
//            if (maxLen == 0) { // 若当前不能往前走, 则往后判断是否有前面位置能跳过去
//                i++;
//                while (i < nums.length && dp[i] == Integer.MAX_VALUE) { // 如果前面没有能跳到当前位置的, 则继续往后找, 除非全部被找完都没找到
//                    i++;
//                }
//                if (i >= nums.length) { // 如果全部都找完都没找到, 则最后一个位置不可达
//                    return false;
//                }
//            } else { // 当前位置可达, 则计算下一个位置
//                i++;
//            }
//        }
//        return dp[nums.length - 1] != Integer.MAX_VALUE;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
