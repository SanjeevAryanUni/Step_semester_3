package week11.class_problems;

public class RemoveFirstKNodes {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Removes the first k nodes from a singly linked list.
     * Time Complexity: O(min(k, n))
     * Space Complexity: O(1)
     */
    public static Node removeFirstKNodes(Node head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        for (int i = 0; i < k; i++) {
            if (head == null) {
                break;
            }
            head = head.next;
        }
        return head;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("(empty list)");
            return;
        }
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
        // Sample 1: 1 -> 2 -> 3 -> 4 -> 5, k = 2
        Node h1 = new Node(1);
        h1.next = new Node(2);
        h1.next.next = new Node(3);
        h1.next.next.next = new Node(4);
        h1.next.next.next.next = new Node(5);

        h1 = removeFirstKNodes(h1, 2);
        System.out.print("Sample 1: ");
        printList(h1);

        // Sample 2: 1 -> 2, k = 5
        Node h2 = new Node(1);
        h2.next = new Node(2);

        h2 = removeFirstKNodes(h2, 5);
        System.out.print("Sample 2: ");
        printList(h2);
    }
}
