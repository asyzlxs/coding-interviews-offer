package alg;

public class _06_ConstructBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    public static TreeNode construct(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length)
            return null;
        TreeNode root = new TreeNode(0);
        constructCore(root, preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, LEFT);
        return root.left;
    }

    public static void constructCore(TreeNode root, int[] preOrder, int preStart, int preEnd,
                                     int[] inOrder, int inStart, int inEnd, int leftOrRight) {
        if (root == null || preStart > preEnd || inStart > inEnd)
            return;
        int rootSonVal = preOrder[preStart];
        int leftLen = 0;
        int i;
        for (i = inStart; i <= inEnd; ++i) {
            if (inOrder[i] == rootSonVal) {
                leftLen = i - inStart;
                break;
            }
        }
        if (i > inEnd)
            return;
        TreeNode rootSon = new TreeNode(rootSonVal);
        if (leftOrRight == LEFT) {
            root.left = rootSon;
        }
        if (leftOrRight == RIGHT) {
            root.right = rootSon;
        }
        constructCore(rootSon, preOrder, preStart + 1, preStart + leftLen, inOrder, inStart, inStart + leftLen - 1, LEFT);
        constructCore(rootSon, preOrder, preStart + leftLen + 1, preEnd, inOrder, inStart + leftLen + 1, inEnd, RIGHT);
    }

    /**
     * 前序遍历
     */
    private static void preOrder(TreeNode root) {
        if (root == null)
            return;
        int value = root.val;
        System.out.print(value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     */
    private static void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }


    public static void main(String[] args) {
        System.out.println("==============test1==============");
        TreeNode root = _06_ConstructBinaryTree.construct(
                new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 2, 5, 1, 6, 3, 7});
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
    }
}
