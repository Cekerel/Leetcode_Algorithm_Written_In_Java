//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁵ 
// 
//
// Related Topics 数组 动态规划 👍 1396 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
//        if (prices == null || prices.length <= 1) {
//            return 0;
//        }
//
//        int [][] dp = new int[prices.length][2];
//        dp[0][0] = 0; // 第0天手上无股票
//        dp[0][1] = -prices[0]; // 第0天买入股票
//
//        for (int i = 1; i < prices.length; i++) {
//            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); // 第i天手上无股票, 来源: 1. 第i-1天手上无股票   2.买掉第i天手上持有的股票
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); // 第i天手上有股票, 来源: 1. 第i-1天手上有股票   2.第i天买入
//        }
//
//        return dp[prices.length - 1][0];

        int n = prices.length;
        int k = 2;
        int[][] f = new int[k + 2][2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j <= k + 1; ++j)
                Arrays.fill(f[j], Integer.MIN_VALUE / 2);
        for (int j = 1; j <= k + 1; ++j)
            f[j][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k + 1; ++j) {
                f[j][0] = Math.max(f[j][0], f[j][1] + prices[i]);
                f[j][1] = Math.max(f[j][1], f[j - 1][0] - prices[i]);
            }
        }
        return f[k + 1][0];

//
//        /**
//         * 递归超时
//         */
////        return dfs(prices, prices.length - 1, 2, 0);
    }

    /**
     * 递归超时
     */
//    private int dfs(int[] prices, int depth, int times, int behaviour) {
//
//        if (depth < 0) {
//            if (behaviour == 0) {
//                return 0;
//            } else {
//                return Integer.MIN_VALUE;
//            }
//        }
//        if (times <= 0) {
//            return 0;
//        }
//        if (behaviour == 0)
//            return Math.max(dfs(prices, depth - 1, times, 0), dfs(prices, depth - 1, times, 1) + prices[depth]);
//        else
//            return Math.max(dfs(prices, depth - 1, times, behaviour), dfs(prices, depth - 1, times - 1, 0) - prices[depth]);
//    }



}
//leetcode submit region end(Prohibit modification and deletion)
