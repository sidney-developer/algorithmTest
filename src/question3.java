import java.util.*;

public class question3 {

    public static void main(String[] args) {

        MyLinkedList mll= new MyLinkedList();
        mll.addAtHead(1);
        mll.addAtTail(3);
        mll.addAtIndex(1,2);
        System.out.println(mll.get(1));
        mll.deleteAtIndex(1);
        System.out.println(mll.get(1));
    }

    static class MyLinkedList {

        public class ListNode {
            public int val;
            public ListNode next;
            public ListNode prev;

            public ListNode (int val) {
                this.val= val;
            }
        }

        private ListNode head;
        private ListNode tail;
        private int size;
        //1
        // get delete 时候 对 size 和 index 的计算
        public MyLinkedList() {
            head= new ListNode(0);
            tail= new ListNode(0);
            head.next= tail;
            tail.prev= head;
            size=0;
        }


        public int get(int index) {
            if (index<0 || index> size-1) {
                return -1;
            }
            int ans;
            if (index +1 < size- index) {
                ListNode cur= head;
                for (int i=0; i< index+1; i++) {
                    cur= cur.next;
                }
                ans= cur.val;
            }else {
                ListNode cur= tail;
                for (int i=0; i< size- index; i++) {
                    cur= cur.prev;
                }
                ans= cur.val;
            }
            return ans;
        }

        public void addAtHead(int val) {
            ListNode node= new ListNode(val);
            ListNode next= head.next;
            head.next= node;
            node.prev= head;
            node.next= next;
            next.prev= node;
            size++;
        }

        public void addAtTail(int val) {
            ListNode node= new ListNode(val);
            ListNode prev= tail.prev;
            prev.next= node;
            node.prev= prev;
            node.next= tail;
            tail.prev= node;
            size++;
        }

        public void addAtIndex(int index, int val) {

            if (index <0 || index> size) {
                return;
            }
            ListNode node= new ListNode(val);
            if (index < size- index) {
                ListNode cur= head;
                for (int i=0; i<index ; i++) {
                    cur= cur.next;
                }
                ListNode next= cur.next;
                cur.next= node;
                node.prev= cur;
                node.next= next;
                next.prev= node;
            }else {
                ListNode cur=tail;
                for (int i=0; i< size- index; i++) {
                    cur= cur.prev;
                }
                ListNode prev= cur.prev;
                prev.next= node;
                node.prev= prev;
                node.next= cur;
                cur.prev= node;
            }
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index<0 || index> size-1) {
                return;
            }
            if (index <size- index-1) {
                ListNode cur= head;
                for (int i=0; i<index; i++) {
                    cur= cur.next;
                }
                ListNode next= cur.next.next;
                cur.next= next;
                next.prev= cur;
            }else {
                ListNode cur= tail;
                for (int i=0; i<size- index-1 ; i++) {
                    cur= cur.prev;
                }
                ListNode prev= cur.prev.prev;
                prev.next= cur;
                cur.prev= prev;
            }
            size--;
        }
    }
}
