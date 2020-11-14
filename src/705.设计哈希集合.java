import java.util.Arrays;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=705 lang=java
 *
 * [705] 设计哈希集合
 *
 * https://leetcode-cn.com/problems/design-hashset/description/
 *
 * algorithms
 * Easy (57.73%)
 * Likes:    70
 * Dislikes: 0
 * Total Accepted:    20.3K
 * Total Submissions: 35.1K
 * Testcase Example:  '["MyHashSet","add","add","contains","contains","add","contains","remove","contains"]\n[[],[1],[2],[1],[3],[2],[2],[2],[2]]'
 *
 * 不使用任何内建的哈希表库设计一个哈希集合
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 *
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 *
 *
 * 示例:
 *
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);        
 * hashSet.add(2);        
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);          
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);          
 * hashSet.contains(2);    // 返回  false (已经被删除)
 *
 *
 *
 * 注意：
 *
 *
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 *
 *
 */

// @lc code=start
class MyHashSet {


    private Bucket [] buckets;
    private int hashBase = 769;

    public MyHashSet() {
    /** Initialize your data structure here. */
        buckets = new Bucket[hashBase];
        for (int i = 0; i < hashBase; i++) {
            buckets[i] = new Bucket();
        }
    }

    public void add(int key) {
        buckets[key % hashBase].insert(key);;
    }

    public void remove(int key) {
        buckets[key % hashBase].delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return buckets[key % hashBase].exists(key);
    }

    class Bucket {
        private LinkedList<Integer> list;

        public Bucket() {
            list = new LinkedList<>();
        }

        public void insert(Integer val) {
            if (!exists(val)) {
                list.addFirst(val);
            }
        }
        public boolean exists(Integer val) {
            int index = list.indexOf(val);
            return index != -1;
        }

        public void delete(Integer val) {
            list.remove(val);
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end

