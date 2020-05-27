package leetcode.bst;

import java.util.ArrayDeque;
import java.util.Objects;

public class InOrderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (Objects.isNull(root) && Objects.isNull(p)) {
            return null;
        }

        if (Objects.nonNull(p.right)) {
            p = p.right;
            while (Objects.nonNull(p.left)) {
                p = p.left;
            }
            return p;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int inorder = Integer.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (null != root) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (inorder == p.val) return root;
            inorder = root.val;

            root = root.right;
        }

        return null;
    }
}
