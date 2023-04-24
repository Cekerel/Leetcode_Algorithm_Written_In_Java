import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=703 lang=java
 *
 * [703] 数据流中的第 K 大元素
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/description/
 *
 * algorithms
 * Easy (45.53%)
 * Likes:    163
 * Dislikes: 0
 * Total Accepted:    28.9K
 * Total Submissions: 63.4K
 * Testcase Example:  '["KthLargest","add","add","add","add","add"]\n[[3,[4,5,8,2]],[3],[5],[10],[9],[4]]'
 *
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 返回当前数据流中第 k 大的元素。
 *
 *
 *
 *
 * 示例：
 *
 *
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *
 *
 *
 * 提示：
 *
 *
 * 1
 * 0
 * -10^4
 * -10^4
 * 最多调用 add 方法 10^4 次
 * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 *
 *
 */

// @lc code=start
class KthLargest {
    private Node root = new Node(0);
    private int k = 0;
    public KthLargest(int k, int[] nums) {
        for (int i : nums) {
            addElement(i);
        }
        this.k = k;
    }

    public void addElement(int val) {
        Node node = new Node(val);
        Node tempNode = root;
        while (tempNode.next != null && tempNode.next.val > val ) {
            tempNode = tempNode.next;
        }
        node.next = tempNode.next;
        tempNode.next = node;
    }

    public int returnElement() {
        int pointer = 0;
        Node result = root;
        while (pointer < k && result != null) {
            result = result.next;
            pointer++;
        }
        return java.util.Optional.ofNullable(result).orElse(new Node(0)).val;
    }

    public int add(int val) {
       addElement(val);
       return returnElement();
    }

    class Node {
        int val;
        Node prerior;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
// @lc code=end

