package leetcode.queue_stack;

/**
 * Leetcode https://leetcode.com/problems/moving-average-from-data-stream/
 */
public class MovingAverage {
    private int[] data;
    private int size;
    private int count;
    private double sum;
    private int tail;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.data = new int[size];
        this.size = size;
        this.count = 0;
        this.tail = 0;
        this.sum = 0;
    }

    public double next(int val) {
        if (count < size) {
            data[count++] = val;
            sum += val;
        } else {
            sum = sum - data[tail] + val;
            data[tail] = val;
            tail = (tail + 1) % size;
        }
        return sum / count;
    }

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(3);
        ma.next(1);
        ma.next(10);
        ma.next(3);
        System.out.println(ma.next(5));
    }
}
