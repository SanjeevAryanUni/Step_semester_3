package week10.class_problems;

public class PrintCircularLinkedList {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Prints the data of each node in a circular singly linked list exactly once.
     * Terminated by checking if current pointer has returned to head.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void printCircular(Node head) {
        if (head == null) {
            System.out.println();
            return;
        }

        Node curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample 1: 10 -> 20 -> 30 -> (back to 10)
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;

        System.out.print("Sample 1: ");
        printCircular(n1);

        // Sample 2: null
        System.out.print("Sample 2: ");
        printCircular(null);
    }
}
