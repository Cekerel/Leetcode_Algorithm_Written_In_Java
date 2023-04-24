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
    /** Initialize your data structure here. */
    public MyStack() {
        firstQueue = new LinkedList<>();
        secondQueue = new LinkedList<>();
        sizeOfFirstQueue = sizeOfSecondQueue = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (sizeOfFirstQueue != 0) {
            firstQueue.offer(x);
            sizeOfFirstQueue++;
        } else if (sizeOfSecondQueue != 0) {
            secondQueue.offer(x);
            sizeOfSecondQueue++;
        } else {
            firstQueue.offer(x);
            sizeOfFirstQueue++;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (firstQueue.size() != 0) {
            while (sizeOfFirstQueue-- != 1) {
                secondQueue.offer(firstQueue.poll());
                sizeOfSecondQueue++;
            }
            return firstQueue.poll();
        } else {
            while (sizeOfSecondQueue-- != 1) {
                firstQueue.offer(secondQueue.poll());
                sizeOfFirstQueue++;
            }
            return secondQueue.poll();
        }
    }

    /** Get the top element. */
    public int top() {
        int number = 0;
        if (sizeOfFirstQueue != 0) {
            while (sizeOfFirstQueue != 0) {
                if (sizeOfFirstQueue == 1) {
                    number = firstQueue.peek();
                }
                secondQueue.offer(firstQueue.poll());
                sizeOfSecondQueue++;
                sizeOfFirstQueue--;
            }
        } else {
            while (sizeOfSecondQueue != 0) {
                if (sizeOfSecondQueue == 1) {
                    number = secondQueue.peek();
                }
                firstQueue.offer(secondQueue.poll());
                sizeOfFirstQueue++;
                sizeOfSecondQueue--;
            }
        }
        return number;
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