
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

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode curr = head;

        while (curr != null && curr.next != null) {

            int gcd_val = GCD(curr.val, curr.next.val);

            ListNode newNode = new ListNode(gcd_val);

            newNode.next = curr.next;
            curr.next = newNode;

            curr = newNode.next;
        }

        return head;
    }

    // Euclidean Algorithm to calculate GCD
    public int GCD(int a, int b) {

        while (b != 0) {

            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
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

        code output = new code();

        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);

        System.out.print("Original List: ");
        output.display(head);

        head = output.insertGreatestCommonDivisors(head);

        System.out.print("Updated List: ");
        output.display(head);
    }
}
