package leetcode.queue_stack;

import java.util.Arrays;

public class DayTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] ansIndexDiff = new int[T.length];
        int[] nextIndex = new int[101];
        Arrays.fill(nextIndex, Integer.MAX_VALUE);

        for (int i = T.length - 1; i >= 0; i--) {

            int warmerIndex = Integer.MAX_VALUE;
            for (int j = T[i] + 1; j < 101; j++) {
                if (nextIndex[j] < warmerIndex) {
                    warmerIndex = nextIndex[j];
                }
            }

            if (warmerIndex < Integer.MAX_VALUE)
                ansIndexDiff[i] = warmerIndex - i;

            nextIndex[T[i]] = i;
        }

        return ansIndexDiff;
    }
}
