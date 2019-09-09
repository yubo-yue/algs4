package leetcode.queue_stack;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    private List<Integer> data;
    private int start;

    public MyQueue() {
        data = new ArrayList<>();
        start = 0;
    }

    public boolean enqueue(int element) {
        data.add(element);
        return true;
    }

    public boolean dequeue() {
        if (isEmpty()) {
            return false;
        }
        start++;
        return true;
    }

    public boolean isEmpty() {
        return start >= data.size();
    }

    public int front() {
        return data.get(start);
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enqueue(5);
        q.enqueue(3);
        if (q.isEmpty() == false) {
            System.out.println(q.front());
        }
        q.dequeue();
        if (q.isEmpty() == false) {
            System.out.println(q.front());
        }
        q.dequeue();
        if (q.isEmpty() == false) {
            System.out.println(q.front());
        }
    }
}
