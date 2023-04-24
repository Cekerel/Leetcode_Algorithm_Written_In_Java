import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 *
 * https://leetcode-cn.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (47.80%)
 * Total Accepted:    18.1K
 * Total Submissions: 37.9K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 
 * 
 * 示例:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 * 
 */
class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
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
}

/*
 * 链表
 */
// class MinStack {

//     class Node {
//         int value;

//         Node posNext;

//         Node valueNext;

//         Node previosValueNext;

//         public Node(int value) {
//             this.value = value;
//         }    
//     }

//     private Node head, tail;


//     public MinStack() {
//         head = tail = new Node(0);
//     }
    
//     // 头插法
//     public void push(int val) {
//         Node node = new Node(val);
        
//         node.posNext = head;
//         head = node;

//         if (tail.valueNext == null) {
//             tail.valueNext = node;
//             node.previosValueNext = tail;
//         } else if (tail.valueNext != null && tail.valueNext.value > node.value) {
//             node.valueNext = tail.valueNext;
//             tail.valueNext.previosValueNext = node;
//             tail.valueNext = node;
//             node.previosValueNext = tail;
//         } else {
//             Node currentNode = tail;
//             while (Objects.nonNull(currentNode.valueNext) && currentNode.valueNext.value < node.value) {
//                 currentNode = currentNode.valueNext;
//             }
//             node.valueNext = currentNode.valueNext;
//             if (currentNode.valueNext != null) {
//                 currentNode.valueNext.previosValueNext = node;
//             }
//             currentNode.valueNext = node;
//             node.previosValueNext = currentNode;
//         }
//     }
    
//     public void pop() {
//         head.previosValueNext.valueNext = head.valueNext;
//         if (head.valueNext != null) {
//             head.valueNext.previosValueNext = head.previosValueNext;
//         }
//         head = head.posNext;
//     }
    
//     public int top() {
//         return head.value;
//     }
    
//     public int getMin() {
//         return tail.valueNext.value;
//     }
// }

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
