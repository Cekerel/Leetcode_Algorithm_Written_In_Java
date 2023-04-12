import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        return x >= 0 && check(x);
    }

    private boolean check(int x) {
        List<Integer> intList = new ArrayList<>();

        while (x != 0) {
            intList.add(x % 10);
            x /= 10;
        }

        if (intList.size() != 0) {
            int end = intList.size() - 1;
            int start = 0;
            while (start < end) {
                if (intList.get(start) != intList.get(end)) {
                    return false;
                } else {
                    start++;
                    end--;
                }
            }
        }
        return true;
        
    }
}
// @lc code=end

