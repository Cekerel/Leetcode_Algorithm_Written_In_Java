/*
 * @lc app=leetcode.cn id=374 lang=java
 *
 * [374] 猜数字大小
 *
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/description/
 *
 * algorithms
 * Easy (38.58%)
 * Likes:    48
 * Dislikes: 0
 * Total Accepted:    16.3K
 * Total Submissions: 38.1K
 * Testcase Example:  '10\n6'
 *
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *
 * -1 : 我的数字比较小
 * ⁠1 : 我的数字比较大
 * ⁠0 : 恭喜！你猜对了！
 *
 *
 * 示例 :
 *
 * 输入: n = 10, pick = 6
 * 输出: 6
 *
 */

// @lc code=start
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {

    // 二分法
    public int guessNumber(int n) {
        int lo = 0;
        int hi = n;
        int result = 0;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            result = guess(mid);
            if (result == 0) {
                return mid;
            }
            if (result == 1) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return mid;
    }
}
// @lc code=end

