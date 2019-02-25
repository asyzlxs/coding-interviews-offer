package alg;

public class _15_KthNodeFromEnd {

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;
        ListNode node1 = head;
        ListNode node2 = head;
        for (int i = 0; i < k - 1; ++i) {
            node1 = node1.next;
            if (node1 == null)
                return null;
        }

        while (node1.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node2;
    }


}
