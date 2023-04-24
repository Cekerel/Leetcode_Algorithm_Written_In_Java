import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.numSquares(12));
        // System.out.println((int)'1');


        // Scanner in = new Scanner(System.in);
        
        // String number = in.nextLine().toUpperCase().substring(2);

        // char[] chars = number.toCharArray();

        // int result = 0;

        // for (int i = 0; i < chars.length; i++) {
        //     result <<= 4;
        //     result += chars[i] > '9' ? (chars[i] - 'A' + 10) : (chars[i] - '0');
        // }
        // System.out.println(result);

        // Scanner in = new Scanner(System.in);
        
        // int number = in.nextInt();

        // int [] numbers = new int [(int)(2 * 1e9 + 15)];

        // for (int i = 2; i < numbers.length; i++) {
        //     while (numbers[i] == -1 && i < numbers.length) {
        //         i++;
        //     }
        //     for (int j = 2; j <= numbers.length / i; j++) {
        //         numbers[j * i] = -1;
        //     }
        // }

        // List<Integer> list = new ArrayList<>();
        // for (int i = 2; i < numbers.length; i++) {
        //     while (numbers[i] != -1 && number % numbers[i] == 0) {
        //         list.add(numbers[i]);
        //         number = number / numbers[i];
        //     }
        // }
        
        // for (Integer list2 : list) {
        //     System.out.print(list2 + " ");
        // }

        // System.out.println(solution.canPartition(new int[] { 1, 2, 5}));


        // System.out.println(solution.fourSum(new int[] { 1,0,-1,0,-2,2}, 0));
        // System.out.println(solution.canPartitionKSubsets(new int[] { 9,10,1,7,2,7,1,1,1,3 }, 3));

        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        
    }

    static class MinStack {

        class Node {
            int value;
    
            Node posNext;
    
            Node valueNext;
    
            Node previosValueNext;
    
            public Node(int value) {
                this.value = value;
            }
    
                            
        }
    
        private Node head, tail;
    
    
        public MinStack() {
            head = tail = new Node(0);
        }
        
        // 头插法
        public void push(int val) {
            Node node = new Node(val);
            
            node.posNext = head;
            head = node;
    
            if (tail.valueNext == null) {
                tail.valueNext = node;
                node.previosValueNext = tail;
            } else if (tail.valueNext != null && tail.valueNext.value > node.value) {
                node.valueNext = tail.valueNext;
                tail.valueNext.previosValueNext = node;
                tail.valueNext = node;
                node.previosValueNext = tail;
            } else {
                Node currentNode = tail;
                while (Objects.nonNull(currentNode.valueNext) && currentNode.valueNext.value < node.value) {
                    currentNode = currentNode.valueNext;
                }
                node.valueNext = currentNode.valueNext;
                if (currentNode.valueNext != null) {
                    currentNode.valueNext.previosValueNext = node;
                }
                currentNode.valueNext = node;
                node.previosValueNext = currentNode;
            }
        }
        
        public void pop() {
            head.previosValueNext.valueNext = head.valueNext;
            if (head.valueNext != null) {
                head.valueNext.previosValueNext = head.previosValueNext;
            }
            head = head.posNext;
        }
        
        public int top() {
            return head.value;
        }
        
        public int getMin() {
            return tail.valueNext.value;
        }
    }


    static class Solution {

        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
    
            if (nums.length >= 4) {
                Arrays.sort(nums);
                for (int i1 = 0; i1 < nums.length - 3; i1++) {
                    while (i1 > 0 && i1 < nums.length - 3 && nums[i1] == nums[i1 - 1]) {
                        i1++;
                    }
                    if (i1 < nums.length - 3) {
                        for (int i2 = i1 + 1; i2 < nums.length - 2; i2++) {
                            while (i2 > i1 + 1 && i2 < nums.length - 2 && nums[i2] == nums[i2 - 1]) {
                                i2++;
                            }
                            if (i2 < nums.length - 2) {
                                for (int i3 = i2 + 1; i3 < nums.length - 1; i3++) {
                                    while (i3 > i2 + 1 && i3 < nums.length - 1 && nums[i3] == nums[i3 - 1]) {
                                        i3++;
                                    }
                                    if (i3 < nums.length - 1) {
                                        for (int i4 = i3 + 1; i4 < nums.length; i4++) {
                                            while (i4 > i3 + 1 && i4 < nums.length && nums[i4] == nums[i4 - 1]) {
                                                i4++;
                                            }
                                            if (i4 < nums.length) {
                                                if (nums[i1] + nums[i2] + nums[i3] + nums[i4] == target) {
                                                    result.add(Arrays.asList(nums[i1], nums[i2],nums[i3], nums[i4]));
                                                }
                                            }
                                            
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } 
            return result;
        }


        public boolean canPartitionKSubsets(int[] nums, int k) {


            int length = nums.length;
    
            int sum = 0;
            int pointer = 0;
            while (pointer < length) {
                sum += nums[pointer++];
            }
    
            if (sum % k != 0) {
                return false;
            }
    
            int [] marker = new int[length];
            sum /= k;
    
            boolean result = true;
            for (int i = 0; i < k; i++) {
                result &= check(nums, 0, length, 0, sum, marker);
            }

            return result;
        }

        private boolean check (int [] nums, int depth, int maxDepth, int currentSum, int target, int [] marker) {

            if (depth == maxDepth) {
                if (currentSum == target) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (check(nums, depth + 1, maxDepth, currentSum, target, marker)) {
                    return true;
                }
                if (marker[depth] == 0  // 如果这个点没有取
                        && set(marker, depth, 1) // 先标记
                        && 
                        (
                            currentSum + nums[depth] == target // 如果当前满足, 则后续流程不需要再走了
                            || check(nums, depth + 1, maxDepth, currentSum + nums[depth], target, marker) 
                            || set(marker, depth, 0)
                        )
                ) {
                    return true;
                };
            }
            return false;

        }

        private boolean set(int [] marker, int i, int value) {
            marker[i] = value;
            return value == 1;
        }

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            
            int length = nums.length;
    
            list.addAll(dfs(new ArrayList<>(), nums, 0, length));
    
            return list;
        }
    
        private List<List<Integer>> dfs(List<Integer> subList, int[] nums, int depth, int maxDepth) {
            List<List<Integer>> list = new ArrayList<>();
            if (depth == maxDepth) {
                if (subList.size() > 0) {
                    list.add(subList);
                }
                return list;
            } else {
    
    
                List<Integer> newSubList = new ArrayList<>(subList);
                list.addAll(dfs(subList, nums, depth + 1, maxDepth));
                newSubList.add(nums[depth]);
                list.addAll(dfs(newSubList, nums, depth + 1, maxDepth));
    
                return list;
            }
        }

        public boolean canPartition(int[] nums) {
            // 元素和相等
            // 子集数为2
            // 单个子集的和要为 sum[nums[k]] / 2
            // 01背包
    
            int length = nums.length;
    
            int sum = 0;
            int pointer = 0;
            while (pointer < length) {
                sum += nums[pointer++];
            }
    
            if (sum % 2 == 0) {
                int [][] dp = new int[length + 1][sum + 1];
                sum /= 2;
                for (int i = 0; i < length; i++) {
                    for (int j = 0; j <= sum; j++) {
                        if (j < nums[i]) {
                            dp[i + 1][j] = dp[i][j];
                        } else {
                            dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - nums[i]] + nums[i]);
                        }
                    }
                }
                return dp[length][sum] == sum;
            } else {
                return false;
            }
    
        }
    
        public int numSquares(int n) {
            int MAX_N = (int) Math.sqrt(n);
    
            int [] [] dp = new int[MAX_N + 1][n + 1];
            for (int i = 0; i <= MAX_N; i++) {
                dp[i][0] = 0;
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = n + 1;
                }
            }
    
            for (int i = 0; i < MAX_N; i++) {
                for (int j = 0; j <= n; j++) {
                    if (j < (i + 1) * (i + 1)) {
                        dp[i + 1][j] = dp[i][j];
                    } else {
                        dp[i + 1][j] = Math.min(dp[i][j], dp[i + 1][j - (i + 1) * (i + 1)] + 1);
                    }
                }
            }
            return dp[MAX_N][n];
        }
    }
}
