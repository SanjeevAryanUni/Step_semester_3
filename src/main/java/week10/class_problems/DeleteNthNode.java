package week10.class_problems;

public class DeleteNthNode {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Deletes the n-th node (1-based index) from a singly linked list.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Node deleteNthNode(Node head, int n) {
        if (head == null) {
            return null;
        }
        if (n == 1) {
            return head.next;
        }

        Node curr = head;
        for (int i = 0; i < n - 2 && curr != null; i++) {
            curr = curr.next;
        }

        if (curr != null && curr.next != null) {
            curr.next = curr.next.next;
        }

        return head;
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
        // Sample 1: 10 -> 20 -> 30 -> 40, n = 3
        Node h1 = new Node(10);
        h1.next = new Node(20);
        h1.next.next = new Node(30);
        h1.next.next.next = new Node(40);

        h1 = deleteNthNode(h1, 3);
        System.out.print("Sample 1: ");
        printList(h1);

        // Sample 2: 10 -> 20 -> 30 -> 40, n = 1
        Node h2 = new Node(10);
        h2.next = new Node(20);
        h2.next.next = new Node(30);
        h2.next.next.next = new Node(40);

        h2 = deleteNthNode(h2, 1);
        System.out.print("Sample 2: ");
        printList(h2);
    }
}
