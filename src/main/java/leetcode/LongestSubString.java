package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubString {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return ans;
    }

    public int lengthOfLongestSubstring_1(String s) {
        int n = s.length(), ans = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i - 1);
            }
            ans = Math.max(ans, j - i);
            map.put(s.charAt(j), j);
        }

        return ans;
    }
}
