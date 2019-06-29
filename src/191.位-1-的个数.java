/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */
public class Solution {
    // you need to treat n as an unsigned value

    public int hammingWeight(int n) {
        // char[] ch = Integer.toBinaryString(n).toCharArray();
        // int length = ch.length;
        // int count = 0;
        // for (int i = 0; i < length; i++) {
        // if (ch[i] == '1') {
        // count++;
        // }
        // }
        // return count;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}
