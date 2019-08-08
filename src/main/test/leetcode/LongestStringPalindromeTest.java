package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestStringPalindromeTest {

    private final LongestStringPalindrome solution = new LongestStringPalindrome();

    @Test
    public void test() {
        String r = solution.longestPalindrome("babad");
        assertEquals(3, r.length());
        assertEquals("aba", r);
    }

    @Test
    public void test1() {
        String r = solution.longestPalindrome("cbbd");
        assertEquals(2, r.length());
        assertEquals("bb", r);
    }
}
