package leetcode.bst;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {

    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();

        putToStack(root);
    }

    private void putToStack(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode top = stack.pop();
        if (top.right != null) {
            putToStack(top.right);
        }
        return top.val;
    }

    public boolean hasNext() {
        return !this.stack.isEmpty();
    }
}
