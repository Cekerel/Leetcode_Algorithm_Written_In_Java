import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 *
 * https://leetcode-cn.com/problems/binary-watch/description/
 *
 * algorithms
 * Easy (51.73%)
 * Likes:    114
 * Dislikes: 0
 * Total Accepted:    10.8K
 * Total Submissions: 20.8K
 * Testcase Example:  '0'
 *
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 *
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 *
 *
 * 例如，上面的二进制手表读取 “3:25”。
 *
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 *
 * 案例:
 *
 *
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16",
 * "0:32"]
 *
 *
 *
 * 注意事项:
 *
 *
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 *
 *
 */

// @lc code=start
class Solution {


    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (count(i) + count(j) == num) {
                    // list.add(i + ":" + String.format("%02d", j));
                    list.add(i + ":" + (j < 10 ? "0" + j : j));
                }
            }
        }
        return list;
    }
    public int count(int num) {
        int counter = 0;
        while (num != 0) {
            num = num & (num - 1);
            counter++;
        }
        return counter;
    }



    // public List<String> readBinaryWatch(int num) {
    //     List<String> list = new ArrayList<>();
    //     getList("0000000000", 0, 0, num, list);
    // }

    // public void getList(String string, int index, int times, int num, List<String> list) {
    //     if (index > 12)
    //         return;
    //     if (times == num) {
    //        // TODO
    //     }

    //     getList(string1, index + 1, times + 1, num, list);
    //     getList(string, index + 1, times, num, list);
    // }
}
// @lc code=end

