package leetcode.queue_stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallAndGate {
    private static final int EMPTY = Integer.MAX_VALUE;

    private static final int GATE = 0;

    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[]{1, 0} //down
            , new int[]{-1, 0} // up
            , new int[]{0, 1} //right
            , new int[]{0, -1} //left
    );

    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        if (rows == 0) return;
        int cols = rooms[0].length;
        final Queue<int[]> queue = new LinkedList<>(); //node waiting to be processed

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (rooms[row][col] == GATE) {
                    queue.add(new int[]{row, col});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];

            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];

                if (r < 0 || c < 0 || r >= rows || c >= cols || rooms[r][c] != EMPTY) {
                    continue;
                }

                rooms[r][c] = rooms[row][col] + 1;
                queue.add(new int[]{r, c});
            }
        }
    }
}
