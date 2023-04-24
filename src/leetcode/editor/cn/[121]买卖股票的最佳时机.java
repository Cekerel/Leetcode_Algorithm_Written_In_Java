/**
<p>给定一个数组 <code>prices</code> ，它的第&nbsp;<code>i</code> 个元素&nbsp;<code>prices[i]</code> 表示一支给定股票第 <code>i</code> 天的价格。</p>

<p>你只能选择 <strong>某一天</strong> 买入这只股票，并选择在 <strong>未来的某一个不同的日子</strong> 卖出该股票。设计一个算法来计算你所能获取的最大利润。</p>

<p>返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 <code>0</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>[7,1,5,3,6,4]
<strong>输出：</strong>5
<strong>解释：</strong>在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>prices = [7,6,4,3,1]
<strong>输出：</strong>0
<strong>解释：</strong>在这种情况下, 没有交易完成, 所以最大利润为 0。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 2934</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {

//        if (prices == null || prices.length < 2) {
//            return 0;
//        }
//        int currentMaximum = 0;
//        int currentMinimum = Integer.MAX_VALUE;
//
//        for (int i = 0; i < prices.length; i++) {
//            // 获取当前位置之前的最小值
//            currentMinimum = Math.min(currentMinimum, prices[i]);
//            // 获取当前位置与之前的最小值的差值, 并与全局最大差值相比取最大
//            currentMaximum = Math.max(currentMaximum, prices[i] - currentMinimum);
//        }
//        return currentMaximum;

        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int [] dp = new int[2];
        dp[0] = 0; // 第0天手上无股票
        dp[1] = -prices[0]; // 第0天买入股票

        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]); // 第i天手上无股票, 来源: 1. 第i-1天手上无股票   2.买掉第i天手上持有的股票
            dp[1] = Math.max(dp[1], -prices[i]); // 第i天手上有股票, 来源: 1. 第i-1天手上有股票   2.第i天买入
        }

        return dp[0];


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


        /**
         * 暴力解超时
         */
//        if (prices == null || prices.length < 2) {
//            return 0;
//        }
//        int currentMaxProfit = 0;
//        for (int i = 0; i < prices.length - 1; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                currentMaxProfit = Math.max(prices[j] - prices[i], currentMaxProfit);
//            }
//        }
//        return currentMaxProfit;


        /**
         * 回溯超时
         */
//        return getResult(prices, 0, prices.length, 0, false, false);
    }

    /**
     * 回溯超时
     */
    private int getResult (int [] prices, int depth, int maxDepth, int currentProfit, boolean saleSign, boolean purchaseSign) {
        if (depth == maxDepth) {
            return currentProfit;
        }

        int notSale = getResult(prices, depth + 1, maxDepth, currentProfit, saleSign, purchaseSign);
        int sale = 0;
        if (purchaseSign && !saleSign) {
            sale = Math.max(sale, getResult(prices, depth + 1, maxDepth, currentProfit + prices[depth], true, purchaseSign));
        }
        int purchase = 0;
        if (!purchaseSign) {
            purchase = getResult(prices, depth + 1, maxDepth, currentProfit - prices[depth], saleSign, true);
        }

        return Math.max(notSale, Math.max(sale, purchase));
    }
    
}
//leetcode submit region end(Prohibit modification and deletion)
