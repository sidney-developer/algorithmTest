package amazon;



public class _8_findLongestList {

    //two pointers
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode findLongestList (ListNode head) {

        ListNode currentHead= head;
        ListNode currentEnd= head;

        ListNode maxHead= head;
        ListNode maxEnd= head;
        int currentLength =1;
        int maxLength=0;

        while (head.next!= null) {
            if (head.val>= head.next.val) {
                currentEnd=head.next;
                currentLength++;
            } else {
                if (currentLength> maxLength) {
                    maxHead= currentHead;
                    maxEnd= currentEnd;
                    maxLength= currentLength;
                }
                currentHead= head.next;
                currentEnd= head.next;
                currentLength =1;
            }
            head= head.next;
        }
        // To decide whether the last sublist is the longest non-increasing sublist
        if (currentLength > maxLength){
            maxHead= currentHead;
            maxEnd= currentEnd;
            maxLength= currentLength;
        }

        maxEnd.next= null;
        return maxHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(3);
        ListNode node8 = new ListNode(3);
        ListNode node9 = new ListNode(1);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        ListNode longestSublist = findLongestList(head);

        System.out.print("The longest continuous non-increasing sublist is: ");
        while (longestSublist != null) {
            System.out.print(longestSublist.val + " ");
            longestSublist = longestSublist.next;
        }
    }

}
