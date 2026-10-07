# Week 9: Data Structures & Complexity Analysis — Quiz & Concept Answers

## Part B — Quiz Answers

1. **Q1**: What is the time complexity for accessing an element at a known index in a 1D array?
   - **Answer**: **B. O(1)** (Direct contiguous memory calculation: `base_address + index * element_size`).
2. **Q2**: The operation of adding a new element to a data structure is known as what?
   - **Answer**: **C. Insertion**
3. **Q3**: When choosing an appropriate data structure for a given problem, what is the most crucial step?
   - **Answer**: **C. Matching the required operations and constraints to the strengths of different data structures**
4. **Q4**: A software system stores frequently accessed calculations in a cache (extra memory) to avoid recomputing them. This scenario best illustrates what concept?
   - **Answer**: **C. Time vs space trade-offs**
5. **Q5**: A function has two distinct loops: first iterates $m$ times, second iterates $n$ times. What is the overall time complexity?
   - **Answer**: **B. O(m + n)**
6. **Q6**: In which type of data structure are elements arranged sequentially with one predecessor and one successor?
   - **Answer**: **C. Linear data structure**
7. **Q7**: An algorithm performs a number of operations proportional to $2n + 5$. What is its simplified Big-O complexity?
   - **Answer**: **C. O(n)**
8. **Q8**: Which of the following is an example of a non-primitive data structure?
   - **Answer**: **D. Linked list**
9. **Q9**: For a 2D array with $m$ rows and $n$ columns, what is the time complexity of visiting every element exactly once?
   - **Answer**: **B. O(m × n)**
10. **Q10**: What is the fundamental purpose of a data structure?
    - **Answer**: **C. To organize, store, and access data efficiently for specific operations**

---

## Part C — Concept Questions

### Question 1: Unsorted vs. Sorted 1D Array Search
- **Unsorted Array**: Requires **Linear Search** with **$O(n)$** time complexity because without ordering, every element must potentially be checked sequentially.
- **Sorted Array**: Allows **Binary Search** with **$O(\log n)$** time complexity.
- **Fundamental Reason**: The sorted property provides relational information ($A[mid] < target$ or $A[mid] > target$), enabling the algorithm to eliminate half of the remaining search space at every step.

### Question 2: Dropping Constant Multipliers in Big-O
- Big-O notation measures **asymptotic growth rates** as input size $n$ approaches infinity ($n \to \infty$).
- A multiplier like $2$ affects wall-clock execution time by a constant factor but does not change the rate of growth. As $n$ grows arbitrarily large, $c \cdot n$ scales linearly, meaning $O(2n) \equiv O(n)$.

### Question 3: Traversal Strategy: Linear vs. Non-Linear
- **Linear Data Structures (Arrays/Linked Lists)**: Elements have a strict 1:1 predecessor-to-successor relationship. Traversal is sequential and unidirectional (start $\to$ end).
- **Non-Linear Data Structures (Trees/Graphs)**: Elements have hierarchical or 1-to-many / many-to-many relationships. Traversal requires recursive or queue/stack-based branching strategies (e.g., Pre-order, In-order, Post-order DFS, or Level-order BFS).
