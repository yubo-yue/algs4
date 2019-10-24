package leetcode.queue_stack;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/perfect-squares
 *
 * DP solution...
 */
public class PerfectSquare {

    public int numSquares(int n) {
        int[] ret = new int[n + 1];
        Arrays.fill(ret, Integer.MAX_VALUE);
        ret[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                ret[i] = Math.min(ret[i - j * j] + 1, ret[i]);
            }
        }
        return ret[n];
    }

    public static void main(String[] args) {
        final PerfectSquare ps = new PerfectSquare();

        System.out.println(ps.numSquares(444));
//        for (int i = 1; i < 10; i++) {
//            System.out.println("Perfect square for " + i + " is " + ps.numSquares(i));
//        }
    }
}
