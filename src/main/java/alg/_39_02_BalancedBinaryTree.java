package alg;

public class _39_02_BalancedBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static boolean isBalanced(TreeNode root) {
        int depth = 0;
        return isBalanced(root, depth);
    }

    public static boolean isBalanced(TreeNode root, int depth) {
        if (root == null) {
            return true;
        }

        int left = 0, right = 0;
        if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
            int diff = left - right;
            if (diff >= -1 && diff <= 1)
                return true;
        }
        return false;
    }


}
