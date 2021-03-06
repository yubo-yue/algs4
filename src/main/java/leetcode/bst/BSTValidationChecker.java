package leetcode.bst;

import java.util.Objects;

/**
 * Check is binary tree is BST.
 */
public class BSTValidationChecker {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer lowest, Integer highest) {
        if (Objects.isNull(node)) {
            return true;
        }

        int val = node.val;

        if (Objects.nonNull(lowest) && val <= lowest) return false;
        if (Objects.nonNull(highest) && val >= highest) return false;

        if (!helper(node.right, val, highest)) return false;
        if (!helper(node.left, lowest, val)) return false;

        return true;
    }

    public static void main(String[] args) {
        int[] input_01 = {2, 1, 3};
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        boolean result = new BSTValidationChecker().isValidBST(root);
        System.out.println("root is BST " + result);
    }
}
