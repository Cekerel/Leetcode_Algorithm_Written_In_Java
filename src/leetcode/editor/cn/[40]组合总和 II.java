import java.util.*;

/**
<p>给定一个候选人编号的集合&nbsp;<code>candidates</code>&nbsp;和一个目标数&nbsp;<code>target</code>&nbsp;，找出&nbsp;<code>candidates</code>&nbsp;中所有可以使数字和为&nbsp;<code>target</code>&nbsp;的组合。</p>

<p><code>candidates</code>&nbsp;中的每个数字在每个组合中只能使用&nbsp;<strong>一次</strong>&nbsp;。</p>

<p><strong>注意：</strong>解集不能包含重复的组合。&nbsp;</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入:</strong> candidates =&nbsp;<span><code>[10,1,2,7,6,1,5]</code></span>, target =&nbsp;<span><code>8</code></span>,
<strong>输出:</strong>
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> candidates =&nbsp;[2,5,2,1,2], target =&nbsp;5,
<strong>输出:</strong>
[
[1,2,2],
[5]
]</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul> 
 <li><code>1 &lt;=&nbsp;candidates.length &lt;= 100</code></li> 
 <li><code>1 &lt;=&nbsp;candidates[i] &lt;= 50</code></li> 
 <li><code>1 &lt;= target &lt;= 30</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><br><div><li>👍 1322</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length <= 0) {
            return result;
        }
        Arrays.sort(candidates);

        backTracking(candidates, target, 0, new ArrayList<>());

        return result;
    }

    private void backTracking(int [] candidates, int remaining, int depth, List<Integer> numSet) {

        if (depth == candidates.length) {
            if (remaining == 0) {
                result.add(new ArrayList<>(numSet));
            }
            return;
        }
        if (remaining == 0) {
            result.add(new ArrayList<>(numSet));
            return;
        }

        for (int i = depth; i < candidates.length; i++) { // 求子集用depth, 求排列用0

            if (remaining < candidates[i]) {
                return;
            }
            if (i > depth && candidates[i - 1] == candidates[i]) {
                continue;
            }
            numSet.add(candidates[i]);
            backTracking(candidates, remaining - candidates[i], i + 1, numSet);
            numSet.remove(numSet.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
