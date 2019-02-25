package alg;

import java.util.Iterator;
import java.util.Stack;

public class _05_PrintListInReversedOrder {

    public static class ListNode {
        public ListNode next;
        public int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static Stack<ListNode> printListFromTailToHead(ListNode head) {
        if (head == null)
            return null;

        Stack<ListNode> listNodeStack = new Stack<ListNode>();
        listNodeStack.push(head);
        while (head.next != null) {
            head = head.next;
            listNodeStack.push(head);
        }
        return listNodeStack;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Stack<ListNode> stack = _05_PrintListInReversedOrder.printListFromTailToHead(node1);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().val);
        }
    }


}
