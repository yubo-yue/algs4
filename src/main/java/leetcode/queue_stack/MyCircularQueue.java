package leetcode.queue_stack;

public class MyCircularQueue {
    private int[] data;
    private int head = -1, tail = -1;
    private int size;

    public MyCircularQueue(int k) {
        data = new int[k];
        size = k;
    }

    public boolean enqueue(int element) {
        if (isFull()) return false;
        if (isEmpty()) head = 0;
        tail = (tail + 1) % size;
        data[tail] = element;
        return true;
    }

    public boolean dequeue() {
        if (isEmpty()) {
            return false;
        }

        if (head == tail) {
            head = tail = -1;
            return true;
        }

        head = (head + 1) % size;
        return true;
    }

    public int front() {
        if (isEmpty()) {
            return -1;
        }

        return data[head];
    }

    public int tail() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }
}
