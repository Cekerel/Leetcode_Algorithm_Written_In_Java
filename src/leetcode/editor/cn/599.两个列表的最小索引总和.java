import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=599 lang=java
 *
 * [599] 两个列表的最小索引总和
 *
 * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/description/
 *
 * algorithms
 * Easy (51.31%)
 * Likes:    82
 * Dislikes: 0
 * Total Accepted:    17.1K
 * Total Submissions: 33.4K
 * Testcase Example:  '["Shogun","Tapioca Express","Burger King","KFC"]\n["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]'
 *
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 * 
 * 示例 1:
 * 
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse",
 * "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * 
 * 
 * 提示:
 * 
 * 
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 * 
 * 
 */

// @lc code=start
class Solution {
    // 暴力解法
    // public String[] findRestaurant(String[] list1, String[] list2) {
    //     Map<Integer, List<String>> map = new HashMap<>();
    //     int lengthS1 = list1.length;
    //     int lengthS2 = list2.length;
    //     for (int i = 0; i < lengthS1; i++) {
    //         for (int j = 0; j < lengthS2; j++) {
    //             if (list1[i].equals(list2[j])) {
    //                 if (!map.containsKey(i + j)) 
    //                     map.put(i + j, new ArrayList<String>());
    //                 map.get(i + j).add(list1[i]);
                    
    //             }
    //         }
    //     }
    //     Integer key = map.keySet().stream().sorted().findFirst().orElse(0);
    //     return map.get(key).toArray(new String[map.get(key).size()]);
    // }

    // public String[] findRestaurant(String[] list1, String[] list2) {
    //     List<String> list = new ArrayList<>();
    //     for (int sum = 0; sum < list1.length + list2.length - 1; sum++) {
    //         for (int i = 0; i <= sum; i++) {
    //             if (i < list1.length && sum - i < list2.length && list1[i].equals(list2[sum - i])) {
    //                 list.add(list1[i]);
    //             }
    //         }
    //         if (list.size() > 0) {
    //             return list.toArray(new String[list.size()]);
    //         }
    //     }
    //     return new String[0];
    // }
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (minSum >= map.get(list2[i]) + i) {
                    if (minSum > map.get(list2[i]) + i) {
                        list.clear();
                        minSum = map.get(list2[i]) + i;
                    }
                    list.add(list2[i]);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
// @lc code=end
