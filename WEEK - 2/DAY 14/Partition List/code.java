
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

public class code {

    public ListNode partition(ListNode head, int x) {

        ListNode smallNodesLL = new ListNode(0);
        ListNode largeNodesLL = new ListNode(0);

        ListNode lessVal = smallNodesLL;
        ListNode greatVal = largeNodesLL;

        while (head != null) {

            if (head.val < x) {
                lessVal.next = head;
                lessVal = lessVal.next;
            } else {
                greatVal.next = head;
                greatVal = greatVal.next;
            }

            head = head.next;
        }

        greatVal.next = null;
        lessVal.next = largeNodesLL.next;

        return smallNodesLL.next;
    }

    public static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        code output = new code();

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        System.out.println("Original Linked List:");
        display(head);

        int x = 3;

        ListNode result = output.partition(head, x);

        System.out.println("Partitioned Linked List:");
        display(result);
    }
}
