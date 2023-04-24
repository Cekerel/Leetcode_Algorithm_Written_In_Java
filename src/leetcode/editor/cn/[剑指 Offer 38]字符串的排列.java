import java.util.List;

/**
<p>输入一个字符串，打印出该字符串中字符的所有排列。</p>

<p>&nbsp;</p>

<p>你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。</p>

<p>&nbsp;</p>

<p><strong>示例:</strong></p>

<pre><strong>输入：</strong>s = "abc"
<strong>输出：[</strong>"abc","acb","bac","bca","cab","cba"<strong>]</strong>
</pre>

<p>&nbsp;</p>

<p><strong>限制：</strong></p>

<p><code>1 &lt;= s 的长度 &lt;= 8</code></p>

<div><div>Related Topics</div><div><li>字符串</li><li>回溯</li></div></div><br><div><li>👍 677</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private char[] subResultArray;

    private List<String> result = new ArrayList<>();

    public String[] permutation(String s) {
        if (s == null || s.length() <= 0) {
            return null;
        }

        char [] charArray = s.toCharArray();

        int length = charArray.length;
        subResultArray = new char[length];

        boolean[] used = new boolean[length];

        reverse(charArray, 0, used);

        return result.toArray(new String[]{});
    }

    public void reverse(char[] charArray, int depth, boolean[] used) {
        if (depth == charArray.length) { // 终止条件, 计入结果, 返回
            result.add(new String(subResultArray));
            return;
        }
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < charArray.length; i++) { // 可选范围
            if (used[i] || charSet.contains(charArray[i])) { // 当前已被选, 跳过
                continue;
            }

            subResultArray[depth] = charArray[i]; // 选择
            used[i] = true;
            charSet.add(charArray[i]);

            reverse(charArray, depth + 1, used);

            subResultArray[depth] = ' '; // 撤销选择
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
