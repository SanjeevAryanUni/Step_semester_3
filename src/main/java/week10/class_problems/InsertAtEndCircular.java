package week10.class_problems;

public class InsertAtEndCircular {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Inserts a new node at the logical end of a circular singly linked list.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Node insertAtEndCircular(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.next = head;
        return head;
    }

    public static void printCircular(Node head) {
        if (head == null) return;
        Node curr = head;
        do {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        } while (curr != head);
        System.out.println("(back to " + head.data + ")");
    }

    public static void main(String[] args) {
        // Sample 1: 1 -> 2 -> 3 -> (back to 1), value = 4
        Node h1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        h1.next = n2; n2.next = n3; n3.next = h1;

        h1 = insertAtEndCircular(h1, 4);
        System.out.print("Sample 1: ");
        printCircular(h1);

        // Sample 2: head = null, value = 9
        Node h2 = insertAtEndCircular(null, 9);
        System.out.print("Sample 2: ");
        printCircular(h2);
    }
}
