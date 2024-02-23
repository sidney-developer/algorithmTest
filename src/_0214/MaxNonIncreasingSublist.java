package _0214;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MaxNonIncreasingSublist {
    public static ListNode getLongestContinuousNonIncreasingSubsequence(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode maxStart = null;
        ListNode maxEnd = null;
        int maxLength = 0;
        int currentLength = 1;

        ListNode currentStart = head;
        ListNode currentEnd = head;

        while (head.next != null) {
            if (head.val >= head.next.val) {
                currentEnd = head.next;
                currentLength++;
            } else {
                if (currentLength > maxLength) {
                    maxStart = currentStart;
                    maxEnd = currentEnd;
                    maxLength = currentLength;
                }
                currentLength = 1;
                currentStart = head.next;
                currentEnd = head.next;
            }

            head = head.next;
        }

        // Check if the longest sublist extends till the end of the original list
        if (currentLength > maxLength) {
            maxStart = currentStart;
            maxEnd = currentEnd;
            maxLength = currentLength;
        }

        if (maxStart != null && maxEnd != null) {
            maxEnd.next = null;
        }

        return maxStart;
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

        ListNode longestSublist = getLongestContinuousNonIncreasingSubsequence(head);

        System.out.print("The longest continuous non-increasing sublist is: ");
        while (longestSublist != null) {
            System.out.print(longestSublist.val + " ");
            longestSublist = longestSublist.next;
        }
    }
}
