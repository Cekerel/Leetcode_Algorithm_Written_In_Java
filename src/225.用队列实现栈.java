import java.util.Queue;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 *
 * https://leetcode-cn.com/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (59.49%)
 * Likes:    55
 * Dislikes: 0
 * Total Accepted:    12.4K
 * Total Submissions: 20.9K
 * Testcase Example:  '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * 使用队列实现栈的下列操作：
 * 
 * 
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 
 * 
 * 注意:
 * 
 * 
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty
 * 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * 
 * 
 */
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
        
        int length = sign ? sizeOfFirstQueue - 1 : sizeOfSecondQueue - 1;
        if (sign) {
            for (int i = 0; i < length; i++) {
                secondQueue.add(firstQueue.poll());
            }
            sizeOfFirstQueue = 0;
            sizeOfSecondQueue += length;
            return firstQueue.poll();
        } else {
            for (int i = 0; i < length; i++) {
                firstQueue.add(secondQueue.poll());
            }
            sizeOfSecondQueue = 0;
            sizeOfFirstQueue += length;
            return secondQueue.poll();
        }
    }

    /** Get the top element. */
    public int top() {
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
        return peek;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return sizeOfFirstQueue == 0 && sizeOfSecondQueue == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj =
 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
