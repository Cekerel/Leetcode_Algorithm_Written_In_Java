import java.math.BigInteger;
import java.util.*;

/**
<p>给你一个 <strong>无重复元素</strong> 的整数数组&nbsp;<code>candidates</code> 和一个目标整数&nbsp;<code>target</code>&nbsp;，找出&nbsp;<code>candidates</code>&nbsp;中可以使数字和为目标数&nbsp;<code>target</code> 的 所有<em>&nbsp;</em><strong>不同组合</strong> ，并以列表形式返回。你可以按 <strong>任意顺序</strong> 返回这些组合。</p>

<p><code>candidates</code> 中的 <strong>同一个</strong> 数字可以 <strong>无限制重复被选取</strong> 。如果至少一个数字的被选数量不同，则两种组合是不同的。&nbsp;</p>

<p>对于给定的输入，保证和为&nbsp;<code>target</code> 的不同组合数少于 <code>150</code> 个。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>candidates = <span><code>[2,3,6,7], </code></span>target = <span><code>7</code></span>
<strong>输出：</strong>[[2,2,3],[7]]
<strong>解释：</strong>
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入: </strong>candidates = [2,3,5]<span><code>, </code></span>target = 8
<strong>输出: </strong>[[2,2,2,2],[2,3,3],[3,5]]</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入: </strong>candidates = <span><code>[2], </code></span>target = 1
<strong>输出: </strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= candidates.length &lt;= 30</code></li> 
 <li><code>2 &lt;= candidates[i] &lt;= 40</code></li> 
 <li><code>candidates</code> 的所有元素 <strong>互不相同</strong></li> 
 <li><code>1 &lt;= target &lt;= 40</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><br><div><li>👍 2464</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    private List<List<Integer>> result = new ArrayList<>();
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        if (candidates == null || candidates.length <= 0) {
//            return result;
//        }
//
//        dfs(candidates, 0, target, new ArrayList<>());
//
//        return result;
//    }
//
//    private void dfs (int[] candidates, int depth, int remaining, List<Integer> subResult) {
//        if (depth == candidates.length) {
//            return;
//        }
//        if (remaining == 0) {
//            result.add(new ArrayList<>(subResult));
//            return;
//        }
//
//        dfs(candidates, depth + 1, remaining, subResult); // 本次不取
//
//        if (remaining >= candidates[depth]) { // 本次不能取
//            subResult.add(candidates[depth]); // 本次取
//            dfs(candidates, depth, remaining - candidates[depth], subResult);
//            subResult.remove(subResult.size() - 1); // 回溯
//        }
//
//    }


//    private List<List<Integer>> result = new ArrayList<>();
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        if (candidates == null || candidates.length <= 0) {
//            return result;
//        }
//
//        dfs(candidates, 0,  target, new ArrayList<>(), 0);
//
//        return result;
//    }
//
//    private void dfs (int[] candidates, int depth, int target, List<Integer> subResult, int sum) {
//        if (depth >= candidates.length) {
//
//            return;
//        }
//        if (target == sum) {
//            result.add(new ArrayList<>(subResult));
//            return;
//        }
//
//
//        dfs(candidates, depth + 1, target, subResult, sum); // 本次不取
//
//        if (candidates[depth] + sum > target) { // 本次不能取
//            return;
//        }
//        subResult.add(candidates[depth]); // 逮着candidates[depth]使劲薅
//        dfs(candidates, depth, target, subResult, sum + candidates[depth]);
//        subResult.remove(subResult.size() - 1); // 回溯
//    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length <= 0) {
            return result;
        }

        backTracking(candidates, 0, target, new ArrayList<>());

        return result;
    }

    private void backTracking(int [] candidates, int depth, int remaining, List<Integer> subResult) {
        if (depth == candidates.length) {
            if (remaining == 0) {
                result.add(new ArrayList<>(subResult));
            }
            return;
        }
        if (remaining == 0) {
            result.add(new ArrayList<>(subResult));
        }
        for (int i = depth; i < candidates.length; i++) { // 组合问题这里需要取depth， 排列问题才需要取0， 切记
            if (remaining < candidates[i]) { // 大剪枝
                continue;
            }

            subResult.add(candidates[i]);
            backTracking(candidates, i, remaining - candidates[i], subResult);
            subResult.remove(subResult.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
