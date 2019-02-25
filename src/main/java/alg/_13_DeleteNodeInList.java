package alg;

public class _13_DeleteNodeInList {


    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 如果java中如果链表只有一个头节点，要将它删除，无法把head设置为null
     * 因此不考虑deleteNode是头节点的情况
     *
     * @param head
     * @param deleteNode
     */

    public static void deleteNode(ListNode head, ListNode deleteNode) {
        if (head == null || deleteNode == null || head == deleteNode)
            return;

        ListNode temp = deleteNode.next;
        if (temp != null) {
            deleteNode.val = temp.val;
            deleteNode.next = temp.next;
        }
        else {
            ListNode node = head;
            while (node.next != deleteNode){
                node = node.next;
            }
            node.next = null;
        }
    }
}
