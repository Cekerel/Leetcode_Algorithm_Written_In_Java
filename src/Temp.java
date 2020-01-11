import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * fdsafdsaf
 * 
 * @since
 * @author Cekerel
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Temp {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static int JumpFloorII(int target) {
        return (int) java.lang.Math.pow(2, target - 1);
    }

    public static int RectCover(int target) {
        int g = 0;
        int b = 1;
        while ((target--) + 1 > 0) {
            g += b;
            b = g - b;
        }
        return g;
    }

    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        Arrays.sort(array);
        return array[0];
    }

    public static int NumberOf1(int n) {
        char[] ch = Integer.toBinaryString(n).toCharArray();
        int length = ch.length;
        int pointer = 0;
        for (int i = 0; i < length; i++) {
            if (ch[i] == '1') {
                pointer++;
            }
        }
        return pointer;
    }

    public static double Power(double base, int exponent) {
        double number = 1;
        boolean isNegative = exponent > 0 ? false : true;
        exponent = isNegative ? 0 - exponent : exponent;
        while (exponent-- > 0) {
            number *= base;
        }
        return isNegative ? 1 / number : number;
    }

    public static void reOrderArray(int[] array) {
        int length = array.length;
        boolean isBreak = true;
        while (isBreak) {
            isBreak = false;
            for (int i = 0; i < length - 1; i++) {
                if (array[i] % 2 == 0 && array[i + 1] % 2 == 1) {
                    isBreak = true;
                    array[i] += array[i + 1];
                    array[i + 1] = array[i] - array[i + 1];
                    array[i] -= array[i + 1];
                }
            }
        }
        for (int k = 0; k < length; k++) {
            System.out.print(array[k] + " ");
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        java.util.ArrayList<ListNode> list = new java.util.ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int length = list.size();
        if (length < k || k <= 0)
            return null;
        else
            return list.get(length - k);
    }

    public static ListNode ReverseList(ListNode head) {
        ListNode node = head, nextNode = node, newNode = null;
        while (nextNode != null) {
            nextNode = nextNode.next;
            node.next = newNode;
            newNode = node;
            node = nextNode;
        }
        return newNode;
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        // if (list1 == null) {
        // return list2;
        // } else if (list2 == null)
        // return list1;
        // ListNode node = null;
        // ListNode head = null;
        // while (list1 != null && list2 != null) {
        // if (list1.val <= list2.val) {
        // if (head == null) {
        // head = node = list1;
        // } else {
        // node.next = list1;
        // node = node.next;
        // }
        // list1 = list1.next;
        // } else {
        // if (head == null) {
        // head = node = list2;
        // } else {
        // node.next = list2;
        // node = node.next;
        // }
        // list2 = list2.next;
        // }
        // }
        // if (list1 == null) {
        // node.next = list2;
        // }
        // if (list2 == null) {
        // node.next = list1;
        // }

        // while (head != null) {
        // System.out.print(head.val + " ");
        // head = head.next;
        // }

        // return head;

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode node = null;
        if (list1.val <= list2.val) {
            node = list1;
            node.next = Merge(list1.next, list2);
        } else {
            node = list2;
            node.next = Merge(list1, list2.next);
        }
        return node;

    }

    public static void stringSase() {
        String string1 = String.valueOf("Hello World!");
        String string2 = "Hello World!";
        String string3 = new String("Hello World!");
        int a = 1, b = 1;
        System.out.println(string1 == string2);
        System.out.println(string1 == string3);

        Integer num1 = Integer.valueOf(123);
        Integer num2 = Integer.valueOf(123);
        Integer num3 = new Integer(123);
        System.out.println(num1 == num2);
        System.out.println(num1 == num3);

        byte[] bytes = "中国".getBytes();
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            System.out.print(bytes[i] + " ");
        }
    }

    public static void finalCase() {
        final String string;
        Scanner input = new Scanner(System.in);
        string = input.nextLine();
        System.out.println(string);
        input.close();
    }

    public static void main(String[] args) {
        // stringSase();
        finalCase();
    }
}