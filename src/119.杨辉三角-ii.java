
/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (53.57%)
 * Total Accepted:    10.6K
 * Total Submissions: 19.6K
 * Testcase Example:  '3'
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: [1,3,3,1]
 * 
 * 
 * 进阶：
 * 
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * 
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int lengthOfFinalList = 0, lengthOfList = 0;
        for (int i = 0; i < rowIndex + 1; i++) {
            if (i == 0) {
                list.add(1);
            } else if (i == 1) {
                list = new ArrayList<>();
                list.add(1);
                list.add(1);
            } else {
                tempList = finalList.get(lengthOfFinalList - 1);
                list = new ArrayList<>();
                list.add(1);
                for (int j = 0; j < lengthOfList - 1; j++) {
                    list.add(tempList.get(j) + tempList.get(j + 1));
                }
                list.add(1);
            }
            finalList.add(list);
            lengthOfFinalList++;
            lengthOfList++;
        }
        return list;
    }
}
