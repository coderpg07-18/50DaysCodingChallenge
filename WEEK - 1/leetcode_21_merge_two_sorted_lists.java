
public class leetcode_21_merge_two_sorted_lists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode mergedLL = new ListNode(-1);
        ListNode temp = mergedLL;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        while (list1 != null) {
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }

        while (list2 != null) {
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public ListNode getMid(ListNode list) {
        ListNode slow = list;
        ListNode fast = list.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // mid value
    }

    public ListNode listHalfs(ListNode list) {
        // Base Case --
        if (list == null || list.next == null) {
            return list;
        }

        // find mid --
        ListNode mid = getMid(list);

        // divide lis --
        ListNode rightList = mid.next;
        mid.next = null;

        // listHalfs;
        ListNode list1 = listHalfs(list);
        ListNode list2 = listHalfs(rightList);

        // merge --
        return mergeTwoLists(list1, list2);
    }

    public void main(String[] args) {
        ListNode list = new ListNode(4);
        list.next = new ListNode(3);
        list.next.next = new ListNode(2);
        list.next.next.next = new ListNode(1);
        
        // 4 --> 3 --> 2 --> 1 --> null

        list  = listHalfs(list);

        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}