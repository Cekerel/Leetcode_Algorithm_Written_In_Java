/**
<p>给定一个不含重复数字的数组 <code>nums</code> ，返回其 <em>所有可能的全排列</em> 。你可以 <strong>按任意顺序</strong> 返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1]
<strong>输出：</strong>[[0,1],[1,0]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>[[1]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 6</code></li> 
 <li><code>-10 &lt;= nums[i] &lt;= 10</code></li> 
 <li><code>nums</code> 中的所有整数 <strong>互不相同</strong></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><br><div><li>👍 2523</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<Integer> subResult = new ArrayList<>();

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] num) {

        if (num == null) {
            return null;
        }

        int length = num.length;

        boolean[] used = new boolean[length];

        reverse(num, 0, used);

        return result;

    }

    public void reverse(int[] num, int depth, boolean[] used) {
        if (depth == num.length) { // 终止条件, 计入结果, 返回
            result.add(new ArrayList<>(subResult));
            return;
        }

        for (int i = 0; i < num.length; i++) { // 可选范围
            if (used[i]) { // 当前已被选, 跳过
                continue;
            }

            subResult.add(num[i]); // 选择
            used[i] = true;

            reverse(num, depth + 1, used);

            subResult.remove(subResult.size() - 1); // 撤销选择
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
