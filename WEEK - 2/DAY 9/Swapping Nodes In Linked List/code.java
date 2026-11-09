
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

class code {

    public ListNode swapNodes(ListNode head, int k) {

        ListNode sv1 = head;

        // kth node from beginning
        for (int i = 1; i < k; i++) {
            sv1 = sv1.next;
        }

        ListNode fast = sv1;
        ListNode sv2 = head;

        // kth node from end
        while (fast.next != null) {
            fast = fast.next;
            sv2 = sv2.next;
        }

        // Swap node values
        int temp = sv1.val;
        sv1.val = sv2.val;
        sv2.val = temp;

        return head;
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

        code swap = new code();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        System.out.print("Original List: ");
        swap.display(head);

        head = swap.swapNodes(head, k);

        System.out.print("Swapped List: ");
        swap.display(head);
    }
}
