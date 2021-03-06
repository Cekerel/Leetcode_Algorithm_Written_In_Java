/*
 * @lc app=leetcode.cn id=475 lang=java
 *
 * [475] 供暖器
 *
 * https://leetcode-cn.com/problems/heaters/description/
 *
 * algorithms
 * Easy (30.00%)
 * Likes:    119
 * Dislikes: 0
 * Total Accepted:    10.3K
 * Total Submissions: 34.2K
 * Testcase Example:  '[1,2,3]\n[2]'
 *
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 *
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 *
 * 说明:
 *
 *
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 *
 *
 * 示例 1:
 *
 *
 * 输入: [1,2,3],[2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 *
 *
 * 示例 2:
 *
 *
 * 输入: [1,2,3,4],[1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 *
 *
 */

// @lc code=start
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int pointer = 0;
        int maximumRadis = 0;
        for (int i = 0; i < houses.length; i++) {
            pointer = 0;
            while (pointer < heaters.length && heaters[pointer] < houses[i]) {
                pointer++;
            }
            if (pointer < heaters.length) {
                if (pointer == 0) {
                    maximumRadis = Math.max(maximumRadis, Math.abs(houses[i] - heaters[pointer]));
                } else
                    maximumRadis = Math.max(maximumRadis, Math.min(Math.abs(houses[i] - heaters[pointer - 1]),
                            Math.abs(houses[i] - heaters[pointer])));
            } else {
                maximumRadis = Math.max(maximumRadis, Math.abs(houses[i] - heaters[pointer - 1]));
            }
        }
        return maximumRadis;
    }

    // public int findRadius(int[] houses, int[] heaters) {
    //     // 先排序，踩坑了，以为是顺序的。
    //     Arrays.sort(houses);
    //     Arrays.sort(heaters);
    //     int radis = 0;
    //     int right = 0;
    //     for (int i = 0; i < houses.length; i++) {
    //         // 找到恰好比当前房屋大的加热器
    //         while (right + 1 < heaters.length && heaters[right] < houses[i]) {
    //             right++;
    //         }
    //         // 特判， 否则会出现越界
    //         if (right == 0) {
    //             radis = Math.max(radis, Math.abs(heaters[right] - houses[i]));
    //         } else {
    //             radis = Math.max(radis,
    //                     Math.min(Math.abs(heaters[right] - houses[i]), Math.abs(houses[i] - heaters[right - 1])));
    //         }
    //     }
    //     return radis;
    // }
}
// @lc code=end
