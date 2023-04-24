import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {

    // class Node {
    //     private int value;

    //     private Node previos;

    //     private Node next;

    //     public Node(int value) {
    //         this.value = value;
    //     }
    // }

    // private int capacity;

    // private int currentVolume;

    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        map = new MyMap<>(capacity);
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }

    class MyMap<K,V> extends LinkedHashMap<K,V> {
        private int capacity;

        public MyMap(int initialCapacity) {
            super(initialCapacity, 0.75f, true);
            this.capacity = initialCapacity;
        }

        @Override
        protected boolean removeEldestEntry(java.util.Map.Entry eldest) {
            return size() > capacity;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

