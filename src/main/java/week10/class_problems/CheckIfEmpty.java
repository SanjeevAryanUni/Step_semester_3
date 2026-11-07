package week10.class_problems;

public class CheckIfEmpty {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Checks if a singly linked list is empty.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public static boolean checkIfEmpty(Node head) {
        return head == null;
    }

    public static void main(String[] args) {
        System.out.println("Sample 1: " + checkIfEmpty(null));
        System.out.println("Sample 2: " + checkIfEmpty(new Node(8)));
    }
}
