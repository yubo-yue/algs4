package leetcode.queue_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class ValidParenthese {
    public boolean isValid(final String s) {
        Set<Character> parenthese = new HashSet<>();
        parenthese.addAll(Arrays.asList('[', ']', '(', ')', '{', '}'));

        if (s == null || s.length() == 0) {
            return true;
        }

        Deque<Character> operators = new ArrayDeque<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (!parenthese.contains(chars[i])) {
                continue;
            }

            if (chars[i] == '[' || chars[i] == '{' || chars[i] == '(') {
                operators.push(chars[i]);
            }

            if (chars[i] == ']') {
                if (operators.isEmpty() || operators.peek() != '[') {
                    return false;
                } else {
                    operators.pop();
                }
            }
            if (chars[i] == '}') {
                if (operators.isEmpty() || operators.peek() != '{') {
                    return false;
                } else {
                    operators.pop();
                }
            }
            if (chars[i] == ')') {
                if (operators.isEmpty() || operators.peek() != '(') {
                    return false;
                } else {
                    operators.pop();
                }
            }
        }

        return operators.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        final String a = "{[]}";
        System.out.println(new ValidParenthese().isValid(a));
    }
}
