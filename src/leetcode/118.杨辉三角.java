import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 *
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (59.43%)
 * Total Accepted:    17.2K
 * Total Submissions: 28.5K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 5
 * 输出:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int lengthOfFinalList = 0, lengthOfList = 0;
        for (int i = 0; i < numRows; i++) {
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
        System.out.println(finalList.toString());
        return finalList;
    }
}
