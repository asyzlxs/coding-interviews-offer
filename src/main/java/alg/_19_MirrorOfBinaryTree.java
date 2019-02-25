package alg;

public class _19_MirrorOfBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void MirrorRecursively(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        MirrorRecursively(root.left);
        MirrorRecursively(root.right);

    }


}

