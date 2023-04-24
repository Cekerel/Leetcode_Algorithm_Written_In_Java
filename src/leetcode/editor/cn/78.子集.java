import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        
        int length = nums.length;

        list.addAll(dfs(new ArrayList<>(), nums, 0, length));

        return list;
    }

    private List<List<Integer>> dfs(List<Integer> subList, int[] nums, int depth, int maxDepth) {
        List<List<Integer>> list = new ArrayList<>();
        if (depth == maxDepth) {
            if (subList.size() > 0) {
                list.add(subList);
            }
            return list;
        } else {


            List<Integer> newSubList = new ArrayList<>(subList);
            list.addAll(dfs(subList, nums, depth + 1, maxDepth));
            newSubList.add(nums[depth]);
            list.addAll(dfs(newSubList, nums, depth + 1, maxDepth));

            return list;
        }
    }
}
// @lc code=end

