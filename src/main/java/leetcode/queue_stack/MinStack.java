package leetcode.queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private Deque<Integer> minStack;
    private Deque<Integer> stack;

    public MinStack() {
        minStack = new ArrayDeque<>();
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);

        if (minStack.isEmpty() || minStack.peek() > x) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }

    }

    public void pop() {
        if (!minStack.isEmpty())
            minStack.pop();

        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(1);
        ms.push(2);
        System.out.println(ms.top());
        System.out.println(ms.getMin());
        System.out.println(ms.top());
        System.out.println(ms.getMin());
        System.out.println(ms.top());
    }
}
