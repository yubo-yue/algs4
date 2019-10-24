package leetcode.queue_stack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * Medium https://leetcode.com/problems/open-the-lock/
 */
public class OpenTheLock {

    public int openLock(final String[] deadends, final String target) {
        final Set<String> deads = new HashSet<>();
        for (final String deadend : deadends) {
            deads.add(deadend);
        }

        final Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        queue.offer(null);

        final Set<String> seen = new HashSet();
        seen.add("0000");

        int depth = 0;

        while (!queue.isEmpty()) {
            final String node = queue.poll();
            if (Objects.isNull(node)) {
                depth++;
                if (Objects.nonNull(queue.peek())) {
                    queue.offer(null);
                }
            } else if (node.equals(target)) {
                return depth;
            } else if (!deads.contains(node)) {
                for (int i = 0; i < 4; i++) {
                    for (int d = -1; d <= 1; d = d + 2) {
                        int y = ((node.charAt(i) - '0') + d + 10) % 10;
                        final String neighbor = node.substring(0, i) + ("" + y) + node.substring(i + 1);
                        if (!seen.contains(neighbor)) {
                            seen.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        final String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        final String target = "0202";

        System.out.println(new OpenTheLock().openLock(deadends, target));
    }
}
