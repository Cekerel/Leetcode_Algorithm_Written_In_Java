//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 2152 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int numIslands(char[][] grid) {

        if (grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        int height = grid.length;
        int width = grid[0].length;

        int num = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, height, width);
                    num++;
                }
            }
        }
        return num;
    }

    /**
     * dfs + bfs
     */
    private void dfs (char[][] grid, int i, int j, int height, int width) {
        int num = 0;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        } else {
            return;
        }

        // 上
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j, height, width);
        }

        // 下
        if (i + 1 < height && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j, height, width);
        }

        // 左
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1, height, width);
        }

        // 右
        if (j + 1 < width && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1, height, width);
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
