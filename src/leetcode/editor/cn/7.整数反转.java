import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        boolean positive = x >= 0;
        
        x = Math.abs(x);
        
        List<Integer> intList = new ArrayList<>();

        while (x > 0) {
            intList.add(x % 10);

            x /= 10;
        }

        int threshold = Integer.MAX_VALUE / 10;
        for (Integer integer : intList) {
            if (x <= threshold) {
                x *= 10;
                x += integer;
            } else {
                return 0;
            }
        }

        return Math.max(0, x) * (positive ? 1 : -1);
    }
}
// @lc code=end

