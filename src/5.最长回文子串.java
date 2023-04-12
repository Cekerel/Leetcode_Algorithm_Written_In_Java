
/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        /**
         * 暴力解
         * 1. 找出所有回文字符串, 记录位置和长度
         * 2. 得出最长的Pair记录
         * 3. return s.subString(left, right);
         */

        // char[] charArray = s.toCharArray();
        // int length = 0;
        // Pair pair = null;
        
        // for (int i = 0; i < charArray.length; i++) {
        //     for (int j = 0; j < charArray.length; j++) {
        //         if (isPalidrome(charArray, i, j) && j - i + 1 > length) {
        //             length = j - i + 1;
        //             pair = new Pair(i, j, j - i + 1); 
        //         }
        //     }
        // }
        // return s.substring(pair.left, pair.left + pair.length);

        /**
         * 状态转移方程
         */
        int n = s.length();
        char[] charArray = s.toCharArray();
        int maxLen = 1;
        int begin = 0;
        boolean[] dp = new boolean[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                dp[i] = (charArray[i] == charArray[j] ? (j - i < 3 ? true : dp[i + 1]) : false);
                if (dp[i] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);

    }

    private Boolean isPalidrome(char[] charArray, int start, int end) {
        while (start < end) {
            if (charArray[start] == charArray[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    class Pair {
        /**
         * @param left
         * @param right
         * @param length
         */
        public Pair(Integer left, Integer right, Integer length) {
            this.left = left;
            this.right = right;
            this.length = length;
        }

        public Integer left;

        public Integer right;

        private Integer length;

        /**
         * @return the left
         */
        public Integer getLeft() {
            return left;
        }

        /**
         * @param left the left to set
         */
        public void setLeft(Integer left) {
            this.left = left;
        }

        /**
         * @return the right
         */
        public Integer getRight() {
            return right;
        }

        /**
         * @param right the right to set
         */
        public void setRight(Integer right) {
            this.right = right;
        }

        /**
         * @return the length
         */
        public Integer getLength() {
            return length;
        }

        /**
         * @param length the length to set
         */
        public void setLength(Integer length) {
            this.length = length;
        }

        
    }
}
// @lc code=end

