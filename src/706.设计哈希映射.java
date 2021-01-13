import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=706 lang=java
 *
 * [706] 设计哈希映射
 *
 * https://leetcode-cn.com/problems/design-hashmap/description/
 *
 * algorithms
 * Easy (58.30%)
 * Likes:    93
 * Dislikes: 0
 * Total Accepted:    18.4K
 * Total Submissions: 31.5K
 * Testcase Example:  '["MyHashMap","put","put","get","get","put","get", "remove", "get"]\n[[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]]'
 *
 * 不使用任何内建的哈希表库设计一个哈希映射
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 *
 * put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
 * get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
 * remove(key)：如果映射中存在这个键，删除这个数值对。
 *
 *
 *
 * 示例：
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);          
 * hashMap.put(2, 2);        
 * hashMap.get(1);            // 返回 1
 * hashMap.get(3);            // 返回 -1 (未找到)
 * hashMap.put(2, 1);         // 更新已有的值
 * hashMap.get(2);            // 返回 1
 * hashMap.remove(2);         // 删除键为2的数据
 * hashMap.get(2);            // 返回 -1 (未找到)
 *
 *
 *
 * 注意：
 *
 *
 * 所有的值都在 [0, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希库。
 *
 *
 */

// @lc code=start
class MyHashMap {

    private Bucket [] buckets;
    private final int HASH_BASE = 769;
    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new Bucket[HASH_BASE];
        for (int i = 0; i < HASH_BASE; i++) {
            buckets[i] = new Bucket();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        buckets[key % HASH_BASE].add(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return buckets[key % HASH_BASE].get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        buckets[key % HASH_BASE].delete(key);
    }


}

class Bucket {
    private LinkedList<MyEntry<Integer, Integer>> myEntryList;

    public Bucket() {
        myEntryList = new LinkedList<>();
    }

    public boolean exists(Integer key) {
        for (MyEntry<Integer,Integer> myEntry : myEntryList) {
            if (myEntry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void add(Integer key, Integer value) {
        boolean found = false;
        for (MyEntry<Integer,Integer> myEntry : myEntryList) {
            if (myEntry.getKey().equals(key)) {
                myEntry.setValue(value);
                found = true;
            }
        }
        if (!found)
            myEntryList.addFirst(new MyEntry<>(key, value));
    }

    public void delete(Integer key) {
        for (MyEntry<Integer,Integer> myEntry : myEntryList) {
            if (myEntry.getKey().equals(key)) {
                myEntryList.remove(myEntry);
                break;
            }
        }
    }

    public Integer get(Integer key) {
        for (MyEntry<Integer,Integer> myEntry : myEntryList) {
            if (myEntry.getKey().equals(key)) {
                return myEntry.getValue();
            }
        }
        return -1;
    }

}

class MyEntry<U, V> {
    private U key;
    private V value;
    public MyEntry(U key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(U key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public U getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end

