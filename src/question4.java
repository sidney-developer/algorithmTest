import java.util.*;

public class question4 {

    public static void main(String[] args) {
        LRUCache cache= new LRUCache(1);
        cache.put(2,1);
        System.out.println(cache.get(2));
        cache.put(3,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

    static class LRUCache {

        private HashMap<Integer, Node> hashMap;
        private DoubledLinkedList doubledLinkedList;
        private final int cap;

        // 3
        public LRUCache(int capacity) {
            hashMap= new HashMap<>();
            doubledLinkedList= new DoubledLinkedList(capacity);
            cap= capacity;
        }

        public int get(int key) {
            if (hashMap.containsKey(key)) {
                Node node= hashMap.get(key);
                doubledLinkedList.moveToTail(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (!hashMap.containsKey(key)) {
                if (hashMap.size()== cap) {
                    Node node=doubledLinkedList.removeHead();
                    hashMap.remove(node.key);
                }
                Node newNode= new Node(key, value);
                hashMap.put(key, newNode);
                doubledLinkedList.addToTheTail(newNode);
            }else {
                Node cur = hashMap.get(key);
                cur.value= value;
                doubledLinkedList.moveToTail(cur);
            }
        }

        public class DoubledLinkedList {
            public Node head;
            public Node tail;
            public final int capacity;

            public DoubledLinkedList(int c) {
                capacity=c;
            }

            //move a certain node to the tail;
            //when the key already exist
            public void moveToTail(Node node) {
                if (node== tail) {
                    return;
                }
                if (node ==head) {
                    head= head.next;
                    head.last= null;
                }else {
                    node.last.next= node.next;
                    node.next.last= node.last;
                }
                node.next=null;
                node.last= tail;
                tail.next= node;
                tail= tail.next;
            }

            // add a node to the tail
            // check the capacity
            public void addToTheTail(Node node) {
                if (head== null) {
                    head=node;
                    tail=node;
                }else {
                    tail.next = node;
                    node.last = tail;
                    tail = tail.next;
                }
            }

            public Node removeHead () {
                if (head== null) {
                    return null;
                }
                if (head==tail) {
                    Node cur= head;
                    head=null;
                    tail= null;
                    return cur;
                }
                Node cur= head;
                head= head.next;
                head.last=null;
                cur.next=null;
                return cur;
            }

        }

        public class Node {
            public int key;
            public int value;
            public Node next;
            public Node last;

            public Node (int k, int v) {
                key=k;
                value=v;
            }
        }
    }
}
