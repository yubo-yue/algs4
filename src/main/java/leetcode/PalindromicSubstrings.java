package leetcode;

import java.util.Objects;

public class PalindromicSubstrings {
    public int countPalindromicSubstrings(final String s) {
        if (Objects.isNull(s) || s.length() < 1) return 0;

        int n = s.length(), ans = 0;

        for (int i = 0; i <= 2 * n - 1; i++) {
            int left = n / 2;
            int right = left + i % 2;
        }

    }
}
