package week10.class_problems;

public class CountNodes {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Counts the total number of nodes in a singly linked list.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int countNodes(Node head) {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static void main(String[] args) {
        // Sample 1: 5 -> 10 -> 15
        Node h1 = new Node(5);
        h1.next = new Node(10);
        h1.next.next = new Node(15);
        System.out.println("Sample 1: " + countNodes(h1));

        // Sample 2: null
        System.out.println("Sample 2: " + countNodes(null));
    }
}
