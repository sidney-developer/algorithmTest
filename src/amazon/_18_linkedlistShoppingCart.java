package amazon;

import java.util.List;

public class _18_linkedlistShoppingCart {

    public static void main(String[] args) {
        ListNode node1=new ListNode("pen");
        ListNode node2= new ListNode("cup");
        ListNode node3= new ListNode("fan");
        ListNode node4= new ListNode("jam");
    }

    public static class ListNode {
        String data;
        ListNode next;
        public ListNode(String d) {
            data=d;
        }
    }
    public static ListNode getShoppingCart(ListNode head, List<List<String>> operations) {

        ListNode tail= head;
        while (tail.next!=null) {
            tail= tail.next;
        }
        // PUSH_HEAD
        // PUSH_TAIL
        // POP_HEAD
        for (List<String> operation : operations) {
            String opera= operation.get(0);
            String name= operation.get(1);
            if (opera.equals("PUSH_HEAD")) {
                ListNode node= new ListNode(name);
                node.next= head;
                head= node;
                if (tail ==null) {
                    tail= node;
                }
            }else if (opera.equals("PUSH_TAIL")) {
                ListNode node= new ListNode(name);
                if (tail==null) {
                    head= node;
                    tail= node;
                }else {
                    tail.next= node;
                    tail= node;
                }
            }else {
                ListNode cur= head;
                head= head.next;
                cur.next= null;
                if (head==null) {
                    tail= null;
                }
            }
        }
        return head;
    }
}
