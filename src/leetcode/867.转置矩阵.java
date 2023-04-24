/*
 * @lc app=leetcode.cn id=867 lang=java
 *
 * [867] 转置矩阵
 *
 * https://leetcode-cn.com/problems/transpose-matrix/description/
 *
 * algorithms
 * Easy (67.17%)
 * Likes:    200
 * Dislikes: 0
 * Total Accepted:    80.8K
 * Total Submissions: 120.3K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * 
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 
 * 1 
 * -10^9 
 * 
 * 
 */

// @lc code=start
class Solution {
    /**
     * 暴力解
     * @param matrix
     * @return
     */
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        int [][] newMatrix = new int[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    /**
     * 优化方案
     * @param matrix
     * @return
     */
    // public int[][] transpose(int[][] matrix) {

    // }
}
// @lc code=end

