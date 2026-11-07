
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class leetcode_61_rotate_list {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        int len = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        k = k % len;

        if (k == 0)
            return head;

        tail.next = head;

        // Find new tail
        int steps = len - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    public void display(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        leetcode_61_rotate_list rt_lst = new leetcode_61_rotate_list();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        head = rt_lst.rotateRight(head, k);

        System.out.print("Rotated List: ");
        rt_lst.display(head);
    }
}
