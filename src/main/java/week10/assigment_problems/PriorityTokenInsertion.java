package week10.assigment_problems;

public class PriorityTokenInsertion {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class SingleLinkedList {
        private Node head;
        private int size;

        public SingleLinkedList() {
            this.head = null;
            this.size = 0;
        }

        // Time Complexity: O(1)
        public void addFirst(int token) {
            Node newNode = new Node(token);
            newNode.next = head;
            head = newNode;
            size++;
        }

        // Time Complexity: O(n) without tail pointer, or O(1) with tail. Here O(n) traversing to end.
        public void addLast(int token) {
            Node newNode = new Node(token);
            if (head == null) {
                head = newNode;
            } else {
                Node curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = newNode;
            }
            size++;
        }

        // Time Complexity: O(index) -> O(n)
        public void insertAt(int index, int token) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            if (index == 0) {
                addFirst(token);
                return;
            }
            Node newNode = new Node(token);
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
        }

        public void printList() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " -> ");
                curr = curr.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.addLast(101);
        list.addLast(102);
        list.addLast(103);

        list.addFirst(100);
        list.addLast(104);
        list.insertAt(2, 150);

        // Expected Output: 100 -> 101 -> 150 -> 102 -> 103 -> 104 -> null
        list.printList();
    }
}
