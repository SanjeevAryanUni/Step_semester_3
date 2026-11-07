package week11.class_problems;

public class SplitListInHalf {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Splits a singly linked list into two halves using fast and slow pointers.
     * If odd, the first half contains the extra middle node.
     * Terminates the first half and returns the head of the second half.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Node splitListInHalf(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        // When fast reaches end or one before end, slow will be at the end of first half
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalfHead = slow.next;
        slow.next = null; // properly terminate first half
        return secondHalfHead;
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
        // Sample 1: 1 -> 2 -> 3 -> 4 -> 5 (Odd length)
        Node h1 = new Node(1);
        h1.next = new Node(2);
        h1.next.next = new Node(3);
        h1.next.next.next = new Node(4);
        h1.next.next.next.next = new Node(5);

        Node second1 = splitListInHalf(h1);
        System.out.print("First half: ");
        printList(h1);
        System.out.print("Returned: ");
        printList(second1);

        // Sample 2: 1 -> 2 -> 3 -> 4 (Even length)
        Node h2 = new Node(1);
        h2.next = new Node(2);
        h2.next.next = new Node(3);
        h2.next.next.next = new Node(4);

        Node second2 = splitListInHalf(h2);
        System.out.print("First half: ");
        printList(h2);
        System.out.print("Returned: ");
        printList(second2);
    }
}
