import java.util.*;

public class code {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // calculate size --
        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (n == size) {
            head = head.next;
            return head;
        }

        // size-n -- actual pre.
        int i = 1;
        int i_to_find = size-n;

        ListNode prev = head;

        while (i < i_to_find) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }

    public void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head  = removeNthFromEnd(head, 2);  // here, 2 is n -- 2nd element from last --

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}