import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=506 lang=java
 *
 * [506] 相对名次
 *
 * https://leetcode-cn.com/problems/relative-ranks/description/
 *
 * algorithms
 * Easy (54.21%)
 * Likes:    47
 * Dislikes: 0
 * Total Accepted:    9.4K
 * Total Submissions: 17.4K
 * Testcase Example:  '[5,4,3,2,1]'
 *
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold
 * Medal", "Silver Medal", "Bronze Medal"）。
 * 
 * (注：分数越高的选手，排名越靠前。)
 * 
 * 示例 1:
 * 
 * 
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal"
 * and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 
 * 提示:
 * 
 * 
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, String> medals = new HashMap<>();
        for (int num : nums) {
            queue.offer(num);
        }
        System.out.println(queue);
        String[] strings = new String[nums.length];
        int pointer = 0;
        while (pointer != nums.length) {
            if (pointer <= 2) {
                if (pointer == 0) {
                    medals.put(queue.poll(), "Gold Medal");
                } else if (pointer == 1) {
                    medals.put(queue.poll(), "Silver Medal");
                } else if (pointer == 2) {
                    medals.put(queue.poll(), "Bronze Medal");
                }
            } else {
                medals.put(queue.poll(), pointer + 1 + "");
            }
            pointer++;
        }
        for (int i = 0; i < strings.length; i++) {
            strings[i] = medals.get(nums[i]);
        }
        return strings;
    }
}
// @lc code=end
