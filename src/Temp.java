import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

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

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> ansMap = new HashMap<>();
        Map<String, Integer> tempMap = new HashMap<>();
        Set<String> keys = new HashSet<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            ansMap.merge(split[1], Integer.parseInt(split[0]), Integer::sum);
            tempMap.merge(split[1], Integer.parseInt(split[0]), Integer::sum);
            keys.add(split[1]);
        }
        keys.forEach(key -> {
            int index = -1;
            String tempString = new String(key);
            while ((index = tempString.indexOf(".")) > 0) {
                ansMap.merge((tempString = tempString.substring(index + 1)), tempMap.get(key), Integer::sum);
            }
        });

        return ansMap.keySet().stream().map(key -> ansMap.get(key) + " " + key).collect(Collectors.toList());
    }

    public static double largestTriangleArea(int[][] points) {
        double square = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    System.out.println(points[i][0] + " " + points[i][1]);
                    System.out.println(points[j][0] + " " + points[j][1]);
                    System.out.println(points[k][0] + " " + points[k][1]);

                    System.out.println(
                            Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                    System.out.println(
                            Math.pow(points[j][0] - points[k][0], 2) + Math.pow(points[j][1] - points[k][1], 2));
                    System.out.println(
                            Math.pow(points[i][0] - points[k][0], 2) + Math.pow(points[i][1] - points[k][1], 2));

                    System.out.println(getSquare(
                            Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2),
                            Math.pow(points[j][0] - points[k][0], 2) + Math.pow(points[j][1] - points[k][1], 2),
                            Math.pow(points[i][0] - points[k][0], 2) + Math.pow(points[i][1] - points[k][1], 2)));
                    System.out.println();
                    square = Math.max(square, getSquare(
                            Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2),
                            Math.pow(points[j][0] - points[k][0], 2) + Math.pow(points[j][1] - points[k][1], 2),
                            Math.pow(points[i][0] - points[k][0], 2) + Math.pow(points[i][1] - points[k][1], 2)));
                }
            }
        }
        return square;
    }

    public static double getSquare(double aLineSquare, double bLineSquare, double cLineSquare) {
        return 0.25 * Math.sqrt(4 * aLineSquare * bLineSquare - Math.pow((aLineSquare + bLineSquare - cLineSquare), 2));
    }

    public static void main(String[] args) {
        // stringSase();
        // finalCase();
        // String[] cpdomains = new String[] { "3953 jfz.team",
        // "9251 miu.kmz.team",
        // "9761 fsw.team",
        // "8650 azh.jre.team",
        // "9906 xpn.ajl.team",
        // "9171 hal.team",
        // "8918 kmx.team",
        // "9019 hal.team",
        // "4544 vec.amr.team",
        // "2223 lux.zqk.team" };

        // String[] expectedAns = new String[] { "9251 miu.kmz.team","8918
        // kmx.team","9251 kmz.team","9906 xpn.ajl.team","4544 amr.team","2223
        // lux.zqk.team","8650 azh.jre.team","9906 ajl.team","3953 jfz.team","75396
        // team","18190 hal.team","4544 vec.amr.team","8650 jre.team","9761
        // fsw.team","2223 zqk.team" };

        // List<String> subdomainVisits = subdomainVisits(cpdomains);
        // Set<String> set = new HashSet<>();
        // for (String string : subdomainVisits) {
        // set.add(string);
        // }
        // for (String string : expectedAns) {
        // if (set.contains(string)) {
        // set.remove(string);
        // } else {
        // set.add(string);
        // }
        // }
        // System.out.println(set.toString());

        int[][] points = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 0, 2 }, { 2, 0 } };
        System.out.println(largestTriangleArea(points));
    }
}