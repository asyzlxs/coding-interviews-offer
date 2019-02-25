package alg;

import java.util.LinkedList;

public class _24_FindPath {


    public static class BinaryTreeNode {
        public int val;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    public static void findPath(BinaryTreeNode root, int sum) {
        if (root == null) return;
        int currentSum = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        findPathCore(root, currentSum, stack, sum);

    }


    public static void findPathCore(BinaryTreeNode root, int currentSum,
                                    LinkedList<Integer> stack, int sum) {

        currentSum += root.val;
        stack.addFirst(root.val);

        if (root.left == null && root.right == null) {
            if (currentSum == sum) {
                for (int i = 0; i < stack.size(); ++i) {
                    System.out.print(stack.get(i) + " ");
                }
                System.out.println();
            }
        }

        if (root.left != null) {
            findPathCore(root.left, currentSum, stack, sum);
        }

        if (root.right != null) {
            findPathCore(root.right, currentSum, stack, sum);
        }

        currentSum -= root.val;
        stack.removeFirst();

    }

    public static void main(String[] args) {

        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        node1.left = node2;
        BinaryTreeNode node3 = new BinaryTreeNode(12);
        node1.right = node3;
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        node2.left = node4;
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        node2.right = node5;

        findPath(node1, 22);

    }


}
