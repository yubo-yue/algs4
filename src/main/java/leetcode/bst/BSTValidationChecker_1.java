package leetcode.bst;

import java.util.Objects;
import java.util.Stack;

public class BSTValidationChecker_1 {
    public boolean isValidBST(TreeNode root) {
        final Stack<TreeNode> stack = new Stack<>();
        Integer previous = Integer.MIN_VALUE;

        while (!stack.isEmpty() || Objects.nonNull(root)) {
            while (Objects.nonNull(root)) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val <= previous) return false;

            previous = root.val;
            root = root.right;
        }
        return true;
    }
}
