package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringTwoDistinct {

    public int lengthOfLongestSubstringKeyDistinct(String s, Integer k) {
        int n = s.length();
        if (n < k) return n;

        int left = 0, right = 0;

        Map<Character, Integer> hashmap = new HashMap<>();

        int maxLen = k;
        while (right < n) {
            if (hashmap.size() < k + 1) {
                hashmap.put(s.charAt(right), right++);
            }

            if (hashmap.size() == k + 1) {
                int delIndex = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(delIndex));
                left = delIndex + 1;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}
