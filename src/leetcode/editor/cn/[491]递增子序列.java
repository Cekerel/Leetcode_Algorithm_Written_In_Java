//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 位运算 数组 哈希表 回溯 👍 639 👎 0


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Set<Integer> numSet = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(nums, result, 0, nums.length, nums[0], new ArrayList<>());
        
        return result;
    }
    
    public void dfs(int [] nums, List<List<Integer>> result, int depth, int maxDepth, int previousValue, List<Integer> currentList) {
        if (maxDepth == depth) {
            return;
        }

        int hash = 0;
        if (nums[depth] >= previousValue) { // 当前能取
            // 能取则取
            List<Integer> list = new ArrayList<>(currentList);
            list.add(nums[depth]);
            dfs(nums, result, depth + 1, maxDepth, nums[depth], list);
            hash = getHash(263, (int) 1e9 + 7, list);
            if (list.size() > 1 && !numSet.contains(hash)) {
                result.add(list);
                numSet.add(hash);
            }

            // 能取但不取
            dfs(nums, result, depth + 1, maxDepth, previousValue, currentList);
            hash = getHash(263, (int) 1e9 + 7, currentList);
            if (currentList.size() > 1 && !numSet.contains(hash)) {
                result.add(currentList);
                numSet.add(hash);
            }
        } else {
            // 当前不取, 但是沿用上一个最大值
            dfs(nums, result, depth + 1, maxDepth, previousValue, currentList);
            hash = getHash(263, (int) 1e9 + 7, currentList);
            if (currentList.size() > 1 && !numSet.contains(hash)) {
                result.add(currentList);
                numSet.add(hash);
            }

            // 当前不沿用上一个最大值, 而是从当前值重新往后取
            currentList = new ArrayList<>();
            currentList.add(nums[depth]);
            dfs(nums, result, depth + 1, maxDepth, nums[depth], currentList);
            hash = getHash(263, (int) 1e9 + 7, currentList);
            if (currentList.size() > 1 && !numSet.contains(hash)) {
                result.add(currentList);
                numSet.add(hash);
            }
        }
    }

    public int getHash(int base, int mod, List<Integer> list) {
        int hashValue = 0;
        for (Integer num : list) {
            hashValue = hashValue * base % mod + (num + 101);
            hashValue %= mod;
        }
        return hashValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
