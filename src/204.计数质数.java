/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 *
 * https://leetcode-cn.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (28.31%)
 * Likes:    159
 * Dislikes: 0
 * Total Accepted:    20.1K
 * Total Submissions: 70.3K
 * Testcase Example:  '10'
 *
 * 统计所有小于非负整数 n 的质数的数量。
 * 
 * 示例:
 * 
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 
 * 
 */
class Solution {
    public int countPrimes(int n) {
        if (n <= 0)
            return 0;
        boolean[] isPrime = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int j = 2; j < n; j++) {
            if (true == isPrime[j]) {
                count++;
                for (int m = 2; j * m < n; m++) {
                    isPrime[j * m] = false;
                }
            }
        }
        return count;
    }
}
