package com.luo.leetcode.stack;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author luoxiangnan
 * @date 2021-04-18
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(1);
        minStack.push(3);

        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
    }

    private Stack<Integer> stack = new Stack<>();
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int val) {
        stack.add(val);
        priorityQueue.add(val);
    }

    public void pop() {
        priorityQueue.remove(stack.pop());
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return priorityQueue.peek();
    }
}
