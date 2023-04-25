//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。 
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处: 
//
// 
// 0 <= j <= nums[i] 
// i + j < n 
// 
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 题目保证可以到达 nums[n-1] 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2076 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Integer min = Integer.MAX_VALUE;

    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int [] dp = new int[nums.length]; // 到达i位置需要的最小跳跃次数
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 第0位置不需要跳

        for (int i = 0; i < nums.length; i++) {
            int maxLen = Math.min(nums[i], nums.length - 1 - i); // 当前能到达的最远位置
            for (int j = maxLen - 1; j >= 0; j--) {
                dp[i + j + 1] = Math.min(dp[i + j + 1], dp[i] + 1); // 根据当前位置的nums[i]更新所有能到达位置的最小跳跃次数
            }
        }

//        backTracking(nums, 0, 0);
//        return min;

        return dp[nums.length - 1];
    }

    /**
     * 回溯法超时
     * @param nums
     * @param depth
     * @param sum
     */
    public void backTracking(int [] nums, int depth, int sum) {
        if (depth >= nums.length - 1) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < nums[depth]; i++) {
            backTracking(nums, depth + 1 + i, sum + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
