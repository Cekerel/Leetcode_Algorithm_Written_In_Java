//给你一个大小为 m x n 的二进制矩阵 grid 。 
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。 
//
// 岛屿的面积是岛上值为 1 的单元格的数目。 
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 957 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        int height = grid.length;
        int width = grid[0].length;

        int maxArea = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(dfs(grid, i, j, height, width), maxArea);
                }
            }
        }
        return maxArea;
    }

    /**
     * dfs + bfs
     */
    private int dfs (int[][] grid, int i, int j, int height, int width) {
        int num = 0;
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            num++;
        } else {
            return 0;
        }

        // 上
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            num += dfs(grid, i - 1, j, height, width);
        }

        // 下
        if (i + 1 < height && grid[i + 1][j] == 1) {
            num += dfs(grid, i + 1, j, height, width);
        }

        // 左
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            num += dfs(grid, i, j - 1, height, width);
        }

        // 右
        if (j + 1 < width && grid[i][j + 1] == 1) {
            num += dfs(grid, i, j + 1, height, width);
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
