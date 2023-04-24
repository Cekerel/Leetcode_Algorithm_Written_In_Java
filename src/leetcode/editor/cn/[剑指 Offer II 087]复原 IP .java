//给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "10203040"
//输出：["10.20.30.40","102.0.30.40","10.203.0.40"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
//
// 
//
// 
// 注意：本题与主站 93 题相同：https://leetcode-cn.com/problems/restore-ip-addresses/ 
//
// Related Topics 字符串 回溯 👍 52 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    private Set<String> result = new HashSet<>();
    public List<String> restoreIpAddresses(String s) {
        // write code here

        if (s == null || s.length() < 3) {
            return new ArrayList<>();
        }

        char[] chars = s.toCharArray();

        getResult(chars, 0, 0, "");

        return new ArrayList<>(result);
    }

    private void getResult (char[] chars, int depth, int currentIndex, String subString) {

        if (depth == 4) {
            if (currentIndex != chars.length) {
                return;
            } else {
                result.add(subString);
            }
        }

        String tmp = "";
        for (int i = 0; i < Math.min(3, chars.length - currentIndex); i++) {
            tmp += chars[currentIndex + i];

            if ("0".equals(tmp)) { // 如果前导数据为0, 则当前位置仅取这一位
                getResult(chars, depth + 1, currentIndex + i + 1, subString + tmp + (depth == 3 ? "" : "."));
                return;
            } else if ("00".equals(tmp) || (i == 2 && Integer.valueOf(tmp) >= 256)) { // 当前导数据为00或者数字大于256, 则直接返回
                return;
            }

            getResult(chars, depth + 1, currentIndex + i + 1, subString + tmp + (depth == 3 ? "" : "."));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
