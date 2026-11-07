package week11.class_problems;

public class DeleteLastNodeDoubly {
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
     * Deletes the last node from a doubly linked list given the head reference.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static DNode deleteLastNodeDoubly(DNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        DNode curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }

        DNode lastNode = curr.next;
        lastNode.prev = null;
        curr.next = null;
        return head;
    }

    public static void printList(DNode head) {
        if (head == null) {
            System.out.println("(empty list)");
            return;
        }
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
        // Sample 1: 1 <-> 2 <-> 3
        DNode h1 = new DNode(1);
        DNode n2 = new DNode(2);
        DNode n3 = new DNode(3);
        h1.next = n2; n2.prev = h1;
        n2.next = n3; n3.prev = n2;

        h1 = deleteLastNodeDoubly(h1);
        System.out.print("Sample 1: ");
        printList(h1);

        // Sample 2: head = 5
        DNode h2 = new DNode(5);
        h2 = deleteLastNodeDoubly(h2);
        System.out.print("Sample 2: ");
        printList(h2);
    }
}
