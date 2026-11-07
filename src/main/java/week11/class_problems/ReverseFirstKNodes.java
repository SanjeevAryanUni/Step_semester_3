package week11.class_problems;

public class ReverseFirstKNodes {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Reverses only the first k nodes of a singly linked list.
     * The remaining nodes (k+1 onwards) remain in original relative order.
     * Time Complexity: O(k)
     * Space Complexity: O(1)
     */
    public static Node reverseFirstKNodes(Node head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        Node prev = null;
        Node curr = head;
        Node originalHead = head;

        for (int i = 0; i < k && curr != null; i++) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Connect tail of reversed section (originalHead) to the (k+1)-th node (curr)
        originalHead.next = curr;

        return prev;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample 1: 1 -> 2 -> 3 -> 4 -> 5, k = 3
        Node h1 = new Node(1);
        h1.next = new Node(2);
        h1.next.next = new Node(3);
        h1.next.next.next = new Node(4);
        h1.next.next.next.next = new Node(5);

        h1 = reverseFirstKNodes(h1, 3);
        System.out.print("Sample 1: ");
        printList(h1);

        // Sample 2: 1 -> 2 -> 3 -> 4 -> 5, k = 5
        Node h2 = new Node(1);
        h2.next = new Node(2);
        h2.next.next = new Node(3);
        h2.next.next.next = new Node(4);
        h2.next.next.next.next = new Node(5);

        h2 = reverseFirstKNodes(h2, 5);
        System.out.print("Sample 2: ");
        printList(h2);
    }
}
