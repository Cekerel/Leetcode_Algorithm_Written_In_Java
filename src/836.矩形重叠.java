/*
 * @lc app=leetcode.cn id=836 lang=java
 *
 * [836] 矩形重叠
 *
 * https://leetcode-cn.com/problems/rectangle-overlap/description/
 *
 * algorithms
 * Easy (48.02%)
 * Likes:    199
 * Dislikes: 0
 * Total Accepted:    34.3K
 * Total Submissions: 71.4K
 * Testcase Example:  '[0,0,2,2]\n[1,1,3,3]'
 *
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。矩形的上下边平行于
 * x 轴，左右边平行于 y 轴。
 * 
 * 如果相交的面积为 正 ，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * 
 * 给出两个矩形 rec1 和 rec2 。如果它们重叠，返回 true；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：rec1 = [0,0,1,1], rec2 = [2,2,3,3]
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * rect1.length == 4
 * rect2.length == 4
 * -10^9 
 * rec1[0]  且 rec1[1] 
 * rec2[0]  且 rec2[1] 
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 解题思路: 
        // 将矩形分别投影到x,y轴, 若矩形有重合, 则矩形在x轴和y轴上投影而成的区间一定有重叠
        // 而判断不重叠比判断重叠更容易, 所以按照判断不重叠之后再取反就是判断重叠的结果
        // 特殊情况: 当某个矩形面积为0时一定不会重叠

        if (rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            return false;
        }

        boolean x_overlap = !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0]);
        boolean y_overlap = !(rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
        return x_overlap && y_overlap;

    }
}
// @lc code=end

