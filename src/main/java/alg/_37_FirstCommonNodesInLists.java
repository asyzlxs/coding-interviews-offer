package alg;

public class _37_FirstCommonNodesInLists {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode findFirstCommonNode(ListNode n1, ListNode n2) {
        int l1 = getListLength(n1);
        int l2 = getListLength(n2);
        ListNode longHead, shortHead;
        int diffLength = 0;
        if (l1 > l2) {
            longHead = n1;
            shortHead = n2;
            diffLength = l1 - l2;
        } else {
            longHead = n2;
            shortHead = n1;
            diffLength = l2 - l1;
        }

        while (diffLength > 0) {
            longHead = longHead.next;
            --diffLength;
        }


        while (longHead != null && shortHead != null && longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }

        return longHead;
    }

    public static int getListLength(ListNode node) {
        int length = 0;

        if (node == null) return length;

        while (node != null) {
            node = node.next;
            ++length;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node6.next = node7;
        node4.next = node5;
        node5.next = node6;
        System.out.println(findFirstCommonNode(node1,node4).val);


    }


}
