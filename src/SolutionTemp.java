
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

/*******************************************************
 * 
 * 
 * Another Class is put here!
 * 
 * 
 * 
 * 
 **/

class MinStack {

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        // if (mainStack.contains(x)) {
        // int index = mainStack.indexOf(x);

        // mainStack.remove(index);
        // }
        mainStack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (mainStack.isEmpty()) {
            return;
        } else if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public void printStack() {
        System.out.println("Main Stack");
        int length = mainStack.size();
        for (int i = 0; i < length; i++) {
            System.out.print(mainStack.get(i) + " ");
        }
        System.out.println("\nMinimum Stack");
        int len = minStack.size();
        for (int i = 0; i < len; i++) {
            System.out.print(minStack.get(i) + " ");
        }
        System.out.println("\n");
    }
}

class MyStack {
    private static Queue<Integer> firstQueue;
    private static Queue<Integer> secondQueue;
    private static int sizeOfFirstQueue;
    private static int sizeOfSecondQueue;
    private static boolean sign = true;

    /** Initialize your data structure here. */
    public MyStack() {
        firstQueue = new LinkedList<>();
        secondQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        (sign ? firstQueue : secondQueue).add(x);
        if (sign) {
            sizeOfFirstQueue++;
        } else {
            sizeOfSecondQueue++;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty())
            return Integer.MIN_VALUE;
        int length = sign ? sizeOfFirstQueue - 1 : sizeOfSecondQueue - 1;
        if (sign) {
            for (int i = 0; i < length; i++) {
                secondQueue.add(firstQueue.poll());
            }
            sign = !sign;
            sizeOfFirstQueue = 0;
            sizeOfSecondQueue += length;
            return firstQueue.poll();
        } else {
            for (int i = 0; i < length; i++) {
                firstQueue.add(secondQueue.poll());
            }
            sizeOfSecondQueue = 0;
            sizeOfFirstQueue += length;
            sign = !sign;
            return secondQueue.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        if (empty())
            return Integer.MIN_VALUE;
        int peek = 0;
        int length = sign ? sizeOfFirstQueue : sizeOfSecondQueue;
        if (sign) {
            for (int i = 0; i < length - 1; i++) {
                secondQueue.add(firstQueue.poll());
            }
            peek = firstQueue.peek();
            secondQueue.add(firstQueue.poll());
            sizeOfFirstQueue = 0;
            sizeOfSecondQueue += length;
        } else {
            for (int i = 0; i < length - 1; i++) {
                firstQueue.add(secondQueue.poll());
            }
            peek = secondQueue.peek();
            firstQueue.add(secondQueue.poll());
            sizeOfSecondQueue = 0;
            sizeOfFirstQueue += length;
        }
        sign = !sign;
        return peek;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return sizeOfFirstQueue == 0 && sizeOfSecondQueue == 0;
    }
}

/*
 * SolutionTemp
 */
public class SolutionTemp {

    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return 0;
    }

    public static int climbStairs(int n) {
        int times = 2;
        int sum = 1;
        while (times-- > 0) {
            sum *= (n--);
        }
        return sum / 2;
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        int pointer = length - 1;
        digits[pointer] += 1;
        while (pointer >= 0) {
            if (digits[pointer] == 10) {
                if (pointer != 0) {
                    digits[pointer - 1] += 1;
                    digits[pointer--] = 0;
                } else {
                    int[] newDigits = new int[length + 1];
                    newDigits[0] = 1;
                    newDigits[1] = 0;
                    for (int i = 1; i < length; i++) {
                        newDigits[i + 1] = digits[i];
                    }
                    return newDigits;
                }
            } else
                break;
        }
        return digits;
    }

    public static int lengthOfLastWord(String s) {
        int length = s.length();
        boolean marker = false;
        Stack<Character> tempStack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (marker) {
                    tempStack.removeAllElements();
                    marker = false;
                }
                tempStack.push(c);
            } else {
                if (!marker) {
                    marker = true;
                }
            }
        }
        return tempStack.size();
    }

    public static int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    public static String addBinary(String a, String b) {
        java.math.BigInteger aInteger = new java.math.BigInteger(a);
        java.math.BigInteger bInteger = new java.math.BigInteger(b);
        aInteger = aInteger.add(bInteger);
        char[] chars = aInteger.toString().toCharArray();
        int length = chars.length;
        boolean carry = false;
        if (length != 0) {
            for (int i = length - 1; i >= 0; i--) {
                if (carry) {
                    if (chars[i] == '0') {
                        chars[i] = '1';
                        carry = false;
                    } else {
                        if (chars[i] == '2')
                            chars[i] = '1';
                        else if (chars[i] == '1')
                            chars[i] = '0';
                        if (i == 0) {
                            return "1" + new String(chars);
                        }
                    }
                } else {
                    if (chars[i] == '2') {
                        chars[i] = '0';
                        if (i == 0)
                            return "1" + new String(chars);
                        else
                            carry = true;
                    }
                }
            }
        }
        return new String(chars);
    }

    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (sum + nums[i] > 0) {
                sum += nums[i];
                max = max > sum ? max : sum;
            } else {
                max = max > nums[i] ? max : nums[i];
                sum = 0;
            }
        }
        return max;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[pointer] = nums1[i--];
            } else {
                nums1[pointer] = nums2[j--];
            }
            pointer--;
        }
        while (i >= 0) {
            nums1[pointer--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[pointer--] = nums2[j--];
        }

    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int lengthOfFinalList = 0, lengthOfList = 0;
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                list.add(1);
            } else if (i == 1) {
                list = new ArrayList<>();
                list.add(1);
                list.add(1);
            } else {
                tempList = finalList.get(lengthOfFinalList - 1);
                list = new ArrayList<>();
                list.add(1);
                for (int j = 0; j < lengthOfList - 1; j++) {
                    list.add(tempList.get(j) + tempList.get(j + 1));
                }
                list.add(1);
            }
            finalList.add(list);
            lengthOfFinalList++;
            lengthOfList++;
        }
        return finalList;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int lengthOfFinalList = 0, lengthOfList = 0;
        for (int i = 0; i < rowIndex; i++) {
            if (i == 0) {
                list.add(1);
            } else if (i == 1) {
                list = new ArrayList<>();
                list.add(1);
                list.add(1);
            } else {
                tempList = finalList.get(lengthOfFinalList - 1);
                list = new ArrayList<>();
                list.add(1);
                for (int j = 0; j < lengthOfList - 1; j++) {
                    list.add(tempList.get(j) + tempList.get(j + 1));
                }
                list.add(1);
            }
            finalList.add(list);
            lengthOfFinalList++;
            lengthOfList++;
        }
        return list;
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1)
            return true;
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while ((s.charAt(i) < '0' || s.charAt(i) > '9') && (s.charAt(i) < 'a' || s.charAt(i) > 'z') && i < j)
                i++;
            while ((s.charAt(j) < '0' || s.charAt(j) > '9') && (s.charAt(j) < 'a' || s.charAt(j) > 'z') && i < j)
                j--;
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static int majorityElement(int[] nums) {
        int length = nums.length, tempNum, maxValue = 0, maxTimes = 0;
        if (length == 0)
            return 0;
        else if (length == 1)
            return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                tempNum = map.get(num) + 1;
                if (maxTimes < tempNum) {
                    maxTimes = tempNum;
                    maxValue = num;
                }
                map.put(num, tempNum);
            } else {
                map.put(num, 1);
            }
        }
        return maxValue;
    }

    public static int titleToNumber(String s) {
        int length = s.length();
        int difference = 0;
        if (length == 1) {
            difference = s.charAt(0) - 'A' + 1;
        } else {
            for (int i = length - 1; i >= 0; i--) {
                if (i == length - 1) {
                    difference = s.charAt(i) - 'A' + 1;
                } else {
                    difference += (s.charAt(i) - 'A' + 1) * Math.pow(26, length - 1 - i);
                }
            }
        }
        return difference;
    }

    public static int trailingZeroes(int n) {
        int pointer = 0;
        while (n / 5 != 0) {
            pointer += (n = n / 5);
        }
        return pointer;
    }

    public static String replaceSpace(StringBuffer str) {
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");

        System.out.println(str.toString());
        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }

    public static int hammingWeight(int n) {
        // String string = Integer.toBinaryString(n);
        // String string2 = string.replaceAll("1", "");
        // return string.length() - string2.length();
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public static int countPrimes(int n) {
        if (n <= 0) {
            return 0;
        }
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int j = 2; j <= n; j++) {
            if (true == isPrime[j]) {
                for (int m = 2; j * m <= n; m++) {
                    isPrime[j * m] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (true == isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void rotate(int[] nums, int k) {
        // int size = nums.length;
        // int temp = Integer.MIN_VALUE;
        // for (int i = 0; i < k; i++) {
        // temp = nums[size - 1];
        // for (int j = size - 1; j > 0; j--) {
        // nums[j] = nums[j - 1];
        // }
        // nums[0] = temp;
        // }
        int size = nums.length;
        int[] numsTemp = new int[size];
        for (int i = 0; i < size; i++) {
            numsTemp[(i + k) % size] = nums[i];
        }
        System.arraycopy(numsTemp, 0, nums, 0, size);
    }

    public static void reverseBits(int n) {
        boolean positive = n > 0 ? true : false;
        StringBuilder builder = new StringBuilder();
        n = Math.abs(n);
        while (n != 0) {
            builder.append(n % 2);
            n /= 2;
        }
        builder = builder.reverse();
        int length = builder.length();
        while (length++ < 31) {
            builder.insert(0, 0);
        }
        // builder.append(positive ? 0 : 1);
        System.out.println(builder.reverse().toString());
    }

    public static boolean isIsomorphic(String s, String t) {
        try {
            int lengths = s.length();
            int lengtht = t.length();
            if (lengths != lengtht) {
                return false;
            }
            HashMap<Character, Character> testMap = new HashMap<>();
            char cs = '\0';
            char ct = '\0';
            for (int i = 0; i < lengths; i++) {
                cs = s.charAt(i);
                ct = t.charAt(i);
                if (testMap.containsKey(cs)) {
                    if (testMap.get(cs) != ct) {
                        return false;
                    }
                } else {
                    testMap.put(cs, ct);
                }
            }
        } catch (NullPointerException e) {
            return false;
            // TODO: handle exception
        }
        return true;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        int size = 0;
        Set<Integer> tempSet = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (tempSet.contains(nums[i]))
                return true;
            size++;
            tempSet.add(nums[i]);
            if (size > k) {
                tempSet.remove(nums[i - k]);
                size--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // int [] nums = {1,0,1,3,1,2,3,3,3,4};
        // int [] nums = {1, 1, 2};
        // int num = 3;
        // System.out.println(nums.length);
        // System.out.println(strStr("", ""));
        // int[] nums = { 1, 3, 5, 6 };
        // int target = -1;
        // System.out.println(searchInsert(nums, target));
        // int[] result = plusOne(nums);
        // for (int num : result) {
        // System.out.print(" " + num);
        // }
        // System.out.println(lengthOfLastWord("Hello World "));
        // System.out.println(mySqrt(2147395599));
        // System.out.println(addBinary("1010", "1011"));
        // int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        // System.out.println(maxSubArray(nums));

        // int[] nums1 = new int[] { 1, 2, 5, 0, 0, 0 };
        // int[] nums2 = new int[] { 4, 5, 6 };
        // merge(nums1, 3, nums2, 3);

        // List<List<Integer>> finalList = generate(7);
        // for (List list : finalList) {
        // System.out.println(list.toString());
        // }
        // List<Integer> list = getRow(4);
        // System.out.println(list.toString());

        // MinStack minStack = new MinStack();
        // minStack.push(512);
        // minStack.push(-1024);
        // minStack.push(-1024);
        // minStack.push(512);
        // minStack.printStack();
        // System.out.println("After poping");
        // minStack.pop();
        // minStack.printStack();
        // System.out.println(minStack.getMin());
        // System.out.println("After poping");
        // minStack.pop();
        // minStack.printStack();
        // System.out.println(minStack.getMin());
        // System.out.println("After poping");
        // minStack.pop();
        // minStack.printStack();
        // System.out.println(minStack.getMin());
        // System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

        // System.out.println(majorityElement(nums));
        // System.out.println("Hello");

        // System.out.println(titleToNumber("AB"));
        // System.out.println(trailingZeroes(1990));

        // System.out.println(hammingWeight(-3));
        // System.out.println(countPrimes(10));
        // System.out.println(isIsomorphic("egg", "add"));

        // int[] nums = { 1, 0, 1, 1 };
        // System.out.println(containsNearbyDuplicate(nums, 1));
        // System.out.println(replaceSpace(new StringBuffer("A B C")));
        MyStack stack = new MyStack();
        stack.push(1);
        System.out.println(stack.top());
    }
}