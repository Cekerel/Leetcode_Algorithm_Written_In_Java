//对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k 。 
//
// 给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab", s2 = "ba"
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：s1 = "abc", s2 = "bca"
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length <= 20 
// s2.length == s1.length 
// s1 和 s2 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母 
// s2 是 s1 的一个字母异位词 
// 
//
// Related Topics 广度优先搜索 字符串 👍 280 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    public int kSimilarity(String s1, String s2) {
//        int n = s1.length();
//        Queue<Pair<String, Integer>> queue = new ArrayDeque<Pair<String, Integer>>();
//        Set<String> visit = new HashSet<String>();
//        queue.offer(new Pair<String, Integer>(s1, 0));
//        visit.add(s1);
//        int step = 0;
//        while (!queue.isEmpty()) {
//            int sz = queue.size();
//            for (int i = 0; i < sz; i++) {
//                Pair<String, Integer> pair = queue.poll();
//                String cur = pair.getKey();
//                int pos = pair.getValue();
//                if (cur.equals(s2)) {
//                    return step;
//                }
//                while (pos < n && cur.charAt(pos) == s2.charAt(pos)) {
//                    pos++;
//                }
//                for (int j = pos + 1; j < n; j++) {
//                    if (s2.charAt(j) == cur.charAt(j)) {
//                        continue;
//                    }
//                    if (s2.charAt(pos) == cur.charAt(j)) {
//                        String next = swap(cur, pos, j);
//                        if (!visit.contains(next)) {
//                            visit.add(next);
//                            queue.offer(new Pair<String, Integer>(next, pos + 1));
//                        }
//                    }
//                }
//            }
//            step++;
//        }
//        return step;
//    }
//
//    public String swap(String cur, int i, int j) {
//        char[] arr = cur.toCharArray();
//        char c = arr[i];
//        arr[i] = arr[j];
//        arr[j] = c;
//        return new String(arr);
//    }

    public int kSimilarity(String s1, String s2) {
        int n = s1.length();
        char s2CharArray[] = s2.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        List<String> stringList = new ArrayList<>();
        stringList.add(s1);
        map.put(s1, 0);
        for (int i = 0; i < stringList.size(); i++) {
            String s = stringList.get(i);
            char charArray[] = s.toCharArray();
            int a = map.get(s);
            for (int j = 0; j < n; j++) {
                if (charArray[j] != s2CharArray[j]) {
                    for (int k = j + 1; k < n; k++) {
                        if (charArray[k] == s2CharArray[j] && charArray[k] != s2CharArray[k]) {
                            exchange(charArray, j, k);
                            String t = new String(charArray);
                            if (t.equals(s2)) {
                                return 1 + a;
                            }
                            if (!map.containsKey(t)) {
                                stringList.add(t);
                                map.put(t, a + 1);
                            }
                            exchange(charArray, j, k);
                        }
                    }
                    break;
                }
            }
        }
        return 0;
    }

    void exchange(char c[], int x, int y) {
        char ch = c[x];
        c[x] = c[y];
        c[y] = ch;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
