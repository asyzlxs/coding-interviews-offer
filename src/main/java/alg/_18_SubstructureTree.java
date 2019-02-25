package alg;

public class _18_SubstructureTree {

    public static class BinaryTreeNode {
        public int val;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
        }
    }


    public static boolean hasSubtree(BinaryTreeNode node1, BinaryTreeNode node2) {
        boolean result = false;

        if (node1 != null && node2 != null) {
            System.out.println("node1:" + node1.val + " node2:" + node2.val);
            if (node1.val == node2.val)
                result = doesTree1HaveTree2(node1, node2);
            if (!result)
                result = hasSubtree(node1.left, node2);
            if (!result)
                result = hasSubtree(node1.right, node2);
        }
        return result;

    }

    public static boolean doesTree1HaveTree2(BinaryTreeNode node1, BinaryTreeNode node2) {
        if (node2 == null)
            return true;
        if (node1 == null)
            return false;
        if (node1.val != node2.val)
            return false;

        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }


    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(8);
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        root1.left = node1;
        BinaryTreeNode node2 = new BinaryTreeNode(9);
        node1.left = node2;
        BinaryTreeNode node3 = new BinaryTreeNode(2);
        node1.right = node3;
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        node3.left = node4;
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        node3.right = node5;
        BinaryTreeNode node6 = new BinaryTreeNode(7);
        root1.right = node6;
        BinaryTreeNode root2 = new BinaryTreeNode(8);
        BinaryTreeNode node7 = new BinaryTreeNode(9);
        root2.left = node7;
        BinaryTreeNode node8 = new BinaryTreeNode(2);
        root2.right = node8;
        System.out.println(hasSubtree(root1, root2));


    }


}
