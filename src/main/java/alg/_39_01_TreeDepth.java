package alg;

public class _39_01_TreeDepth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int treeDepth(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int left = treeDepth(treeNode.left);
        int right = treeDepth(treeNode.right);

        return (left > right ? (left + 1) : (right + 1));
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node5.left = node7;
        System.out.println(treeDepth(node1));




    }
}
