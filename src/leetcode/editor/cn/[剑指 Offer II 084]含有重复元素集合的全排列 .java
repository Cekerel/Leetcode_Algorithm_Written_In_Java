/**
<p>给定一个可包含重复数字的整数集合&nbsp;<code>nums</code> ，<strong>按任意顺序</strong> 返回它所有不重复的全排列。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,2]
<strong>输出：</strong>
[[1,1,2],
 [1,2,1],
 [2,1,1]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 8</code></li> 
 <li><code>-10 &lt;= nums[i] &lt;= 10</code></li> 
</ul>

<p>&nbsp;</p>

<p>
 <meta charset="UTF-8" />注意：本题与主站 47&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/permutations-ii/">https://leetcode-cn.com/problems/permutations-ii/</a></p>

<div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><br><div><li>👍 46</li><li>👎 0</li></div>
*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> subResult = new ArrayList<>();

    private void reverse (int [] num, int depth, boolean[] used) {
        if (depth == num.length) { // 终止条件
            result.add(new ArrayList<>(subResult)); // 基于原有subResult创建一个新的ArrayList存入result
            return;
        }

        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            if(used[i] || numSet.contains(num[i])) { // 当前数值被取或者这一位置之前取到过同样的数字
                continue;
            }

            subResult.add(num[i]); // 取当前值
            used[i] = true;
            numSet.add(num[i]);

            reverse(num, depth + 1, used); // 基于当前取值递归下一轮取值

            subResult.remove(subResult.size() - 1); // 撤销
            used[i] = false;
        }

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }

        int length = nums.length;

        Arrays.sort(nums);

        boolean [] used = new boolean[length];
        reverse(nums, 0, used);

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
