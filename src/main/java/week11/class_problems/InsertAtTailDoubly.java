package week11.class_problems;

public class InsertAtTailDoubly {
    public static class DNode {
        public int data;
        public DNode prev;
        public DNode next;

        public DNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    /**
     * Inserts a new node at the tail of a doubly linked list given the head.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static DNode insertAtTailDoubly(DNode head, int value) {
        DNode newNode = new DNode(value);
        if (head == null) {
            return newNode;
        }

        DNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.prev = curr;
        return head;
    }

    public static void printList(DNode head) {
        DNode curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) {
                System.out.print(" <-> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample 1: 1 <-> 2 <-> 3, value = 4
        DNode h1 = new DNode(1);
        DNode n2 = new DNode(2);
        DNode n3 = new DNode(3);
        h1.next = n2; n2.prev = h1;
        n2.next = n3; n3.prev = n2;

        h1 = insertAtTailDoubly(h1, 4);
        System.out.print("Sample 1: ");
        printList(h1);

        // Sample 2: head = null, value = 7
        DNode h2 = insertAtTailDoubly(null, 7);
        System.out.print("Sample 2: ");
        printList(h2);
    }
}
