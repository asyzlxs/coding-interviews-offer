package alg;

import java.util.*;

public class _50_GetLastCommonParent {

    public static class TreeNode {
        char val;
        LinkedList<TreeNode> children;

        public TreeNode(char val) {
            this.val = val;
        }
    }


    public static boolean getNodePath(TreeNode root, TreeNode pNode, LinkedList<TreeNode> treeNodeList) {

        if (root.val == pNode.val)
            return true;

        boolean found = false;
        treeNodeList.add(root);
        if (root.children == null) {
            treeNodeList.removeLast();
            return false;
        }
        Iterator<TreeNode> children = root.children.iterator();

        while (!found && children.hasNext()) {
            TreeNode child = children.next();
            found = getNodePath(child, pNode, treeNodeList);

        }

        if (!found)
            treeNodeList.removeLast();

        return found;

    }


    public static TreeNode getLastCommonNode(LinkedList<TreeNode> list1, LinkedList<TreeNode> list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        Iterator<TreeNode> iterator1 = list1.iterator();
        Iterator<TreeNode> iterator2 = list2.iterator();
        TreeNode node1;
        TreeNode node2;
        TreeNode result = null;
        while (iterator1.hasNext() && iterator2.hasNext()) {
            node1 = iterator1.next();
            node2 = iterator2.next();
            if (node1.val == node2.val)
                result = node1;
            else
                break;
        }

        return result;
    }

    public static TreeNode getLastCommonParent(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null) return null;
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<>();
        getNodePath(root, node1, list1);
        getNodePath(root, node2, list2);
        return getLastCommonNode(list1, list2);
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode('A');
        TreeNode node2 = new TreeNode('B');
        TreeNode node3 = new TreeNode('C');
        TreeNode node4 = new TreeNode('D');
        TreeNode node5 = new TreeNode('E');
        TreeNode node6 = new TreeNode('F'); //F
        TreeNode node7 = new TreeNode('G');
        TreeNode node8 = new TreeNode('H'); //H
        TreeNode node9 = new TreeNode('I');
        TreeNode node10 = new TreeNode('J');
        LinkedList<TreeNode> list1 = new LinkedList<>();
        LinkedList<TreeNode> list2 = new LinkedList<>();
        LinkedList<TreeNode> list4 = new LinkedList<>();
        LinkedList<TreeNode> list5 = new LinkedList<>();
        list1.add(node2);
        list1.add(node3);
        list2.add(node4);
        list2.add(node5);
        list4.add(node6);
        list4.add(node7);
        list5.add(node8);
        list5.add(node9);
        list5.add(node10);
        node1.children = list1;
        node2.children = list2;
        node4.children = list4;
        node5.children = list5;
//        LinkedList<TreeNode> path1 = new LinkedList<>();
//        System.out.println(getNodePath(node1, new TreeNode('F'), path1));
//        for (TreeNode node : path1) {
//            System.out.print(node.val + " ");
//        }
//        System.out.println();

        System.out.println(getLastCommonParent(node1,new TreeNode('F'),new TreeNode('H')).val);

    }
}
