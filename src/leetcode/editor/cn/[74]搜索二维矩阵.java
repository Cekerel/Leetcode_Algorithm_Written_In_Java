//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 791 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int height = matrix.length;
        int width = matrix[0].length;

        int i = 0;
        while (i < height && matrix[i][width - 1] < target) { // 找到右端第一个大于等于target的位置
            i++;
        }
        if (i >= height) { // 如果没有则直接返回false
            return false;
        }
        if (matrix[i][width - 1] == target) {
            return true;
        }

        int start = 0;
        int end = width - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[i][mid] == target) {
                return true;
            } else if (matrix[i][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
