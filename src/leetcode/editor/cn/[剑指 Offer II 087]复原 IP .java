/**
<p>给定一个只包含数字的字符串 <code>s</code> ，用以表示一个 IP 地址，返回所有可能从&nbsp;<code>s</code> 获得的 <strong>有效 IP 地址 </strong>。你可以按任何顺序返回答案。</p>

<p><strong>有效 IP 地址</strong> 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 <code>0</code>），整数之间用 <code>'.'</code> 分隔。</p>

<p>例如："0.1.2.201" 和 "192.168.1.1" 是 <strong>有效</strong> IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 <strong>无效</strong> IP 地址。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "25525511135"
<strong>输出：</strong>["255.255.11.135","255.255.111.35"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "0000"
<strong>输出：</strong>["0.0.0.0"]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "1111"
<strong>输出：</strong>["1.1.1.1"]
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>s = "010010"
<strong>输出：</strong>["0.10.0.10","0.100.1.0"]
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>s = "10203040"
<strong>输出：</strong>["10.20.30.40","102.0.30.40","10.203.0.40"]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= s.length &lt;= 3000</code></li> 
 <li><code>s</code> 仅由数字组成</li> 
</ul>

<p>&nbsp;</p>

<p>
 <meta charset="UTF-8" />注意：本题与主站 93&nbsp;题相同：<a href="https://leetcode-cn.com/problems/restore-ip-addresses/">https://leetcode-cn.com/problems/restore-ip-addresses/</a>&nbsp;</p>

<div><div>Related Topics</div><div><li>字符串</li><li>回溯</li></div></div><br><div><li>👍 52</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //记录分段IP数字字符串
    private String nums = "";

    //step表示第几个数字，index表示字符串下标
    public void dfs(String s, ArrayList<String> res, int step, int index) {
        //当前分割出的字符串
        String cur = "";
        //分割出了四个数字
        if (step == 4) {
            //下标必须走到末尾
            if (index != s.length())
                return;
            res.add(nums);
        } else {
            //最长遍历3位
            for (int i = index; i < index + 3 && i < s.length(); i++) {
                cur += s.charAt(i);
                //转数字比较
                int num = Integer.parseInt(cur);
                String temp = nums;
                //不能超过255且不能有前导0
                if (num <= 255 && (cur.length() == 1 || cur.charAt(0) != '0')) {
                    //添加点
                    if (step - 3 != 0)
                        nums += cur + ".";
                    else
                        nums += cur;
                    //递归查找下一个数字
                    dfs(s, res, step + 1, i + 1);
                    //回溯
                    nums = temp;
                }
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        dfs(s, res, 0, 0);
        return res;
    }



//    private Set<String> result = new HashSet<>();
//    public List<String> restoreIpAddresses(String s) {
//        // write code here
//
//        if (s == null || s.length() < 3) {
//            return new ArrayList<>();
//        }
//
//        char[] chars = s.toCharArray();
//
//        getResult(chars, 0, 0, "");
//
//        return new ArrayList<>(result);
//    }
//
//    private void getResult (char[] chars, int depth, int currentIndex, String subString) {
//
//        if (depth == 4) {
//            if (currentIndex != chars.length) {
//                return;
//            } else {
//                result.add(subString);
//            }
//        }
//
//        String tmp = "";
//        for (int i = 0; i < Math.min(3, chars.length - currentIndex); i++) {
//            tmp += chars[currentIndex + i];
//
//            if ("0".equals(tmp)) { // 如果前导数据为0, 则当前位置仅取这一位
//                getResult(chars, depth + 1, currentIndex + i + 1, subString + tmp + (depth == 3 ? "" : "."));
//                return;
//            } else if ("00".equals(tmp) || (i == 2 && Integer.valueOf(tmp) >= 256)) { // 当前导数据为00或者数字大于256, 则直接返回
//                return;
//            }
//
//            getResult(chars, depth + 1, currentIndex + i + 1, subString + tmp + (depth == 3 ? "" : "."));
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
