package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

public class GroupAnagramTest {

    @Test
    public void test() {
        final GroupAnagram groupAnagram = new GroupAnagram();
        final String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        final List<List<String>> result = groupAnagram.groupAnagrams(input);

        for (List<String> list : result) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }

    }
}
