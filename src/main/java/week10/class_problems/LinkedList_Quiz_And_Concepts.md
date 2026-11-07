# Week 10: Linked List Data Structures — Practice Quiz & Concept Answers

## Part B — Quiz Answers

1. **Q1**: What two primary pieces of information does each node in a singly linked list store?
   - **Answer**: **C. A data value and a reference to the next node**
2. **Q2**: Which statement accurately describes how a linked list manages its size compared to a traditional array?
   - **Answer**: **B. Linked lists grow and shrink one node at a time by allocating/deallocating memory dynamically.**
3. **Q3**: What is the fundamental reason that accessing the element at a specific 0-based index in a singly linked list is an O(n) operation?
   - **Answer**: **D. Direct access is not possible; one must traverse the links from the head until the i-th element is reached.**
4. **Q4**: What is the primary benefit of including a 'prev' reference in each node of a doubly linked list?
   - **Answer**: **C. It enables traversal of the list in both forward and backward directions.**
5. **Q5**: In a circular linked list, how is the 'end' of the list typically identified during a traversal that aims to visit each node exactly once?
   - **Answer**: **C. The traversal must stop when the 'current' pointer returns to the starting node (e.g., the head).**
6. **Q6**: When implementing linked list operations that might modify the original head using a 'dummy' or 'sentinel' node, what does it typically point to when returning?
   - **Answer**: **D. The actual head of the modified list, through its 'next' reference (dummy.next).**
7. **Q7**: In the fast and slow pointer technique used for detecting a cycle, what event indicates a cycle is present?
   - **Answer**: **C. The fast pointer eventually catches up and becomes equal to the slow pointer.**
8. **Q8**: What is the additional space complexity required for an iterative implementation of reversing a singly linked list in-place?
   - **Answer**: **C. O(1) because only a few pointers are used.**
9. **Q9**: When merging two sorted linked lists, what is the primary memory efficiency advantage of 'relinking' existing nodes?
   - **Answer**: **C. Relinking linked list nodes requires O(1) additional space, while merging arrays typically requires O(m+n) for a new array.**
10. **Q10**: What is a common programming error in linked list manipulation that results in the loss of all subsequent nodes?
    - **Answer**: **C. Overwriting a node's 'next' reference before saving a pointer to the original successor.**

---

## Part C — Concept Questions

### Question 1: Head vs. Tail Insertion Time Complexity
- **Head Insertion ($O(1)$)**: We already hold the `head` reference. Creating a new node, pointing its `next` to the current `head`, and updating `head` requires a constant number of pointer manipulations.
- **Tail Insertion without tail pointer ($O(n)$)**: We must traverse the entire list from `head` to locate the last node (`curr.next == null`), which takes $O(n)$ time.
- **Maintaining a Tail Reference**: A `tail` pointer provides direct access to the last node. We can perform `tail.next = newNode; tail = newNode;` in strictly $O(1)$ time.

### Question 2: Predecessor Requirement in Deletion (Singly vs. Doubly Linked List)
- **Singly Linked List**: A singly linked node only has a forward reference (`next`). To delete a node $X$, the link pointing *to* $X$ from its predecessor $P$ must be updated (`P.next = X.next`). Without a pointer to $P$, we cannot reach $P$ without traversing from `head`, making deletion $O(n)$.
- **Doubly Linked List**: Each node contains a back-pointer (`prev`). Given direct access to node $X$, we can directly reach its predecessor via `X.prev` and its successor via `X.next`, updating `X.prev.next = X.next` and `X.next.prev = X.prev` in $O(1)$ time without traversal.

### Question 3: Traversal Performance: Arrays vs. Linked Lists (CPU Cache Locality)
- **Arrays**: Elements are stored in contiguous memory blocks. CPUs leverage **spatial locality**—when an array element is accessed, an entire cache line containing subsequent elements is preloaded into the high-speed L1/L2/L3 cache, minimizing cache misses.
- **Linked Lists**: Nodes are allocated dynamically on the heap at disparate, non-contiguous memory addresses. Traversing a linked list involves pointer chasing (`curr = curr.next`), which frequently incurs CPU cache misses and requires fetching data from slower main RAM.

### Question 4: Merging Sorted Linked Lists vs. Arrays (Space Complexity)
- **Linked Lists via Relinking**: The algorithm only adjusts existing `next` pointers between existing nodes. No new node allocations or array allocations occur, resulting in **$O(1)$ auxiliary space complexity**.
- **Arrays via Copying**: Fixed-size arrays cannot dynamically insert elements between one another. Merging two arrays of size $m$ and $n$ requires allocating a brand-new array of size $m + n$ and copying elements into it, requiring **$O(m + n)$ auxiliary space**.

### Question 5: Role of the 'next' Pointer & Traversal Termination
- **Role of `next` pointer**: The `next` pointer provides the unidirectional navigational link that connects each discrete, non-contiguous heap-allocated node to its logical successor.
- **Termination Condition**: `curr != null` (or in a while loop checking `curr.next != null` for the tail).
- **Why it is reliable**: In a standard linear singly linked list, the final node's `next` field is explicitly set to `null` to mark the end of the sequence. Any traversal loop checking `while (curr != null)` will safely and deterministically terminate upon exhausting all nodes.
