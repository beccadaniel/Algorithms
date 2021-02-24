package leetcode;

import java.util.Stack;

public class MyQueue {

    /**
     * https://leetcode.com/problems/implement-queue-using-stacks/
     */

    static Stack<Integer> myQueue;

    /** Initialize your data structure here. */
    public MyQueue() {
        myQueue = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        myQueue.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> keepAside = new Stack<>();
        while(myQueue.size() > 1) {
            keepAside.push(myQueue.pop());
        }
        int ans = myQueue.pop();
        while(keepAside.size() > 0) {
            myQueue.push(keepAside.pop());
        }
        return ans;
    }

    /** Get the front element. */
    public int peek() {
        Stack<Integer> keepAside = new Stack<>();
        while(myQueue.size() > 1) {
            keepAside.push(myQueue.pop());
        }
        int ans = myQueue.peek();
        while(keepAside.size() > 0) {
            myQueue.push(keepAside.pop());
        }
        return ans;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return myQueue.isEmpty();
    }
}
