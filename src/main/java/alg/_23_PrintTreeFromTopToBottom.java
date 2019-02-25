package alg;

import java.util.LinkedList;

public class _23_PrintTreeFromTopToBottom {

    public static class BinaryTreeNode {
        public int val;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    public static void printTreeFromTopToBottom(BinaryTreeNode root) {
        if (root == null) return;

        LinkedList<BinaryTreeNode> list = new LinkedList<>();
        list.addFirst(root);
        while (!list.isEmpty()) {
            System.out.print(list.getFirst().val + " ");
            BinaryTreeNode node = list.pollFirst();
            if (node.left != null) list.addLast(node.left);
            if (node.right != null) list.addLast(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        node1.left = node2;
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        node1.right = node3;
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        node2.left = node4;
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        node2.right = node5;
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        node3.left = node6;
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        node3.right = node7;

        printTreeFromTopToBottom(node1);

    }


}
