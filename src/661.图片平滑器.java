/*
 * @lc app=leetcode.cn id=661 lang=java
 *
 * [661] 图片平滑器
 *
 * https://leetcode-cn.com/problems/image-smoother/description/
 *
 * algorithms
 * Easy (54.19%)
 * Likes:    64
 * Dislikes: 0
 * Total Accepted:    10.6K
 * Total Submissions: 19.4K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入)
 * ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 *
 * 示例 1:
 *
 *
 * 输入:
 * [[1,1,1],
 * ⁠[1,0,1],
 * ⁠[1,1,1]]
 * 输出:
 * [[0, 0, 0],
 * ⁠[0, 0, 0],
 * ⁠[0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 *
 *
 * 注意:
 *
 *
 * 给定矩阵中的整数范围为 [0, 255]。
 * 矩阵的长和宽的范围均为 [1, 150]。
 *
 *
 */

// @lc code=start
// class Solution {
//     public int[][] imageSmoother(int[][] M) {
//         int [][] newArray = new int[M.length][M[0].length];
//         for (int i = 0; i < newArray.length; i++) {
//             for (int j = 0; j < newArray[0].length; j++) {
//                 int count = 0;
//                 int sum = 0;
//                 for (int k = 0; k < newArray.length; k++) {
//                     for (int k2 = 0; k2 < newArray[0].length; k2++) {
//                         if (Math.abs(i - k) <= 1 && Math.abs(j - k2) <= 1) {
//                             count++;
//                             sum += M[k][k2];
//                         }
//                     }
//                 }
//                 newArray[i][j] = sum / count;
//             }
//         }
//         return newArray;
//     }
// }

class Solution {
    private int average(int[][] M, int i, int j) {
        int rows = M.length;
        int columns = M[0].length;

        int sum = M[i][j];
        int cnt = 1;
        if (i > 0) {
            sum += M[i - 1][j];
            cnt++;

            if (j > 0) {
                sum += M[i - 1][j - 1];
                cnt++;
            }

            if (j < (columns - 1)) {
                sum += M[i - 1][j + 1];
                cnt++;
            }
        }

        if (i < (rows - 1)) {
            sum += M[i + 1][j];
            cnt++;

            if (j > 0) {
                sum += M[i + 1][j - 1];
                cnt++;
            }

            if (j < (columns - 1)) {
                sum += M[i + 1][j + 1];
                cnt++;
            }
        }

        if (j > 0) {
            sum += M[i][j - 1];
            cnt++;
        }

        if (j < (columns - 1)) {
            sum += M[i][j + 1];
            cnt++;
        }

        return sum / cnt;
    }

    public int[][] imageSmoother(int[][] M) {
        int m = M.length;
        int n = M[0].length;

        int[][] output = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                output[i][j] = average(M, i, j);
            }
        }
        return output;
    }
}
// @lc code=end

