package week10.assigment_problems;

public class ReverseQueue {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Reverses the singly linked list in place.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Sample 1: 1 -> 2 -> 3 -> 4
        Node q1 = new Node(1);
        q1.next = new Node(2);
        q1.next.next = new Node(3);
        q1.next.next.next = new Node(4);

        q1 = reverse(q1);
        System.out.print("Sample 1: ");
        printList(q1); // Expected: 4 -> 3 -> 2 -> 1 -> null

        // Sample 2: 9
        Node q2 = new Node(9);
        q2 = reverse(q2);
        System.out.print("Sample 2: ");
        printList(q2); // Expected: 9 -> null
    }
}
