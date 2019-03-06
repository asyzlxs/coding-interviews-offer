package alg;


import java.security.PublicKey;

public class _45_01_LastNumberInCircle {

    public static class ListNode {
        int val;
        ListNode pre;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static int lastRemaining(int n, int m) {
        if (n <= 1) return 1;

        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < n; ++i) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        cur.next = head;

        while (n != 1) {
            int step = (m - 1) % n;
            for (int i = 0; i < step; ++i) {
                cur = cur.next;
            }
            System.out.println(cur.next.val);

            cur.next = cur.next.next;
            --n;
        }

        return cur.val;
    }


    public static void main(String[] args) {
        System.out.println(lastRemaining(5,3));
    }


}
