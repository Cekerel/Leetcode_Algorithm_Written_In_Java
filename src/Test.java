import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Test {

    public static boolean Find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0 || array == null)
            return false;
        int arrayLine = array.length;
        int lineCount = array[0].length;
        int lastCount = lineCount - 1;
        int index = 0;
        if (target < array[0][0] || target > array[arrayLine - 1][lastCount])
            return false;
        while (index <= arrayLine) {
            if (target < array[index][lastCount]) {
                break;
            } else if (target == array[index][lastCount]) {
                return true;
            }
            index++; // shit
        }
        for (int i = index; i < lineCount; i++) {
            if (BinarySearch(array[i], target) != -1)
                return true;
        }
        return false;
    }

    private static int BinarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int mid = (high + low) / 2;
        if (target < array[low] || target > array[high])
            return -1;
        if (target == array[low])
            return low;
        if (target == array[high])
            return high;
        while (high - low > 1) {
            if (target < array[mid]) {
                high = mid;
            } else if (target > array[mid]) {
                low = mid;
            }
            if (target == array[mid])
                return mid;
            mid = (high + low) / 2;
        }
        return -1;
    }

    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return new StringBuffer("%20").toString();
        }
        return str.toString().replaceAll(" ", "%20");
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null)
            return list;
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        int index = -1, inLength = in.length, preLength = pre.length;
        if (pre.length == 0 || in.length == 0 || preLength != inLength) {
            return null;
        }
        TreeNode tree = new TreeNode(pre[0]);
        while (pre[0] != in[++index])
            ;
        int[] preLeft = new int[index];
        int[] inLeft = new int[index];
        for (int i = 0; i < index; ++i) {
            preLeft[i] = pre[i + 1];
        }
        for (int i = 0; i < index; ++i) {
            inLeft[i] = in[i];
        }
        int[] preRight = new int[inLength - 1 - index];
        int[] inRight = new int[inLength - 1 - index];
        for (int i = 0; i < inLength - 1 - index; ++i) {
            preRight[i] = pre[index + 1 + i];
            inRight[i] = in[index + 1 + i];
        }
        tree.left = reConstructBinaryTree(preLeft, inLeft);
        tree.right = reConstructBinaryTree(preRight, inRight);
        return tree;
    }

    public static int minNumberInRotateArray(int[] array) {
        int minimum = 0;
        int length = array.length;
        if (length == 0)
            return 0;
        return minimum;
    }

    // public static void lastList(TreeNode root) {
    // if (root == null) {
    // return;
    // }
    // lastList(root.left);
    // lastList(root.right);
    // System.out.print(root.val + " ");
    // }

    // public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
    // if (pre.length == 0 || in.length == 0 || pre.length != in.length) {
    // return null;
    // }

    // int i = 0;
    // while (pre[0] != in[i]) {
    // i++;
    // }

    // TreeNode root = new TreeNode(pre[0]);

    // int inLeftTree[] = new int[i];
    // for (int k = 0; k < i; k++) {
    // inLeftTree[k] = in[k];
    // }

    // int inRightTree[] = new int[in.length - i - 1];
    // for (int k = i + 1; k < in.length; k++) {
    // inRightTree[k - i - 1] = in[k];
    // }

    // int preLeft[] = new int[i];
    // for (int k = 0; k < i; k++) {
    // preLeft[k] = pre[k + 1];
    // }

    // int preRight[] = new int[pre.length - i - 1];
    // for (int k = i + 1; k < pre.length; k++) {
    // preRight[k - i - 1] = pre[k];
    // }

    // root.left = reConstructBinaryTree(preLeft, inLeftTree);
    // root.right = reConstructBinaryTree(preRight, inRightTree);
    // return root;
    // }

    public static void lastList(TreeNode root) {
        if (root == null) {
            return;
        }
        lastList(root.left);
        lastList(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        // int[] array = { 1, 2, 3, 4, 5, 6, 7, 9 };
        // System.out.println(BinarySearch(array, 3));
        // StringBuffer buffer = new StringBuffer("We are family");
        // System.out.println(replaceSpace(buffer));
        // int[] a = { 1, 2, 4, 7, 3, 5, 6, 8 };
        // int[] b = { 4, 7, 2, 1, 5, 3, 8, 6 };
        // TreeNode root = reConstructBinaryTree(a, b);
        // lastList(root);
        System.out.println("微软");
    }
}