
public class leetcode_234_palindrome_linked_list {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {
        // find mid
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        // reverse 2nd half
        ListNode curr = mid.next; // lastElementSecondHalf
        mid.next = null;  // 1st half breaked

        ListNode prev = null;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        ListNode left = head;  // firstElementfirstHalf
        ListNode right = prev;  // firstElementsecondHalf

        // compare
        while (left != null && right != null) {

            if (left.val != right.val) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }

    public void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        
        // 1 --> 2 --> 2 --> 3 --> null

        System.out.println( isPalindrome(head) );
    }
}