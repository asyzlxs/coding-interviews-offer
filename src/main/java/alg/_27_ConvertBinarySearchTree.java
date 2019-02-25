package alg;

public class _27_ConvertBinarySearchTree {

    public static class BinarySearchNode {
        public int val;
        public BinarySearchNode left;
        public BinarySearchNode right;

        public BinarySearchNode(int val) {
            this.val = val;
        }

        public BinarySearchNode() {

        }

    }


//    public static BinarySearchNode convert(BinarySearchNode root) {
//        BinarySearchNode lastNodeInList = null;
//        convertNode(root, lastNodeInList);
//        BinarySearchNode headNodeInList = lastNodeInList;
//        while (headNodeInList !=null && headNodeInList.left != null) {
//            System.out.println(4);
//            headNodeInList = headNodeInList.left;
//        }
//        return headNodeInList;
//    }

//    public static void convertNode(BinarySearchNode root, BinarySearchNode lastNodeInList) {
//
//        if (root.left != null)
//            convertNode(root.left, lastNodeInList);
//
//        root.left = lastNodeInList;
//        if (lastNodeInList != null)
//            lastNodeInList.right = root;
//
//        lastNodeInList = root;
//
//        if (root.right != null)
//            convertNode(root.right, lastNodeInList);
//    }

    private BinarySearchNode lastNodeInList;


    public BinarySearchNode Convert(BinarySearchNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;

        lastNodeInList = new BinarySearchNode(0);
        ConvertCore(pRootOfTree);

        BinarySearchNode cur = lastNodeInList;
        while (cur.left != null) {
            cur = cur.left;
        }
        cur = cur.right;
        cur.left = null;
        return cur;
    }

    private void ConvertCore(BinarySearchNode root) {
        if (root.left != null)
            ConvertCore(root.left);

        lastNodeInList.right = root;
        root.left = lastNodeInList;
        lastNodeInList = root;

        if (root.right != null)
            ConvertCore(root.right);
    }


    public static void main(String[] args) {
        BinarySearchNode node1 = new BinarySearchNode(8);
        BinarySearchNode node2 = new BinarySearchNode(4);
        BinarySearchNode node3 = new BinarySearchNode(12);
        BinarySearchNode node4 = new BinarySearchNode(1);
        BinarySearchNode node5 = new BinarySearchNode(6);
        BinarySearchNode node6 = new BinarySearchNode(9);
        BinarySearchNode node7 = new BinarySearchNode(14);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        _27_ConvertBinarySearchTree conv = new _27_ConvertBinarySearchTree();
        BinarySearchNode head = conv.Convert(node1);
        printTree(head);
    }


    private static void printTree(BinarySearchNode root) {
        BinarySearchNode cur = root;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

}
