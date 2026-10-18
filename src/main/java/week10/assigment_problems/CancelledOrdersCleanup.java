package week10.assigment_problems;

public class CancelledOrdersCleanup {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Removes every node with value equal to code and returns the new head.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static Node removeAll(Node head, int code) {
        // Remove matching nodes from the front
        while (head != null && head.data == code) {
            head = head.next;
        }

        if (head == null) return null;

        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == code) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Sample 1: 5 -> 3 -> 5 -> 8 -> 5, code = 5
        Node s1 = new Node(5);
        s1.next = new Node(3);
        s1.next.next = new Node(5);
        s1.next.next.next = new Node(8);
        s1.next.next.next.next = new Node(5);

        s1 = removeAll(s1, 5);
        System.out.print("Sample 1: ");
        printList(s1); // Expected: 3 -> 8 -> null

        // Sample 2: 5 -> 5 -> 5, code = 5
        Node s2 = new Node(5);
        s2.next = new Node(5);
        s2.next.next = new Node(5);

        s2 = removeAll(s2, 5);
        System.out.print("Sample 2: ");
        printList(s2); // Expected: null
    }
}
