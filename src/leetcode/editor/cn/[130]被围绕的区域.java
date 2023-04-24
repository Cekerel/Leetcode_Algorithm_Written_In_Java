//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 954 👎 0


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void solve(char[][] board) {

        HashSet<Integer> numSet = new HashSet<>();

        if (board.length <= 2 || board[0].length <= 2) {
            return;
        }

        int height = board.length;
        int width = board[0].length;

        // 找到边界上所有的'O', 然后把对应相连的全部坐标全部记录在案, 直到所有边界上的'O'都被扫描
        // 这样不被记录的'O'就是边界不可达的'O', 将其置为'X'

        int num = 0;
        //左右边界
        for (int i = 0; i < height; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0, height, width, numSet);
            }
            if (board[i][width - 1] == 'O') {
                bfs(board, i, width - 1, height, width, numSet);
            }
        }

        // 上下边界
        for (int j = width - 1; j >= 1 ; j--) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j, height, width, numSet);
            }
            if (board[height - 1][j] == 'O') {
                bfs(board, height - 1, j, height, width, numSet);
            }
        }

        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                if (board[i][j] == 'O' && !numSet.contains(getNumber(i, j))) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * dfs + bfs
     */
    public void dfs(char[][] board, int i, int j, int height, int width, Set<Integer> numSet) {
        int num = 0;
        if (board[i][j] == 'O' && !numSet.contains((num = getNumber(i, j)))) {
            numSet.add(num);
        }  else if (board[i][j] == 'O') {
            return;
        }

        // 左
        if (j - 1 >= 0 && board[i][j - 1] == 'O' && !numSet.contains((num = getNumber(i, j - 1)))) {
            bfs(board, i, j - 1, height, width, numSet);
        }

        // 右
        if (j + 1 < width && board[i][j + 1] == 'O' && !numSet.contains((num = getNumber(i, j + 1)))) {
            bfs(board, i, j + 1, height, width, numSet);
        }

        // 上
        if (i - 1 >= 0 && board[i - 1][j] == 'O' && !numSet.contains((num = getNumber(i - 1, j)))) {
            bfs(board, i - 1, j, height, width, numSet);
        }

        // 下
        if (i + 1 < height && board[i + 1][j] == 'O' && !numSet.contains((num = getNumber(i + 1, j)))) {
            bfs(board, i + 1, j, height, width, numSet);
        }
    }

    private int getNumber (int i, int j) {
        return i * 201 + j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
