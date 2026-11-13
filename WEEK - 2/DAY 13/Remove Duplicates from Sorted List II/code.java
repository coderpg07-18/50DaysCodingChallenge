
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

    public ListNode deleteDuplicates(ListNode head) {

        ListNode temp = new ListNode(0);

        temp.next = head;

        ListNode prev = temp;

        while (head != null) {

            if (head.next != null && head.val == head.next.val) {

                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }

                prev.next = head.next;

            } else {
                prev = prev.next;
            }

            head = head.next;
        }

        return temp.next;
    }

    public void display(ListNode head) {

        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        code output = new code();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        output.display(head);

        head = output.deleteDuplicates(head);

        System.out.print("Updated List: ");
        output.display(head);
    }
}
