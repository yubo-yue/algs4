package leetcode.queue_stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * try to solve it by BFS
 */
public class PerfectSquare_2 {
    public int numSquares(int n) {
        if (n <= 0) return 0;

        final Queue<Integer> queue = new LinkedList<>();
        int step = 0;
        queue.offer(n);
        boolean isFound = false;

        while (!queue.isEmpty() && !isFound) {
            step = step + 1;
            int size = queue.size();
            for (int i = 0; i < size && !isFound; i++) {
                int cur = queue.poll();
                for (int j = (int) Math.sqrt(cur); j * j <= cur; j--) {
                    if (cur - j * j == 0) {
                        isFound = true;
                        break;
                    }
                    queue.offer(cur - j * j);
                }
            }
        }

        return step;
    }

    public static void main(String[] args) {
        final PerfectSquare_2 ps = new PerfectSquare_2();

        System.out.println(ps.numSquares(444));
//        for (int i = 1; i < 500; i++) {
//            System.out.println("Perfect square for " + i + " is " + ps.numSquares(i));
//        }
    }
}
