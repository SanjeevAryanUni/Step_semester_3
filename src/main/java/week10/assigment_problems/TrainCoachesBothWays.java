package week10.assigment_problems;

public class TrainCoachesBothWays {
    public static class Node {
        public String name;
        public Node prev;
        public Node next;

        public Node(String name) {
            this.name = name;
            this.prev = null;
            this.next = null;
        }
    }

    public static class TrainDoublyLinkedList {
        private Node head;
        private Node tail;

        public TrainDoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        // Time Complexity: O(1)
        public void addLast(String name) {
            Node newNode = new Node(name);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        // Time Complexity to find: O(n); unlinking: O(1)
        public boolean remove(String name) {
            Node curr = head;
            while (curr != null) {
                if (curr.name.equals(name)) {
                    if (curr == head && curr == tail) {
                        head = null;
                        tail = null;
                    } else if (curr == head) {
                        head = head.next;
                        head.prev = null;
                    } else if (curr == tail) {
                        tail = tail.prev;
                        tail.next = null;
                    } else {
                        curr.prev.next = curr.next;
                        curr.next.prev = curr.prev;
                    }
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }

        public void printForward() {
            System.out.print("Forward: ");
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.name);
                if (curr.next != null) {
                    System.out.print(" <-> ");
                }
                curr = curr.next;
            }
            System.out.println();
        }

        public void printBackward() {
            System.out.print("Backward: ");
            Node curr = tail;
            while (curr != null) {
                System.out.print(curr.name);
                if (curr.prev != null) {
                    System.out.print(" <-> ");
                }
                curr = curr.prev;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TrainDoublyLinkedList train = new TrainDoublyLinkedList();
        train.addLast("Engine");
        train.addLast("A1");
        train.addLast("B1");
        train.addLast("B2");
        train.addLast("Guard");

        train.remove("B1");

        // Expected Output:
        // Forward: Engine <-> A1 <-> B2 <-> Guard
        // Backward: Guard <-> B2 <-> A1 <-> Engine
        train.printForward();
        train.printBackward();
    }
}
