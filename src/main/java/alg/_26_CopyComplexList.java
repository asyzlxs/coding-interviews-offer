package alg;

public class _26_CopyComplexList {

    public static class ComplexNode {
        public int val;
        public ComplexNode next;
        public ComplexNode sibling;

        public ComplexNode() {

        }

        public ComplexNode(int val) {
            this.val = val;
        }
    }

    public static void cloneNodes(ComplexNode node) {
        if (node == null) return;
        while (node != null) {
            ComplexNode copyNode = new ComplexNode();
            copyNode.val = node.val;
            copyNode.next = node.next;
            node.next = copyNode;
            node = copyNode.next;
        }
    }

    public static void connectSiblingNodes(ComplexNode node) {
        if (node == null) return;
        while (node != null) {
            ComplexNode copyNode = node.next;
            if(node.sibling != null) copyNode.sibling = node.sibling.next;
            node = copyNode.next;
        }
    }

    public static ComplexNode reconnectedNodes(ComplexNode node) {
        if (node == null) return null;

        ComplexNode copyNode = new ComplexNode();
        ComplexNode head = new ComplexNode();

        if (node.next != null) {
            head = node.next;
            copyNode = head;
        }

        while (copyNode.next != null) {
            node.next = copyNode.next;
            copyNode.next = node.next.next;
            node = node.next;
            copyNode = copyNode.next;
        }

        return head;
    }

    public static ComplexNode copyComplexList(ComplexNode root) {
        cloneNodes(root);
        connectSiblingNodes(root);
        return reconnectedNodes(root);
    }

    public static void main(String[] args) {
        ComplexNode node1 = new ComplexNode(1);
        ComplexNode node2 = new ComplexNode(2);
        node1.next = node2;
        ComplexNode node3 = new ComplexNode(3);
        node2.next = node3;
        ComplexNode node4 = new ComplexNode(4);
        node3.next = node4;
        ComplexNode node5 = new ComplexNode(5);
        node4.next = node5;
        node1.sibling = node3;
        node2.sibling = node5;
        node4.sibling = node2;

        printComplexList(node1);

        ComplexNode complexNode = copyComplexList(node1);
        printComplexList(complexNode);

    }


    public static void printComplexList(ComplexNode root) {
        if (root == null) return;
        ComplexNode node = root;
        while (node != null) {
            System.out.print("(" + node.val + ",");
            if (node.next != null) {
                System.out.print(node.next.val + ",");
            } else {
                System.out.print("-" + ",");
            }

            if (node.sibling != null) {
                System.out.print(node.sibling.val + ")");
            } else {
                System.out.print("-" + ")");
            }
            System.out.println();

            node = node.next;
        }
    }


}
