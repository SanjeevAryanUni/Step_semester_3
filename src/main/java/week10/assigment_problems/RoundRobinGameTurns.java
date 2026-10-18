package week10.assigment_problems;

public class RoundRobinGameTurns {
    public static class Node {
        public String name;
        public Node next;

        public Node(String name) {
            this.name = name;
            this.next = null;
        }
    }

    public static class CircularLinkedList {
        private Node tail;

        public CircularLinkedList() {
            this.tail = null;
        }

        // Time Complexity: O(1)
        public void addLast(String name) {
            Node newNode = new Node(name);
            if (tail == null) {
                tail = newNode;
                tail.next = tail;
            } else {
                newNode.next = tail.next;
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Time Complexity: O(turns)
        public void printTurns(int turns) {
            if (tail == null || turns <= 0) return;
            Node curr = tail.next; // head
            for (int i = 0; i < turns; i++) {
                System.out.print(curr.name);
                if (i < turns - 1) {
                    System.out.print(" ");
                }
                curr = curr.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularLinkedList game = new CircularLinkedList();
        game.addLast("Asha");
        game.addLast("Ravi");
        game.addLast("Neha");

        // Expected Output: Asha Ravi Neha Asha Ravi Neha Asha
        game.printTurns(7);
    }
}
