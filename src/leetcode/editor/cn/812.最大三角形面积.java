/*
 * @lc app=leetcode.cn id=812 lang=java
 *
 * [812] 最大三角形面积
 *
 * https://leetcode-cn.com/problems/largest-triangle-area/description/
 *
 * algorithms
 * Easy (62.24%)
 * Likes:    72
 * Dislikes: 0
 * Total Accepted:    8.8K
 * Total Submissions: 14.2K
 * Testcase Example:  '[[0,0],[0,1],[1,0],[0,2],[2,0]]'
 *
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 * 
 * 
 * 示例:
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出: 2
 * 解释: 
 * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
 * 
 * 
 * 
 * 
 * 注意: 
 * 
 * 
 * 3 <= points.length <= 50.
 * 不存在重复的点。
 * -50 <= points[i][j] <= 50.
 * 结果误差值在 10^-6 以内都认为是正确答案。
 * 
 * 
 */

// @lc code=start
class Solution {

    // public double largestTriangleArea(int[][] points) {
    //     double square = 0;
    //     for (int i = 0; i < points.length; i++) {
    //         for (int j = i + 1; j < points.length; j++) {
    //             for (int k = j + 1; k < points.length; k++) {
    //                 square = Math.max(square, getSquare(
    //                         Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2),
    //                         Math.pow(points[j][0] - points[k][0], 2) + Math.pow(points[j][1] - points[k][1], 2),
    //                         Math.pow(points[i][0] - points[k][0], 2) + Math.pow(points[i][1] - points[k][1], 2)));
    //             }
    //         }
    //     }
    //     return square;
    // }

    // public double getSquare(double aLineSquare, double bLineSquare, double cLineSquare) {
    //     return 0.25 * Math.sqrt(4 * aLineSquare * bLineSquare - Math.pow((aLineSquare + bLineSquare - cLineSquare), 2));
    // }
    public double largestTriangleArea(int[][] points) {
        int N = points.length;
        double ans = 0;
        for (int i = 0; i < N; ++i)
            for (int j = i+1; j < N; ++j)
                for (int k = j+1; k < N; ++k)
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
        return ans;
    }

    // 鞋带法求多边形面积
    public double area(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1]
                             -P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]);
    }

}
// @lc code=end
