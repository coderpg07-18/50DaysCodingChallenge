
public class leetcode_203_remove_linked_list_elements {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        
        head.next = removeElements(head.next, val);
        
        if (head.val == val) {

            return head.next;
        
        } else {
        
            return head;
        }

        // ListNode temp = new ListNode(-1);
        // temp.next = head;

        // ListNode prev = temp;
        // ListNode curr = head;

        // while (curr != null) {

        //     if (curr.val == val) {
        //         prev.next = curr.next;
        //     } else {
        //         prev = curr;
        //     }

        //     curr = curr.next;
        // }

        // return temp.next;
    }

    public void print(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        leetcode_203_remove_linked_list_elements ll = new leetcode_203_remove_linked_list_elements();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        int val = 6;

        head = ll.removeElements(head, val);

        ll.print(head);
    }
}